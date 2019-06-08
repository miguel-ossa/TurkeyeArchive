package org.puntofa.it.eqbase.Facturacion.Turquia;
//*******************************************************************************************************************//
// TurkeyeArchive																								     //
// ==============																									 //
//    Módulo Java para generar las facturas de Turquía pendientes en los archivos 2363 (cabeceras) y 234 (líneas).   //
//    La generación se realiza mediante la llamada a un web service del sistema e-Archive, de la empresa Logo en     //
//    Turquía.                                                                                                       //
//    Este módulo se ejecuta en el AIX, y es llamado por un programa Visual COBOL administrado (BASE0188).           //
//																													 //
// Miguel de la Ossa - Mango - Software de Base - 17/11/2015                                                         //
//																													 //
//*******************************************************************************************************************//
//
//
// Preferences->General->Editors->Text Editors->Spelling->Enable Spell Checking
// (para que no resalte todas las palabras que no entiende, que son la mayoría de comentarios)
//
import tr.com.diyalogo.www.sendEArchiveXml.*;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.apache.axis.AxisFault;

public class Main {
	//
	// Para parar de forma controlada, crear el archivo:
	//    $VOL/EXPL/TMP/TurkeyeArchive.stop
	//
	// NOTA: No se procesan más de 15000 facturas por sesión.
	// NOTA: Los errores quedan con ESTADO_2363 = 'P' y URL_FACTURA_2363 <> ' '
	//
	// ********************************* IMPORTANTE ******************************
	// Configuración de producción:
	// CREATE_SAMPLES = false
	// DEBUG = false
	// USAR_BD = true
	// NUM_THREADS = 5
	//-----------------------------------------------------------------------------
	// Configuración de pruebas sin acceso a BD, para ver xml generados en user.dir (en Windows):
	// CREATE_SAMPLES = false
	// DEBUG = true
	// USAR_BD = false
	// ********************************* IMPORTANTE ******************************
	//
    /*********************************************************************************/	
	public static final boolean CREATE_SAMPLES = false; // Creación de samples
	public static final boolean USAR_BD = true; // Usar acceso BD
	public static boolean DEBUG = false; // Mostrar mensajes de depuración
	//
	// CREATE_SAMPLES
	// --------------
	// Si se activa este indicador, solamente creará los registros ficticios y FINALIZARÁ.
	// Si USAR_BD está activado, los creará en la BD.
    /*********************************************************************************/	
	//
	// USAR_BD
	// -------
	// Si se activa este indicador, creará registros ficticios
	// y no accedera a la BD.
	// Tampoco borrará los xml creados, listos para ser enviados.
    /*********************************************************************************/	
	// DEBUG
	// -----
	// Muestra mensajes de depuración
    /*********************************************************************************/	
	//
	// Datos adicionales sobre la ocupación de memoria:
	// La cabecera ocupa 1307 bytes, y las líneas, 199
	// 15000 facturas con 40 líneas:
	// 15000*1307+199*40*15000 = 139.005.000 bytes == 132,6Mb
	public static final int NUM_THREADS = 1;
	public static final int NUM_SAMPLES = 1500;

	public static final String BLANCO = " ";
	public static Logger logger;

	static private final String m_localPathForTnsnames = "C:/oracle/product/12.1.0/client_1/network/admin/";
	static private final String m_serverPathForTnsnames = "/SOFTORACLE/product/11.2.0/client_1/network/admin/";
	static private final String m_localSID = "jdbc:oracle:thin:@IBDCOBOL";
	//static private final String m_localSID = "jdbc:oracle:thin:@DBDMNGV";
	static private final String m_serverSID = "jdbc:oracle:thin:@IBDCBL";
	static protected Connection m_myConn;
	static private URL m_myUrl;
	static private long m_startTime;
	static private long m_endTime;
	static private long m_load_duration;
	static private long m_invoices_duration;
	
	public DataLayer m_DataLayer;

