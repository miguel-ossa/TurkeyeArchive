package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;

/*
 * Clase para el acceso a la BD
 */
public class DataLayer {

	private				Connection  m_Conn;
	
	private String m_Sid;
	private String m_User;
	private String m_Passwd;
	private static boolean m_DEBUG;
	private static boolean m_USAR_BD; 

	// Constructor
	public DataLayer()
	{
		// Does nothing
	}
	
	public DataLayer(String p_pathTnsnames)
	{
		System.setProperty("oracle.net.tns_admin", p_pathTnsnames);
	}
	
	public static void setDebug(boolean pDEBUG)
	{
		m_DEBUG = pDEBUG;
		if (m_DEBUG)
		{
			System.out.println("DEBUG = True");
		}
		else
		{
			System.out.println("DEBUG = False");
		}
	}
	
	public static void setUsarBD(boolean pUSAR_BD)
	{
		m_USAR_BD = pUSAR_BD;
	}
	
	public void setConnection(Connection p_Conn)
	{
		m_Conn = p_Conn;
	}
	public Connection getConnection()
	{
		return m_Conn;
	}
	
	
    /*
     * Establecer la conexiï¿½n con la BD.
     * <p>
     * 
     * @param1	SID de la BD
     * @param2	Usuario de la BD
     * @param3	Password
     * <p>
     * 
     * @return 	Conexiï¿½n a la BD
     */
    public Connection Connect(String pSid, String pUser, String pPasswd) {

    	m_Sid = pSid;
    	m_User = pUser;
    	m_Passwd = pPasswd;
    	
    	if (m_DEBUG)
    	{
    		System.out.println("-------- Oracle JDBC SID Connection Testing ------");
    	}
		/* Mi PC */
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.getStackTrace();
			System.exit(-1);
			return null;
		}

		if (m_DEBUG)
		{
			System.out.println("Oracle JDBC Driver Registered!");
		}

		try {

			if (m_USAR_BD)
			{
				m_Conn = DriverManager.getConnection(m_Sid, m_User, m_Passwd);
			}

		} catch (SQLException e) {

			System.err.println("There is no DB connection available!");
			e.getStackTrace();
			System.exit(-1);
			return null;
		}

