package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class JDBCLogHandler extends Handler {

	  /**
	   * Called to close this log handler.
	   */
	@Override
	  public void close()
	  {
	    try {
	      if ( connection!=null )
	        connection.close();
	    } catch ( SQLException e ) {
	      System.err.println("Error on close: " + e);
	    }
	  }

	  /**
	   * Not really used, but required to implement a handler. Since 
	   * all data is immediately sent to the database, there is no 
	   * reason to flush.
	   */
	@Override
	public void flush() {
	}

	  /**
	   * Overridden method used to capture log entries and put them
	   * into a JDBC database.
	   * 
	   * @param record The log record to be stored.
	   */
	@Override
	  public void publish(LogRecord record)
	  {
	    // first see if this entry should be filtered out
	    if ( getFilter()!=null ) {
	      if ( !getFilter().isLoggable(record) )
	        return;
	    }

	    // now store the log entry into the table
	    try {
	    	prepInsert.setInt(1,record.getLevel().intValue());
	    	prepInsert.setString(2,truncate(record.getLoggerName(),63));
	    	prepInsert.setString(3,truncate(record.getMessage(),255));
	    	prepInsert.setLong(4,record.getSequenceNumber());
	    	prepInsert.setString(5,truncate(record.getSourceClassName(),63));
	    	prepInsert.setString(6,truncate(record.getSourceMethodName(),31));
	    	prepInsert.setInt(7,record.getThreadID());
	    	prepInsert.setTimestamp(8,
	                              new Timestamp
	                                  (System.currentTimeMillis()) );
	    	prepInsert.executeUpdate();
	    } catch ( SQLException e ) {
	      System.err.println("Error on publish: " + e);
	    }
	    catch (Exception e ) {
		      System.err.println("Error on publish: " + e);
		    }
	  }

	 /**
	   * A string that contains the classname of the JDBC driver.
	   * This value is filled by the constructor.
	   */
	  String driverString;

	  /**
	   * A string that contains the connection string used by the
	   * JDBC driver. This value is filled by the constructor.
	   */
	  String connectionString;

	  /**
	   * Used to hold the connection to the JDBC data source.
	   */
	  Connection connection;

	  /**
	   * A SQL statement used to insert into the log table.
	   */
	  protected final static String insertSQL=
	  "INSERT INTO CBL_LOG_ERROR_JAVA_2377 "+
	               "(LEVEL_2377, " +
			       "LOGGER_2377, " +
	               "MESSAGE_2377, " +
			       "SEQUENCE_2377," +
			       "SOURCE_CLASS_2377, " +
			       "SOURCE_METHOD_2377, " +
			       "THREAD_ID_2377, " +
			       "TIME_ENTERED_2377)" +
			   "VALUES(?,?,?,?,?,?,?,?)";

	  /**
	   * A SQL statement used to clear the log table.
	   */
	  protected final static String clearSQL=
	  "DELETE FROM CBL_LOG_ERROR_JAVA_2377";

	  /**
	   * A PreparedStatement object used to hold the main
	   * insert statement.
	   */
	  protected PreparedStatement prepInsert;

	  /**
	   * A PreparedStatement object used to hold the clear
	   * statement.
	   */
	  protected PreparedStatement prepClear;


	  /**
	   * @param driverString The JDBC driver to use.
	   * @param connectionString The connection string that
	   * specifies the database to use.
	   */
	  public JDBCLogHandler(String driverString,
	                        String connectionString,
	                        String pUser,
	                        String pPasswd)
	  {
	    try {
	      this.driverString = driverString;
	      this.connectionString = connectionString;

	      Class.forName(driverString);
	      connection = DriverManager.getConnection(connectionString, pUser, pPasswd);
	      if (connection == null)
	      {
		      System.err.println("Error on open, cannot establish connection!");
	      }
	      prepInsert = connection.prepareStatement(insertSQL);
	      prepClear = connection.prepareStatement(clearSQL);
	    } catch ( ClassNotFoundException e ) {
	      System.err.println("Error on open: " + e);
	    } catch ( SQLException e ) {
	      System.err.println("Error on open: " + e);
	    }
	  }

	  /**
	   * Internal method used to truncate a string to a specified width.
	   * Used to ensure that SQL table widths are not exceeded.
	   * 
	   * @param str The string to be truncated.
	   * @param length The maximum length of the string.
	   * @return The string truncated.
	   */
	  static public String truncate(String str,int length)
	  {
	    if ( str.length()<length )
	      return str;
	    return( str.substring(0,length) );
	  }



	  /**
	   * Called to clear all log entries from the database.
	   */
	  public void clear()
	  {
	    try {
	      prepClear.executeUpdate();
	    } catch ( SQLException e ) {
	      System.err.println("Error on clear: " + e);
	    }
	  }

	    /*
	    SELECT 	
	    FROM java_log_nnnn
	    WHERE TRUNC(log_timeentered) = TRUNC(SYSDATE) AND
	    ORDER BY log_timeentered;
	     */
	    /*
	     * para cambiar el estado: UPDATE Cbl_fact_turquia_2363 SET ESTADO_2363 = ' '; COMMIT WORK;
	     */
	    public static String prepareSelectLog() throws SQLException
	    {
	    	String sTemplate[] = { "SELECT NUM_FACTURA_2363,", 
	    	    	 					"FECHA_2363,", 				
	    	    	 					"HORA_2363,", 				
	    	    	 					"TIENDA_2363,", 			
	    	    	 					"ESTADO_2363,", 			
	    	    	 					"UUID_2363,", 				
	    	    	 					"NOTE_2363,", 				
	    	    	 					"CURRENCY_CODE_2363,",
	    	    	 					"NUM_LINEAS_2363,", 	
	    	    	 					"SUP_PARTY_ID_2363,", 
	    	    	 					"SUP_PARTY_NAME_2363,",
	    	    	 					"SUP_POST_ID_2363,", 		
	    	    	 					"SUP_STREET_NAME_2363,",
	    	    	 					"SUP_BUILDING_NUM_2363,",
	    	    	 					"SUP_CITY_SUBDIV_NAME_2363,", 
	    	    	 					"SUP_CITY_NAME_2363,", 			
	    	    	 					"SUP_POSTAL_ZONE_2363,", 		
	    	    	 					"SUP_COUNTRY_2363,", 				
	    	    	 					"SUP_TAX_NAME_2363,", 			
	    	    	 					"SUP_TELF_2363,", 					
	    	    	 					"SUP_FAX_2363,", 				
	    	    	 					"SUP_EMAIL_2363,", 			
	    	    	 					"CUS_PARTY_ID_2363,", 	
	    	    	 					"CUS_PARTY_NAME_2363,", 
	    	    	 					"CUS_POST_ID_2363,", 		
	    	    	 					"CUS_STREET_NAME_2363,", 
	    	    	 					"CUS_BUILDING_NUM_2363,", 	
	    	    	 					"CUS_CITY_SUBDIV_NAME_2363,", 
	    	    	 					"CUS_CITY_NAME_2363,", 				
	    	    	 					"CUS_POSTAL_ZONE_2363,", 			
	    	    	 					"CUS_COUNTRY_2363,", 			
	    	    	 					"CUS_TAX_NAME_2363,", 		
	    	    	 					"CUS_TELF_2363,", 				
	    	    	 					"CUS_FAX_2363,", 					
	    	    	 					"CUS_EMAIL_2363,", 				
	    	    	 					"TAX_AMOUNT_2363,", 			
	    	    	 					"TAX_AMOUNT_ID_2363,", 		
	    	    	 					"TAXABLE_AMOUNT_2363,", 	
	    	    	 					"TAXABLE_AMOUNT_ID_2363,",
	    	    	 					"SUBTAX_AMOUNT_2363,", 		
	    	    	 					"SUBTAX_AMOUNT_ID_2363,",
	    	    	 					"TAX_EXEMPT_REASON_CODE_2363,",
	    	    	 					"TAX_TYPE_CODE_2363,", 		
	    	    	 					"LINE_EXT_AMOUNT_2363,", 	
	    	    	 					"LINE_EXT_AMOUNT_ID_2363,",
	    	    	 					"TAX_EXCLUS_AMOUNT_2363,", 
	    	    	 					"TAX_EXCLUS_AMOUNT_ID_2363,",
	    	    	 					"TAX_INCLUS_AMOUNT_2363,", 		
	    	    	 					"TAX_INCLUS_AMOUNT_ID_2363,", 
	    	    	 					"PAYABLE_AMOUNT_2363,", 			
	    	    	 					"PAYABLE_AMOUNT_ID_2363 ",	
	    	    	 				"FROM Cbl_fact_turquia_2363 ",
	    	    	 				"WHERE ESTADO_2363 <> 'F'"};
	    	
	    	StringBuffer result = new StringBuffer();
	    	for (int i = 0; i < sTemplate.length; i++) {
	    	   result.append( sTemplate[i] );
	    	}
	    	
	    	return result.toString();    
	    }
	    

}