	// static private String m_sEntorno;

	public Main() {
	}
	
	public int test(int number) {
		System.out.println("This is Java and I've received the number "
				+ number);
		return number + 1;
	}

	/*
	 * Creaciï¿½n de una muestra de datos para depuraciï¿½n. <p>
	 * 
	 * @param ninguno <p>
	 * 
	 * @return Lista de tipo Cbl_fact_turquia_2363 con una muestra de datos para
	 * insertar
	 */
	// private List<Cbl_fact_turquia> createListSample()
	private void createListSample() {
		// SendFile.arCbl_fact_turquia = new ArrayList<Cbl_fact_turquia>();

		// Antes de crear la muestra de datos para depuraciï¿½n, nos aseguramos
		// de que la tabla estï¿½ vacia
		// System.out.println("Deleting Cbl_fact_turquia_2363...");
		// m_DataLayer.deleteSamples();

		if (DEBUG)
		{
			System.out.println("Creando registros en Cbl_fact_turquia...");
		}
		// Creamos una muestra de n filas
		for (Integer i = 1; i < NUM_SAMPLES + 1; i++) {
			Cbl_fact_turquia myCbl_fact_turquia = new Cbl_fact_turquia();

			myCbl_fact_turquia.createSample(i);

			SendFile.arCbl_fact_turquia.add(myCbl_fact_turquia);

			myCbl_fact_turquia = null;
		}

		// return SendFile.arCbl_fact_turquia;
	}

	/*
	 * Obtener todos los registros pendientes de la tabla Cbl_fact_turquia_2363.
	 * Para pruebas, creamos una muestra con la funciï¿½n CreateSample. <p>
	 * 
	 * @param ninguno <p>
	 * 
	 * @return Lista de tipo Cbl_fact_turquia_2363
	 */
	// private List<Cbl_fact_turquia> getAllCbl_fact_turquia () throws
	// SQLException
	private void getAllCbl_fact_turquia(String pOrigen) throws SQLException {
		// List<Cbl_fact_turquia_2363> arCbl_fact_turquia_2363;

		if ((CREATE_SAMPLES) || !(USAR_BD)) {
			createListSample();
			m_DataLayer.createSamples();
		} else {
			if (USAR_BD)
			{
				m_DataLayer.fetch(pOrigen);
			}
			else
			{
				createListSample();
			}
		}

		// return SendFile.arCbl_fact_turquia;
	}

	private void activateLogging() {
		// get the MBean server
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		// create an ObjectName pattern
		ObjectName pattern = null;
		try {
			pattern = new ObjectName("com.oracle.jdbc:type=diagnosability,*");
		} catch (MalformedObjectNameException e1) {
			e1.printStackTrace();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		}
		// get the JDBC diagnosability ObjectName
		ObjectName diag = ((ObjectName[]) (mbs.queryNames(pattern, null)
				.toArray(new ObjectName[0])))[0];
		// enable logging
		try {
			mbs.setAttribute(diag, new Attribute("LoggingEnabled", true));
		} catch (InstanceNotFoundException e1) {
			e1.printStackTrace();
		} catch (InvalidAttributeValueException e1) {
			e1.printStackTrace();
		} catch (AttributeNotFoundException e1) {
			e1.printStackTrace();
		} catch (ReflectionException e1) {
			e1.printStackTrace();
		} catch (MBeanException e1) {
			e1.printStackTrace();
		}
		// disable logging
		// mbs.setAttribute(diag, new Attribute("LoggingEnabled", false));

	}

