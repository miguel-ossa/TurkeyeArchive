package org.puntofa.it.eqbase.Facturacion.Turquia;

import tr.com.diyalogo.www.sendEArchiveXml.*;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;


public class SendFile implements Runnable  {

	public static final String 							BLANCO = " ";

	// Contadores de éxitos y fracasos en la llamada al web service
	private static 		int 							m_ok_counter = 0; /* Contador de operaciones OK */
	private static 		int 							m_err_counter = 0; /* Contador de operaciones KO */
	private static 		int 							m_warning_counter = 0; /* Contador de warnings */
	
	public static      boolean							bCancel = false;
	
	private static  	boolean							m_USAR_BD;

	// Propiedades de instancia
	private 			EArchiveSoapStub				m_oStub;
	private 			Connection 						m_myConn;
	private				Integer							m_numThread;

	// Esta lista es compartida por todos los threads
	public static 		List<Cbl_fact_turquia>			arCbl_fact_turquia;

	public SendFile()
	{
		// does nothing
	}
	
	public static void setUSAR_BD(boolean pUSAR_BD)
	{
		m_USAR_BD = pUSAR_BD;
	}
	
	// Métodos para registrar el número de llamadas correctas e incorrectas
	public synchronized void incCounter() { m_ok_counter++; }
	public synchronized void incErr_counter() { m_err_counter++; }
	public synchronized void incWarning_counter() { m_warning_counter++; }
	
	// Métodos para monitorizar desde el thread principal (clase Main)
	public synchronized static int getCounter() { return m_ok_counter; }
	public synchronized static int getErr_counter() { return m_err_counter; }
	public synchronized static int getWarning_counter() { return m_warning_counter; }


	/*
	 * Llamada al web service
	 */
	private String callWebService(String p_strXml, String pNUM_FACTURA_2363)
	{
		String result = null;
		boolean error;
		int timeout = 300; // timeout = 5m
    	long startTime = System.nanoTime();
    	long endTime = 0;
    	long duration = 0;
		//Main.logger.log(Level.INFO, "Factura: " + pNUM_FACTURA_2363);
		String entorno = System.getenv("VOL");
		if (entorno == null)
			entorno = "none";

		
		// Se implementa un timeout de 5 minutos, en caso de que d� errores continuamente
		do
		{
			result = null;
			error = false;
			//try {
			//	Thread.sleep((long)(Math.random() * 1000));
			//} catch (InterruptedException e1) {
			//	if (m_USAR_BD)
			//	{
			//		Main.logger.log(Level.WARNING, e1.getMessage());
			//	}
			//}
			try
			{
				System.out.println("Inicio factura: " + pNUM_FACTURA_2363);
				if (entorno.equals("/MNG"))
	    		{
	    			result = m_oStub.sendEArchiveXml2("6120096964", "RKFQ2XT8", p_strXml);
	    		}
	    		else
	    		{
	    			result = m_oStub.sendEArchiveXml2("mango", "deCa3tep", p_strXml);
	    		}
				System.out.println("Fin factura: " + pNUM_FACTURA_2363);
				//result = "<?xml version=\"1.0\"?><Response><ResponseCode>-1</ResponseCode><ResponseDescription>Bu UUID li Fatura sistemde mevcut.</ResponseDescription><InvoiceURL>http://dfijasdfjdsfoijsdafodjsfojsdfji</InvoiceURL></Response>";
			} catch (RemoteException e) {
				if (m_USAR_BD)
				{
					Main.logger.log(Level.FINE, "Factura: " + pNUM_FACTURA_2363 + e.getMessage());
				}
				else
				{
					System.err.println(result);
				}
				error = true;
				incWarning_counter();
				//incErr_counter();
			}
			catch (Exception e) {
				if (m_USAR_BD)
				{
					Main.logger.log(Level.FINE, "Factura: " + pNUM_FACTURA_2363 + e.getMessage());
				}
				else
				{
					System.err.println(result);
				}
				error = true;
				incWarning_counter();
				//incErr_counter();
			}
			finally 
			{
				if ((error) || (result == null))
				{
					if ((m_USAR_BD) && !(error))
					{
						Main.logger.log(Level.WARNING, "Factura: " + pNUM_FACTURA_2363 + ", error en llamada al webservice");
					}
					try {
						// Retraso de 3s para el próximo intento
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						if (m_USAR_BD)
						{
							Main.logger.log(Level.WARNING, "Factura: " + pNUM_FACTURA_2363 + e.getMessage());
						}
					}
				}
			}
			// Control timeout por error
			if ((result == null) || (error))
			{
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000000;
				if (duration > timeout)
				{
					if (m_USAR_BD)
					{
						Main.logger.log(Level.FINE, "Factura: " + pNUM_FACTURA_2363 + " Aborting due too many errors!");
					}
					result = null;
					break;
				}
			}
		}
		while ((result == null) || (error));
		
		return result;
	}
	