		if (m_Conn != null) {
			return m_Conn;
		} else {
			System.err.println("Failed to make connection!");
			System.exit(-1);
			return null;
		}
	}
    
    public void createSamples() throws SQLException
    {
    	if (m_USAR_BD)
    	{
    		Integer counter = 0;
    		DatabaseMetaData dbmData = m_Conn.getMetaData();
    		PreparedStatement myPreparedStatementCab = null;
    		PreparedStatement myPreparedStatementDet = null;
    		Iterator<Cbl_fact_turquia_det_2364> iteratorDet;
    		String sStatementCab = Cbl_fact_turquia_2363.prepareInsertCab();
    		myPreparedStatementCab = m_Conn.prepareStatement(sStatementCab);
    		String sStatementDet = Cbl_fact_turquia_det_2364.prepareInsertDet();
    		myPreparedStatementDet = m_Conn.prepareStatement(sStatementDet);

    		Iterator<Cbl_fact_turquia> iterator = SendFile.arCbl_fact_turquia.iterator();
    		while (iterator.hasNext()) {
    			if (dbmData.supportsBatchUpdates())
    			{
    				Cbl_fact_turquia myCbl_fact_turquia = new Cbl_fact_turquia();
		
    				myCbl_fact_turquia = iterator.next();

    				myPreparedStatementCab = Cbl_fact_turquia_2363.createInsertCab(myPreparedStatementCab, myCbl_fact_turquia);
    				try
    				{
    					myPreparedStatementCab.executeUpdate();
    					myPreparedStatementCab.clearParameters();
    				}
    				finally
    				{
    					if (myPreparedStatementCab != null)
    					{
    						myPreparedStatementCab.close();
    						myPreparedStatementCab = m_Conn.prepareStatement(sStatementCab);
    					}
    				}
				
    				myPreparedStatementDet = m_Conn.prepareStatement(sStatementDet);

    				iteratorDet = myCbl_fact_turquia.getCbl_fact_turquia_2363().getArCbl_fact_turquia_det_2364().iterator();
    				while (iteratorDet.hasNext()) {

    					Cbl_fact_turquia_det_2364 myCbl_fact_turquia_det_2364 = new Cbl_fact_turquia_det_2364();
    					myCbl_fact_turquia_det_2364 = iteratorDet.next();

    					myPreparedStatementDet = Cbl_fact_turquia_det_2364.createInsertDet(myPreparedStatementDet, myCbl_fact_turquia_det_2364);
    					try
    					{
    						myPreparedStatementDet.executeUpdate();
    						myPreparedStatementDet.clearParameters();
    					}
    					finally 
    					{
    						if (myPreparedStatementDet != null)
    						{
    							myPreparedStatementDet.close();
    							myPreparedStatementDet = m_Conn.prepareStatement(sStatementDet);
    						}
    						myCbl_fact_turquia_det_2364 = null;
    					}
    				}				


    				myCbl_fact_turquia = null;
				
    				m_Conn.commit();
				
    				iteratorDet = null;
				
    				Runtime.getRuntime().gc();

    				counter++;

    				// Dar un respiro al servidor...
    				System.out.println("Fila " + counter.toString() + " creada en la BD");
    				try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    		}
    		iterator = null;
    	}
    }

    /*
     * Recuperar todas las facturas con ESTADO_2363 no Facturado
     */
    public void fetch(String pOrigen) throws SQLException
    {
    	if (m_USAR_BD)
    	{
    		int counter = 0;
    		//int partial_counter = 0;
    		ResultSet rsCab = null;
    		String sPreparedStatementCab = null;
    		if (pOrigen.trim().equals(""))
    		{
    	    	if (m_DEBUG)
    			{
    				System.out.println("Cbl_fact_turquia_2363.prepareSelectCabecerasNuevas()");
    			}
    			sPreparedStatementCab = Cbl_fact_turquia_2363.prepareSelectCabecerasNuevas();
    		}
    		else if (pOrigen.equals("P"))
    		{
    	    	if (m_DEBUG)
    			{
    				System.out.println("Cbl_fact_turquia_2363.prepareSelectCabeceras()");
    			}
    			sPreparedStatementCab = Cbl_fact_turquia_2363.prepareSelectCabeceras();
    		}
    		else
    		{
    	    	if (m_DEBUG)
    			{
    				System.out.println("Cbl_fact_turquia_2363.prepareSelectCabecerasOrigenNuevas()");
    			}
    			sPreparedStatementCab = Cbl_fact_turquia_2363.prepareSelectCabecerasOrigenNuevas();
    		}
    			
    		String sPreparedStatementDet = Cbl_fact_turquia_det_2364.prepareSelectDetalle();
    		PreparedStatement myPreparedStatementDet;

    		// Cargamos las cabeceras
    		PreparedStatement myPreparedStatementCab = m_Conn.prepareStatement(sPreparedStatementCab);
    		if ((pOrigen.equals("T")) || (pOrigen.equals("O")))
    		{
    	    	if (m_DEBUG)
    			{
    				System.out.println("myPreparedStatementCab.setObject(1, pOrigen, java.sql.Types.VARCHAR)");
    			}
    			myPreparedStatementCab.setObject(1, pOrigen, java.sql.Types.VARCHAR);
    		}

    		rsCab = myPreparedStatementCab.executeQuery();
    		while (rsCab.next())
    		{
    			Cbl_fact_turquia myCbl_fact_turquia = new Cbl_fact_turquia();
    			Cbl_fact_turquia_2363 myCbl_fact_turquia_2363 = new Cbl_fact_turquia_2363();

    			String sKey = Cbl_fact_turquia_2363.getKey(rsCab);
    			myCbl_fact_turquia_2363.setRow(rsCab);
    		
    			// Cargamos las líneas
    			ResultSet rsDet = null;
    			myPreparedStatementDet = m_Conn.prepareStatement(sPreparedStatementDet);
    			myPreparedStatementDet.setObject(1, sKey, java.sql.Types.VARCHAR);

    			rsDet = myPreparedStatementDet.executeQuery();
    			while (rsDet.next())
    			{
    				Cbl_fact_turquia_det_2364 myCbl_fact_turquia_det_2364 = new Cbl_fact_turquia_det_2364();
    				
    				myCbl_fact_turquia_det_2364.setRow(rsDet);
    				myCbl_fact_turquia_2363.addDetalle(myCbl_fact_turquia_det_2364);
    				myCbl_fact_turquia_det_2364 = null;
    			}    		
    			rsDet.close();
    			myPreparedStatementDet.clearParameters();
    			myPreparedStatementDet.close();
    		
    			myCbl_fact_turquia.setCbl_fact_turquia_2363(myCbl_fact_turquia_2363);
    		
    			myCbl_fact_turquia_2363 = null;
    		
    			SendFile.arCbl_fact_turquia.add(myCbl_fact_turquia);
    		
    			myCbl_fact_turquia = null;
    		
    			//Runtime.getRuntime().gc();
    		
    			counter++;
    			//partial_counter++;
    			if ((counter % 10) == 0) {
    				if (m_DEBUG)
    				{
    					System.out.println(counter + " leidas...");
    				}
    			}
    			/*
    			if (partial_counter == 200)
    			{
    				partial_counter=0;
    				// Dar un respiro al servidor...
    				try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    			*/
    		}
			
    		rsCab.close(); 
    		myPreparedStatementCab.clearParameters();
    		myPreparedStatementCab.close();
    		}
    }

    /*
     * Actualizar la fila en la BD
     */
	public void updateToBD(Cbl_fact_turquia p_Cbl_fact_turquia) 
	{
    	String sTemplate[] = { "UPDATE Cbl_fact_turquia_2363 ",
                			   " 	SET ESTADO_2363 = ?,", // 1 VARCHAR
                			   "    	URL_FACTURA_2363 = ?,", // 2 VARCHAR 
                			   "		ID_FACTURA_2363 = ?", // 3 NUMBER
                			   "	WHERE NUM_FACTURA_2363 = ?" // 4 VARCHAR 
                			   };

		StringBuffer myString = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    		myString.append( sTemplate[i] );
    	}
    	
    	String sStatement = myString.toString();    
    	
    	if (m_USAR_BD)
    	{
    		PreparedStatement psStatement;
    		try {
    			psStatement = m_Conn.prepareStatement(sStatement);
    			psStatement.setObject(1, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getESTADO_2363(), java.sql.Types.VARCHAR);
    			psStatement.setObject(2, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getURL_FACTURA_2363(), java.sql.Types.VARCHAR);
    			psStatement.setObject(3, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getID_FACTURA_2363(), java.sql.Types.NUMERIC);
    			psStatement.setObject(4, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getNUM_FACTURA_2363(), java.sql.Types.VARCHAR);
    	
    			psStatement.execute();
    			psStatement.close();
    		} catch (SQLException e) {
    			Main.logger.log(Level.SEVERE, e.getMessage());
    			System.exit(-1);
    		}
    	}
	}

	public void deleteSamples()
	{
		if (m_USAR_BD)
		{
			Statement myDeleteStatement = null;
			try {
				myDeleteStatement = m_Conn.createStatement();
			} catch (SQLException e) {
				Main.logger.log(Level.SEVERE, e.getMessage());
				System.exit(-1);
			}
			try {
				myDeleteStatement.executeUpdate("DELETE FROM Cbl_fact_turquia_det_2364");
				myDeleteStatement.executeUpdate("DELETE FROM Cbl_fact_turquia_2363");
			} catch (SQLException e) {
				Main.logger.log(Level.SEVERE, e.getMessage());
				System.exit(-1);
			}
		}
	}
    /*
     * Recuperar todas las facturas con ESTADO_2363 no Facturado
     */
    public void fetchErrors(String pReport, boolean pbCancelled, String pOrigen) throws SQLException, IOException, InterruptedException
    {
    	if (m_USAR_BD)
    	{
    		boolean bFoundError = false;
    		String entorno = System.getenv("VOL");
    		File myErrorFile = null;
    		Integer random_number = (int) (Math.random() * 10000)+1;
    		if (entorno == null)
    		{
    			myErrorFile = new File(System.getProperty("user.dir") + File.separator + "log_errors_" + random_number.toString() + ".xml");	
    		}
    		else
    		{
    			myErrorFile = new File(File.separator + "tmp" + File.separator + "log_errors_" + random_number.toString() + ".xml");
    		}
    		PrintWriter writer = new PrintWriter(myErrorFile, "UTF-8");

			writer.println("");
			if (pbCancelled)
			{
				writer.println("El proceso ha sido cancelado por el usuario.");
				writer.println("");
			}
			writer.println(pReport);
			writer.println("");

    		ResultSet rsCab = null;
    		String sPreparedStatementErrors = null;
    		if ((pOrigen.trim().equals("")) || (pOrigen.trim().equals("P")))
    		{
    			sPreparedStatementErrors = Cbl_fact_turquia_2363.prepareSelectErrors();
    		}
    		else
    		{
    			sPreparedStatementErrors = Cbl_fact_turquia_2363.prepareSelectErrorsOrigen();
    		}


    		// Cargamos las cabeceras
    		PreparedStatement myPreparedStatementErrors = m_Conn.prepareStatement(sPreparedStatementErrors);
    		if ((!pOrigen.trim().equals("")) && (!pOrigen.trim().equals("P")))
    		{
    			myPreparedStatementErrors.setObject(1, pOrigen, java.sql.Types.VARCHAR);
    		}

    		rsCab = myPreparedStatementErrors.executeQuery();
    		while (rsCab.next())
    		{
    			Cbl_fact_turquia_2363 myCbl_fact_turquia_2363 = new Cbl_fact_turquia_2363();
    			myCbl_fact_turquia_2363.setRowErrors(rsCab);
    			
    			bFoundError = true;
    			writer.println("-------------------------------------------------------------------");
    			writer.println("Factura: " + myCbl_fact_turquia_2363.getNUM_FACTURA_2363());
    			writer.println("Origen : " + myCbl_fact_turquia_2363.getORIGEN_2363());
   				writer.println("Error  : " + myCbl_fact_turquia_2363.getURL_FACTURA_2363());
    		}
    		rsCab.close(); 
    		myPreparedStatementErrors.clearParameters();
    		myPreparedStatementErrors.close();
    		writer.close();

    		String sErrorFile = FileUtils.readFileToString(myErrorFile);
    			
    		Date date = new Date();
    		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    		if (bFoundError)
    		{
    			Mail.Sendmail("Relación de errores facturación Turquía (e-Archive) del día " + dateFormat.format(date), sErrorFile);
    		}
    		else
    		{
    			Mail.Sendmail("Facturas emitidas de Turquía (e-Archive) del día " + dateFormat.format(date), sErrorFile);
    		}
			Thread.sleep(3000);
    		myErrorFile.delete();
   		}
    }

}