	/*
	 * Llamada desde JVM COBOL. <p>
	 * 
	 * Recibira los siguientes parametros: <p>
	 * 
	 * @param1 Path del archivo tnsnames.ora
	 * 
	 * @param2 SID de la BD
	 * 
	 * @param3 Usuario de conexion
	 * 
	 * @param4 Password de conexion <p>
	 * 
	 * @return 0 si exito, o SQLException
	 */
	public int runit(String pPathTnsnames, String pSid, String pUser,
			String pPasswd, int pNum_threads, int pDebug, String pOrigen) throws SQLException, Exception {

		JDBCLogHandler jdbcHandler = null;
		String entorno = System.getenv("VOL");
		if (entorno == null)
			entorno = "none";
		// Semáforo para parada controlada
		File fSemaphore = new File(entorno + File.separator + 
				                   "EXPL" + File.separator +
				                   "TMP" + File.separator +
				                   "TurkeyeArchive.stop");
 
		if (pOrigen.equals(""))
		{
			pOrigen = " ";
		}
		//
		if (pDebug == 1)
		{
			DEBUG = true;
			System.out.println("Parámetros recibidos:");
			System.out.println("pPathTnsnames=[" + pPathTnsnames + "]");
			System.out.println("pSid=[" + pSid + "]");
			System.out.println("pUser=[" + pUser + "]");
			System.out.println("pPasswd=[**********]");
			System.out.println("pDebug=[" + pDebug + "]");
			System.out.println("pOrigen=[" + pOrigen + "]");
			System.out.println("pNum_threads=[" + pNum_threads + "]");
		}
		else
		{
			DEBUG = false;
		}
		if (DEBUG)
		{
			System.out.println("DEBUG is set to true");
		}
		else
		{
			System.out.println("DEBUG is set to false");
		}
		// ---------------- Inicializaciones
		//
		// Necesario para forzar la utilización del proxy
		//System.setProperty("http.proxyHost", "proxy.intranet.mango.es");
		//System.setProperty("http.proxyPort", "8080");
		Mail.setDebug(DEBUG);
		Mail.setUsarBD(USAR_BD);
		DataLayer.setDebug(DEBUG);
		DataLayer.setUsarBD(USAR_BD);
		//
		// Instanciamos el DataLayer para comunicarnos con la BD
		m_DataLayer = new DataLayer(pPathTnsnames);
		if (USAR_BD) {
			m_myConn = m_DataLayer.Connect(pSid, pUser, pPasswd);
			activateLogging();
			// set up the JDBCLogger handler
			jdbcHandler = new JDBCLogHandler("oracle.jdbc.driver.OracleDriver",
					pSid, pUser, pPasswd);
			// jdbcHandler.clear();
			// Create a new logger object
			logger = Logger.getLogger("org.puntofa.it.eqbase.Facturacion.Turquia");
			logger.addHandler(jdbcHandler);
			logger.setLevel(Level.ALL);
			logger.log(Level.INFO, "Inicio");
		}

		m_startTime = System.nanoTime();
		
		ReadExemptionReasons Exemptions = new ReadExemptionReasons();
		Exemptions.parseXmlFile();
		if (pDebug == 1)
		{
			System.out.println("Cargando facturas en RAM...");
		}

		SendFile.setUSAR_BD(USAR_BD);
		// Creamos la matriz de facturas compartida (estática) con la que
		// trabajaran los threads
		SendFile.arCbl_fact_turquia = new ArrayList<Cbl_fact_turquia>();

		// Obtenemos los registros de la BD y los almacenamos en
		// SendFile.arCbl_fact_turquia
		getAllCbl_fact_turquia(pOrigen);

		if (USAR_BD)
		{
			logger.log(Level.INFO,
				"Facturas a procesar: " + SendFile.arCbl_fact_turquia.size());
			System.out.println("Facturas a procesar: " + SendFile.arCbl_fact_turquia.size());
		}

		if (CREATE_SAMPLES) {
			System.exit(0);
		}

		if (SendFile.arCbl_fact_turquia.size() == 0)
		{
			logger.log(Level.INFO,
					"Fin No hay registros");
			System.exit(0);
		}
		
		if (pDebug == 1)
		{
			System.out.println("Iniciando...");
		}
		try {
	    	if (entorno.equals("/MNG"))
	    	{
				m_myUrl = new URL(
						"https://pb.diyalogo.com.tr/earchive/earchive.asmx");
	    	}
	    	else
	    	{
				m_myUrl = new URL(
						"http://pbtest.diyalogo.com.tr/earchive/eArchive.asmx");
	    	}
		} catch (MalformedURLException e3) {
			if (USAR_BD)
			{
				logger.log(Level.SEVERE, e3.getMessage());
			}
			System.exit(-1);
		}
		m_endTime = System.nanoTime();
		m_load_duration = (m_endTime - m_startTime) / 1000000000;

		long patience = 7000 * 60 * 60; // lï¿½mite de 7 horas
		if (pDebug == 1)
		{
			patience = 1000 * 60 * 60; // para pruebas, una hora de lï¿½mite
		}
		m_startTime = System.nanoTime();

		EArchiveSoapStub oStub = null;
		try {
			oStub = new EArchiveSoapStub(m_myUrl, null);
		} catch (AxisFault e3) {
			if (USAR_BD)
			{
				logger.log(Level.SEVERE, e3.getMessage());
			}
			System.exit(-1);
		}

		// Creamos un array de n threads
		List<Thread> arThread = new ArrayList<Thread>();
		try {
			for (Integer countThreads = 1; countThreads < pNum_threads + 1; countThreads++) {
				Thread t = new Thread(new SendFile(m_myConn, oStub, countThreads));
				t.start();
				arThread.add(t);
				System.out.println("Creando thread " + countThreads.toString()); // temporal
			}
		} catch (Exception e3) {
			if (USAR_BD)
			{
				logger.log(Level.SEVERE, e3.getMessage());
			}
			System.exit(-1);
		}
		boolean executionFinished = false;
		do {
			/*
			if (SendFile.getCounter() != 0) {
				m_endTime = System.nanoTime();
				m_invoices_duration = (m_endTime - m_startTime) / 1000000000;
			}
			*/
			Iterator<Thread> iterator = arThread.iterator();
			while (iterator.hasNext()) {
				// Comprobamos petición de parada
				if (fSemaphore.exists())
				{
					SendFile.bCancel = true;
					System.out.println("Encontrado semáforo. Enviando señal a todos los threads...");
					break;
				}
				//
				Thread t;
				t = iterator.next();
				try {
					if (t.isAlive()) {
						t.join(10000);
					}
				} catch (InterruptedException e) {
					if (USAR_BD)
					{
						logger.log(Level.SEVERE, e.getMessage());
					}
					System.exit(-1);
				}
				// Si sobrepasamos el tiempo, mataremos el thread
				if ((((System.currentTimeMillis() - m_startTime) > patience) || SendFile.bCancel)
						&& (t.isAlive())) {
					if (USAR_BD)
					{
						logger.setLevel(Level.INFO);
						logger.info("Warning! Se ha sobrepasado el tiempo y se cancelan los threads!");
						logger.setLevel(Level.ALL);
					}
					if (t.isAlive()) {
						t.interrupt();
						// Shouldn't be long now
						// -- wait 3 segundos
						try {
							t.join(3000);
						} catch (InterruptedException e) {
							if (USAR_BD)
							{
								logger.log(Level.WARNING, e.getMessage());
							}
						}
					}
				}
			}
			// Comprobamos si hemos finalizado
			executionFinished = true;
			// Comprobamos petición de parada
			if (!(SendFile.bCancel) && (fSemaphore.exists()))
			{
				SendFile.bCancel = true;
			}
			//
			if (!SendFile.bCancel)
			{
				Iterator<Thread> iterator2 = arThread.iterator();
				while (iterator2.hasNext()) {
					Thread t2;
					t2 = iterator2.next();
					if (t2.isAlive()) {
						executionFinished = false;
						try {
							t2.join(10000);
						} catch (InterruptedException e) {
							if (USAR_BD)
							{
								logger.log(Level.WARNING, e.getMessage());
							}
						}
					}
				}
			}
		} while (!executionFinished);
		
		String sReport = "";
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			if (USAR_BD)
			{
				logger.log(Level.WARNING, e.getMessage());
			}
		}