	public SendFile(Connection p_Conn, EArchiveSoapStub p_Stub, Integer p_numThread)
	{
		m_myConn = p_Conn;
		m_oStub = p_Stub;
		m_numThread = p_numThread;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		String xmlResponse = null;
		Cbl_fact_turquia myCbl_fact_turquia = null;
		DataLayer myDataLayer = new DataLayer();
		myDataLayer.setConnection(m_myConn);
		bCancel = false;

		/*
		 * Vamos a buscar las filas pendientes de enviar al webservice
		 * Nos basamos en la columna ESTADO_2363, con estado = BLANCO
		 * 		
		 */
		Cbl_fact_turquia_2363 myCbl_fact_turquia_2363 = new Cbl_fact_turquia_2363();
		myCbl_fact_turquia = new Cbl_fact_turquia();
		String pEstadoInicial = null;

		Iterator<Cbl_fact_turquia> iterator = arCbl_fact_turquia.iterator();
		while (iterator.hasNext()) {

			if (bCancel)
			{
				System.out.println("Cancelling thread " + m_numThread.toString() + "...");
				break;
			}

			myCbl_fact_turquia = iterator.next();
			myCbl_fact_turquia_2363 = myCbl_fact_turquia.getCbl_fact_turquia_2363();

			/*if (!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("P")) && 
			!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("K")) &&
			!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("A")) &&
			!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("F")))*/
			if (!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("P")) && 
				!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("1")) &&
				!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("2")) &&
				!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("F")) &&
				!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("A")))
			{
				boolean exito = false;
				//synchronized(this) // es preciso sincronizar entre los diferentes threads
				synchronized(myCbl_fact_turquia_2363) // es preciso sincronizar entre los diferentes threads
				{
					/*if (!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("P")) && 
					!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("K")) &&
					!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("A")) &&
					!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("F")))*/
					if (!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("P")) && 
						!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("1")) &&
						!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("2")) &&
						!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("F")) &&
						!(myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("A")))
					{
						pEstadoInicial = myCbl_fact_turquia_2363.getESTADO_2363();
						// Se marca como pendiente para que otro thread no intente procesarla
						if ((myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("C")))
						{
							myCbl_fact_turquia_2363.setESTADO_2363("1");
							myCbl_fact_turquia.setCbl_fact_turquia_2363(myCbl_fact_turquia_2363); // cambiamos el estado a 1 = en proceso de factura provisional
							exito = true; // establecemos bandera
						}
						else
						{
							if ((myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("R")))
							{
								myCbl_fact_turquia_2363.setESTADO_2363("2");
								myCbl_fact_turquia.setCbl_fact_turquia_2363(myCbl_fact_turquia_2363); // cambiamos el estado a 2 = en proceso de cancelar
								exito = true; // establecemos bandera
							}
							else
							{
								myCbl_fact_turquia_2363.setESTADO_2363("P");
								myCbl_fact_turquia.setCbl_fact_turquia_2363(myCbl_fact_turquia_2363); // cambiamos el estado a P = en proceso
								exito = true; // establecemos bandera
							}
						}
					}
				} // End synchronized
				if (exito)
				{
					// Actualizar la fila como Pendiente
					myDataLayer.updateToBD(myCbl_fact_turquia);
		
					XmlInvoice myXml = new XmlInvoice(m_USAR_BD);
					String strXml = null;
					try
					{
						strXml = myXml.generateXml(myCbl_fact_turquia_2363);
					}
					catch(Exception e)
					{
						if (m_USAR_BD)
						{
							Main.logger.log(Level.INFO, myCbl_fact_turquia_2363.getNUM_FACTURA_2363() + 
											" error: " + e.getMessage());
						}
						else
						{
							System.err.println(myCbl_fact_turquia_2363.getNUM_FACTURA_2363() + 
									" error: " + e.getMessage());
						}
						
					}
		
					// Llamamos al web service
					xmlResponse = callWebService(strXml, myCbl_fact_turquia_2363.getNUM_FACTURA_2363());
					
					if (xmlResponse != null)
					{
						// Actualizar la fila en la BD con el ID de la nueva factura, la URL y el estado = F
						myXml.parseXMLString(xmlResponse);
						if (myXml.getResponseDescription().equals("OK"))
						{
							//
							myCbl_fact_turquia_2363.setURL_FACTURA_2363(myXml.getInvoiceURL());
							myCbl_fact_turquia_2363.setID_FACTURA_2363(myXml.getResponseCode());
							//if (myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("K"))
							if (myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("1"))
							{
								myCbl_fact_turquia_2363.setESTADO_2363("R"); // cambiamos el estado a R = facturacion provisional
							}
							else
							{
								if (myCbl_fact_turquia_2363.getESTADO_2363().trim().equals("2"))
								{
									myCbl_fact_turquia_2363.setESTADO_2363("A"); // cambiamos el estado a A = anulado
								}
								else
								{
									myCbl_fact_turquia_2363.setESTADO_2363("F"); // cambiamos el estado de P a F = facturado
								}
							}
							myCbl_fact_turquia.setCbl_fact_turquia_2363(myCbl_fact_turquia_2363);
							// Actualizar la fila como Facturada
							myDataLayer.updateToBD(myCbl_fact_turquia);
							incCounter();
						}
						else
						{
							String myResponse = myXml.getResponseDescription();
							if (m_USAR_BD)
							{
								Main.logger.log(Level.INFO, myCbl_fact_turquia_2363.getNUM_FACTURA_2363() + 
												" code: " + myXml.getResponseCode() + 
												" desc: ERROR EN LA GENERACION = " + myResponse);
							}
							incErr_counter();
							// Si dio problemas, se actualiza con la desc del error
							// en el campo URL_FACTURA_2363
							myCbl_fact_turquia_2363.setURL_FACTURA_2363(myResponse);
							myCbl_fact_turquia.setCbl_fact_turquia_2363(myCbl_fact_turquia_2363);
							if (!myResponse.contains("https")) 
							{
								// 10/05/2018: 
								// Reenvio automatico de errores de servidor Logo
								// Se deja la factura nuevamente como pendiente de facturar
								// y se envia email informativo
								if (myResponse.contains("Gecersiz") || 
									myResponse.contains("Could not find a part of the path") || 
									myResponse.contains("not enough space") ||
									myResponse.contains("timeout")) {
									myCbl_fact_turquia_2363.setESTADO_2363(" ");
									Mail.SendmailEInvoice("Error de Logo, se reintenta->" + myResponse, myCbl_fact_turquia_2363.getNUM_FACTURA_2363(), myCbl_fact_turquia_2363.getORIGEN_2363(), myCbl_fact_turquia_2363.getCODIGO_PEDIDO_2363());
								}
								else {
									myCbl_fact_turquia_2363.setESTADO_2363("M");
									Mail.SendmailEInvoice(myResponse, myCbl_fact_turquia_2363.getNUM_FACTURA_2363(), myCbl_fact_turquia_2363.getORIGEN_2363(), myCbl_fact_turquia_2363.getCODIGO_PEDIDO_2363());
								}
							}
							// Actualizar la fila en la BD
							myDataLayer.updateToBD(myCbl_fact_turquia);
						}
					}
					else
					{
						if (m_USAR_BD)
						{
							Main.logger.log(Level.INFO, myCbl_fact_turquia_2363.getNUM_FACTURA_2363() + 
											" code: " + myXml.getResponseCode() + 
											" desc: ERROR EN LA GENERACION = null");
						}
						incErr_counter();
						// Si dio problemas, se actualiza como Pendiente, con la desc del error
						// en el campo URL_FACTURA_2363
						myCbl_fact_turquia_2363.setURL_FACTURA_2363("ERROR EN LA GENERACION = null");
						myCbl_fact_turquia.setCbl_fact_turquia_2363(myCbl_fact_turquia_2363);
							// Actualizar la fila como Pendiente
						myDataLayer.updateToBD(myCbl_fact_turquia);
					}
				}
			}
		}
	}
}