		if ( SendFile.getCounter() != 0 ) {
		   m_endTime = System.nanoTime();
		   m_invoices_duration = (m_endTime - m_startTime) / 1000000000;
		   
		   sReport = "Facturas generadas=" + SendFile.getCounter() + "\n" +
		            		 "Errores=" + SendFile.getErr_counter() + "\n" +
                    		 "Warnings=" + SendFile.getWarning_counter() + "\n\n" +
		            		 "Tiempo total (seg)=" + (m_load_duration + m_invoices_duration) + "\n" +
		                    "Tiempo de carga (seg)=" + m_load_duration + "\n" +
		   		         "Tiempo facturacion (seg)=" + m_invoices_duration + "\n" +
		   		         "Threads utilizados=" + pNum_threads + "\n";
           
		   // Comprobar si han quedado facturas pendientes (con contenido en URL_FACTURA_2363 y ESTADO_2363 <> 'F')
		   // Se enviara e-mail a eqp.base@mango.com
		   try {
		   		m_DataLayer.fetchErrors(sReport, SendFile.bCancel, pOrigen);
		   } catch (IOException e) {
		   		Main.logger.log(Level.WARNING, "fetchErrors: " + e.getMessage());
		   } catch (InterruptedException e) {
		   		Main.logger.log(Level.WARNING, "fetchErrors: " + e.getMessage());
		   }
		}

		// Esperamos 10 segundos para asegurarnos de que los contadores estï¿½n
		// ok
		System.out.println("\nFinalizando...");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			if (USAR_BD)
			{
				logger.log(Level.WARNING, e.getMessage());
			}
		}

		if (USAR_BD)
		{
			logger.log(Level.INFO,
				"Fin " +  sReport);
		}
		else
		{
			System.out.println("\nFin " + sReport);
		}

		// Borramos el semáforo
		fSemaphore.delete();
		return 0;
	}

	/**
	 * Obtiene los ID de las facturas de Turquï¿½a pendientes para el dï¿½a
	 * actual.
	 * <p>
	 * 
	 * @param ninguno
	 *            <p>
	 * 
	 * @return nada
	 */
	public static void main(String[] args) throws RemoteException,
			SQLException, MalformedURLException, Exception {
/*		
		Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Shutdown hook ran!");
                Thread.currentThread().interrupt();
            }
        });
*/
		String sPathTnsnames = null;
		String sSid = null;
		String sUser = null;
		String sPasswd = null;
		String sOrigen = null;

		File tnsNamesLocal = new File(m_localPathForTnsnames + "tnsnames.ora");
		/* Parmenides o Zenon */
		File tnsNamesServer = new File(m_serverPathForTnsnames + "tnsnames.ora");

		if (tnsNamesLocal.exists()) { /* Mi PC */
			sPathTnsnames = m_localPathForTnsnames;
			sSid = m_localSID;
		} else if (tnsNamesServer.exists()) { /* Parmenides o Zenon */
			sPathTnsnames = m_serverPathForTnsnames;
			sSid = m_serverSID;
		} else {
			System.out.println("Couldn't find admin directory!");
			System.exit(-1);
		}

		// Para IBDCOBOL
		sUser = "CBL_OWNER";
		sPasswd = "aMg1mGc4";
		sOrigen = " "; // " " = todas, (T)iendas, (O)nline 

		// Para DBDMNGV 
		//sUser = "CBL_OWNER";
		//sPasswd = "jcip85HD";

		Main myProgram = new Main();
		int pDebug = 1;
		if (DEBUG)
		{
			pDebug = 1;
		}
		myProgram.runit(sPathTnsnames, sSid, sUser, sPasswd, NUM_THREADS, pDebug, sOrigen);

	}

}
