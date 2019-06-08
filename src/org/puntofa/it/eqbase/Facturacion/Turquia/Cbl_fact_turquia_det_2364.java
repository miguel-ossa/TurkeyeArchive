package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Clase que representa un registro de la tabla Cbl_fact_turquia_det_2364 (lineas facturas Turquia)
 */
public class Cbl_fact_turquia_det_2364 {

	// Clave principal
	private String 	m_NUM_FACTURA_2364;
	private int 	m_LINEA_2364;
	
	// Datos
	private int m_INVOICED_QUANTITY_2364;
	private BigDecimal m_LINE_EXT_AMOUNT_2364; // NUMBER(14,3)
	private String m_LINE_EXT_AMOUNT_ID_2364;
	private int m_ALLOW_CHARGE_INDICATOR_2364;
	private BigDecimal m_ALLOW_MULT_FAC_NUM_2364; // NUMBER(2,2)
	private BigDecimal m_ALLOW_AMOUNT_2364; // NUMBER(14,3)
	private String m_ALLOW_AMOUNT_CURR_ID_2364;
	private BigDecimal m_ALLOW_BASE_AMOUNT_2364; // NUMBER(14,3)
	private String m_ALLOW_BASE_CURR_ID_2364;
	private BigDecimal m_TAX_AMOUNT_2364; // NUMBER(14,3)
	private String m_TAX_AMOUNT_ID_2364;
	private BigDecimal m_TAXABLE_AMOUNT_2364; // NUMBER(14,3)
	private String m_TAXABLE_AMOUNT_ID_2364;
	private BigDecimal m_SUBTAX_AMOUNT_2364; // NUMBER(14,3)
	private String m_SUBTAX_AMOUNT_ID_2364;
	private BigDecimal m_PERCENT_2364; // NUMBER(3,3)
	private String m_TAX_NAME_2364;
	private String m_TAX_TYPE_CODE_2364;
	private String m_ITEM_NAME_2364;
	private String m_ITEM_DESC_2364;
	private BigDecimal m_PRECIO_2364; // NUMBER(14,3)
	private String m_PRECIO_ID_2364;
	
	public Cbl_fact_turquia_det_2364()
	{
		// nothing to be done
	}
	
	// NUM_FACTURA_2364
	public void setNUM_FACTURA_2364(String p_NUM_FACTURA_2364)
	{
		m_NUM_FACTURA_2364 = p_NUM_FACTURA_2364;
	}
	public String getNUM_FACTURA_2364()
	{
		return m_NUM_FACTURA_2364;
	}
	
	// LINEA_2364
	public void setLINEA_2364(int p_LINEA_2364)
	{
		m_LINEA_2364 = p_LINEA_2364;
	}
	public int getLINEA_2364()
	{
		return m_LINEA_2364;
	}
	public String getLINEA_2364_toString()
	{
		return Integer.toString(m_LINEA_2364);
	}
	
	// INVOICED_QUANTITY_2364
	public void setINVOICED_QUANTITY_2364(int p_INVOICED_QUANTITY_2364)
	{
		m_INVOICED_QUANTITY_2364 = p_INVOICED_QUANTITY_2364;
	}
	public int getINVOICED_QUANTITY_2364()
	{
		return m_INVOICED_QUANTITY_2364;
	}
	public String getINVOICED_QUANTITY_2364_toString()
	{
		return Integer.toString(m_INVOICED_QUANTITY_2364);
	}
	
	// LINE_EXT_AMOUNT_2364
	public void setLINE_EXT_AMOUNT_2364(BigDecimal p_LINE_EXT_AMOUNT_2364)
	{
		m_LINE_EXT_AMOUNT_2364 = p_LINE_EXT_AMOUNT_2364;
	}
	public BigDecimal getLINE_EXT_AMOUNT_2364()
	{
		return m_LINE_EXT_AMOUNT_2364;
	}
	public String getLINE_EXT_AMOUNT_2364_toString()
	{
		return m_LINE_EXT_AMOUNT_2364.toString();
	}
	
	// LINE_EXT_AMOUNT_ID_2364
	public void setLINE_EXT_AMOUNT_ID_2364(String p_LINE_EXT_AMOUNT_ID_2364)
	{
		m_LINE_EXT_AMOUNT_ID_2364 = p_LINE_EXT_AMOUNT_ID_2364;
	}
	public String getLINE_EXT_AMOUNT_ID_2364()
	{
		return m_LINE_EXT_AMOUNT_ID_2364;
	}
	
	// ALLOW_CHARGE_INDICATOR_2364
	public void setALLOW_CHARGE_INDICATOR_2364(int p_ALLOW_CHARGE_INDICATOR_2364)
	{
		m_ALLOW_CHARGE_INDICATOR_2364 = p_ALLOW_CHARGE_INDICATOR_2364;
	}
	public int getALLOW_CHARGE_INDICATOR_2364()
	{
		return m_ALLOW_CHARGE_INDICATOR_2364;
	}
	public String getALLOW_CHARGE_INDICATOR_2364_toString()
	{
		return Integer.toString(m_ALLOW_CHARGE_INDICATOR_2364);
	}

	// ALLOW_MULT_FAC_NUM_2364
	public void setALLOW_MULT_FAC_NUM_2364(BigDecimal p_ALLOW_MULT_FAC_NUM_2364)
	{
		m_ALLOW_MULT_FAC_NUM_2364 = p_ALLOW_MULT_FAC_NUM_2364;
	}
	public BigDecimal getALLOW_MULT_FAC_NUM_2364()
	{
		return m_ALLOW_MULT_FAC_NUM_2364;
	}
	public String getALLOW_MULT_FAC_NUM_2364_toString()
	{
		return m_ALLOW_MULT_FAC_NUM_2364.toString();
	}
	
	// ALLOW_AMOUNT_2364
	public void setALLOW_AMOUNT_2364(BigDecimal p_ALLOW_AMOUNT_2364)
	{
		m_ALLOW_AMOUNT_2364 = p_ALLOW_AMOUNT_2364;
	}
	public BigDecimal getALLOW_AMOUNT_2364()
	{
		return m_ALLOW_AMOUNT_2364;
	}
	public String getALLOW_AMOUNT_2364_toString()
	{
		return m_ALLOW_AMOUNT_2364.toString();
	}
	
	// ALLOW_CURR_ID_2364
	public void setALLOW_AMOUNT_CURR_ID_2364(String p_ALLOW_AMOUNT_CURR_ID_2364)
	{
		m_ALLOW_AMOUNT_CURR_ID_2364 = p_ALLOW_AMOUNT_CURR_ID_2364;
	}
	public String getALLOW_AMOUNT_CURR_ID_2364()
	{
		return m_ALLOW_AMOUNT_CURR_ID_2364;
	}
	
	// ALLOW_BASE_AMOUNT_2364
	public void setALLOW_BASE_AMOUNT_2364(BigDecimal p_ALLOW_BASE_AMOUNT_2364)
	{
		m_ALLOW_BASE_AMOUNT_2364 = p_ALLOW_BASE_AMOUNT_2364;
	}
	public BigDecimal getALLOW_BASE_AMOUNT_2364()
	{
		return m_ALLOW_BASE_AMOUNT_2364;
	}
	public String getALLOW_BASE_AMOUNT_2364_toString()
	{
		return m_ALLOW_BASE_AMOUNT_2364.toString();
	}
	
	// ALLOW_BASE_CURR_ID_2364
	public void setALLOW_BASE_CURR_ID_2364(String p_ALLOW_BASE_CURR_ID_2364)
	{
		m_ALLOW_BASE_CURR_ID_2364 = p_ALLOW_BASE_CURR_ID_2364;
	}
	public String getALLOW_BASE_CURR_ID_2364()
	{
		return m_ALLOW_BASE_CURR_ID_2364;
	}
	
	// TAX_AMOUNT_2364
	public void setTAX_AMOUNT_2364(BigDecimal p_TAX_AMOUNT_2364)
	{
		m_TAX_AMOUNT_2364 = p_TAX_AMOUNT_2364;
	}
	public BigDecimal getTAX_AMOUNT_2364()
	{
		return m_TAX_AMOUNT_2364;
	}
	public String getTAX_AMOUNT_2364_toString()
	{
		return m_TAX_AMOUNT_2364.toString();
	}
	
	// TAX_AMOUNT_ID_2364
	public void setTAX_AMOUNT_ID_2364(String p_TAX_AMOUNT_ID_2364)
	{
		m_TAX_AMOUNT_ID_2364 = p_TAX_AMOUNT_ID_2364;
	}
	public String getTAX_AMOUNT_ID_2364()
	{
		return m_TAX_AMOUNT_ID_2364;
	}
	
	// TAXABLE_AMOUNT_2364
	public void setTAXABLE_AMOUNT_2364(BigDecimal p_TAXABLE_AMOUNT_2364)
	{
		m_TAXABLE_AMOUNT_2364 = p_TAXABLE_AMOUNT_2364;
	}
	public BigDecimal getTAXABLE_AMOUNT_2364()
	{
		return m_TAXABLE_AMOUNT_2364;
	}
	public String getTAXABLE_AMOUNT_2364_toString()
	{
		return m_TAXABLE_AMOUNT_2364.toString();
	}
	
	// TAXABLE_AMOUNT_ID_2364
	public void setTAXABLE_AMOUNT_ID_2364(String p_TAXABLE_AMOUNT_ID_2364)
	{
		m_TAXABLE_AMOUNT_ID_2364 = p_TAXABLE_AMOUNT_ID_2364;
	}
	public String getTAXABLE_AMOUNT_ID_2364()
	{
		return m_TAXABLE_AMOUNT_ID_2364;
	}
	
	// SUBTAX_AMOUNT_2364
	public void setSUBTAX_AMOUNT_2364(BigDecimal p_SUBTAX_AMOUNT_2364)
	{
		m_SUBTAX_AMOUNT_2364 = p_SUBTAX_AMOUNT_2364;
	}
	public BigDecimal getSUBTAX_AMOUNT_2364()
	{
		return m_SUBTAX_AMOUNT_2364;
	}
	public String getSUBTAX_AMOUNT_2364_toString()
	{
		return m_SUBTAX_AMOUNT_2364.toString();
	}
	
	// SUBTAX_AMOUNT_ID_2364
	public void setSUBTAX_AMOUNT_ID_2364(String p_SUBTAX_AMOUNT_ID_2364)
	{
		m_SUBTAX_AMOUNT_ID_2364 = p_SUBTAX_AMOUNT_ID_2364;
	}
	public String getSUBTAX_AMOUNT_ID_2364()
	{
		return m_SUBTAX_AMOUNT_ID_2364;
	}
	
	// PERCENT_2364
	public void setPERCENT_2364(BigDecimal p_PERCENT_2364)
	{
		m_PERCENT_2364 = p_PERCENT_2364;
	}
	public BigDecimal getPERCENT_2364()
	{
		return m_PERCENT_2364;
	}
	public String getPERCENT_2364_toString()
	{
		return m_PERCENT_2364.toString();
	}
	
	// TAX_TYPE_CODE_2364
	public void setTAX_TYPE_CODE_2364(String p_TAX_TYPE_CODE_2364)
	{
		m_TAX_TYPE_CODE_2364 = p_TAX_TYPE_CODE_2364;
	}
	public String getTAX_TYPE_CODE_2364()
	{
		return m_TAX_TYPE_CODE_2364;
	}
	
	// TAX_NAME_2364
	public void setTAX_NAME_2364(String p_TAX_NAME_2364)
	{
		m_TAX_NAME_2364 = p_TAX_NAME_2364;
	}
	public String getTAX_NAME_2364()
	{
		return m_TAX_NAME_2364;
	}
	
	// ITEM_NAME_2364
	public void setITEM_NAME_2364(String p_ITEM_NAME_2364)
	{
		m_ITEM_NAME_2364 = p_ITEM_NAME_2364;
	}
	public String getITEM_NAME_2364()
	{
		return m_ITEM_NAME_2364;
	}
	
	// ITEM_DESC_2364
	public void setITEM_DESC_2364(String p_ITEM_DESC_2364)
	{
		m_ITEM_DESC_2364 = p_ITEM_DESC_2364;
	}
	public String getITEM_DESC_2364()
	{
		return m_ITEM_DESC_2364;
	}
	
	// PRECIO_2364
	public void setPRECIO_2364(BigDecimal p_PRECIO_2364)
	{
		m_PRECIO_2364 = p_PRECIO_2364;
	}
	public BigDecimal getPRECIO_2364()
	{
		return m_PRECIO_2364;
	}
	public String getPRECIO_2364_toString()
	{
		return m_PRECIO_2364.toString();
	}
	
	// PRECIO_ID_2364
	public void setPRECIO_ID_2364(String p_PRECIO_ID_2364)
	{
		m_PRECIO_ID_2364 = p_PRECIO_ID_2364;
	}
	public String getPRECIO_ID_2364()
	{
		return m_PRECIO_ID_2364;
	}
	
    /*
    SELECT LINEA_2364, 				
        	INVOICED_QUANTITY_2364, 	
        	LINE_EXT_AMOUNT_2364, 		
        	LINE_EXT_AMOUNT_ID_2364, 
        	ALLOW_CHARGE_INDICATOR_2364, 
        	ALLOW_MULT_FAC_NUM_2364, 		
        	ALLOW_AMOUNT_2364, 		
        	ALLOW_AMOUNT_CURR_ID_2364, 
        	ALLOW_BASE_AMOUNT_2364, 		
        	ALLOW_BASE_CURR_ID_2364, 	
        	TAX_AMOUNT_2364, 			
        	TAX_AMOUNT_ID_2364, 		
        	TAXABLE_AMOUNT_2364, 	
        	TAXABLE_AMOUNT_ID_2364,
        	SUBTAX_AMOUNT_2364, 		
        	SUBTAX_AMOUNT_ID_2364, 
        	PERCENT_2364, 	
        	TAX_NAME_2364, 			
        	TAX_TYPE_CODE_2364, 
        	ITEM_NAME_2364, 			
        	ITEM_DESC_2364, 			
        	PRECIO_2364, 				
        	PRECIO_ID_2364
    FROM  Cbl_fact_turquia_det_2364
    INNER JOIN Cbl_fact_turquia_2363 ON NUM_FACTURA_2364 = NUM_FACTURA_2363
    WHERE NUM_FACTURA_2364 = ?;
     */
    public static String prepareSelectDetalle() throws SQLException
    {
    	String sTemplate[] = { "SELECT LINEA_2364,", 	
    			                    "NUM_FACTURA_2364,",
    	    						"INVOICED_QUANTITY_2364,", 	
    	    						"LINE_EXT_AMOUNT_2364,", 		
    	    						"LINE_EXT_AMOUNT_ID_2364,", 
    	    						"ALLOW_CHARGE_INDICATOR_2364,", 
    	    						"ALLOW_MULT_FAC_NUM_2364,", 		
    	    						"ALLOW_AMOUNT_2364,", 		
    	    						"ALLOW_AMOUNT_CURR_ID_2364,", 
    	    						"ALLOW_BASE_AMOUNT_2364,", 		
    	    						"ALLOW_BASE_CURR_ID_2364,", 	
    	    						"TAX_AMOUNT_2364,", 			
    	    						"TAX_AMOUNT_ID_2364,", 		
    	    						"TAXABLE_AMOUNT_2364,", 	
    	    						"TAXABLE_AMOUNT_ID_2364,",
    	    						"SUBTAX_AMOUNT_2364,", 		
    	    						"SUBTAX_AMOUNT_ID_2364,", 
    	    						"PERCENT_2364,", 	
    	    						"TAX_NAME_2364,", 			
    	    						"TAX_TYPE_CODE_2364,", 
    	    						"ITEM_NAME_2364,", 			
    	    						"ITEM_DESC_2364,", 			
    	    						"PRECIO_2364,", 				
    	    						"PRECIO_ID_2364 ",
    	    					"FROM Cbl_fact_turquia_det_2364 ",
    	    					"INNER JOIN Cbl_fact_turquia_2363 ON NUM_FACTURA_2364 = NUM_FACTURA_2363 ",
    	    					"WHERE NUM_FACTURA_2364 = ?" };

    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }

    public static String prepareInsertDet() throws SQLException
    {
    	String sTemplate[] = { "INSERT INTO Cbl_fact_turquia_det_2364",
    			                       "(",
    			                       "NUM_FACTURA_2364,", 			// 1 VARCHAR2
    			                       "LINEA_2364,", 					// 2 NUMBER(2,0)
    			                       "INVOICED_QUANTITY_2364,", 		// 3 NUMBER(4,0)
    			                       "LINE_EXT_AMOUNT_2364,", 		// 4 NUMBER(14,3)
    			                       "LINE_EXT_AMOUNT_ID_2364,", 		// 5 VARCHAR2
    			                       "ALLOW_CHARGE_INDICATOR_2364,", 	// 6 NUMBER(1,0)
    			                       "ALLOW_MULT_FAC_NUM_2364,", 		// 7 NUMBER(1,0)
    			                       "ALLOW_AMOUNT_2364,", 			// 8 NUMBER(1,0)
    			                       "ALLOW_AMOUNT_CURR_ID_2364,", 	// 9 NUMBER(1,0)
    			                       "ALLOW_BASE_AMOUNT_2364,", 		// 10 NUMBER(1,0)
    			                       "ALLOW_BASE_CURR_ID_2364,", 		// 11 NUMBER(1,0)
    			                       "TAX_AMOUNT_2364,", 			// 12 NUMBER(14,3)
    			                       "TAX_AMOUNT_ID_2364,", 		// 13 VARCHAR2
    			                       "TAXABLE_AMOUNT_2364,", 		// 14 NUMBER(14,3)
    			                       "TAXABLE_AMOUNT_ID_2364,", 	// 15 VARCHAR2
    			                       "SUBTAX_AMOUNT_2364,", 		// 16 NUMBER(14,3)
    			                       "SUBTAX_AMOUNT_ID_2364,", 	// 17 VARCHAR2
    			                       "PERCENT_2364,", 			// 18 NUMBER(3,3)
    			                       "TAX_NAME_2364,", 			// 19 VARCHAR2
    			                       "TAX_TYPE_CODE_2364,", 		// 20 VARCHAR2
    			                       "ITEM_NAME_2364,", 			// 21 VARCHAR2
    			                       "ITEM_DESC_2364,", 			// 22 VARCHAR2
    			                       "PRECIO_2364,", 				// 23 NUMBER(14,3)
    			                       "PRECIO_ID_2364", 			// 24 VARCHAR2
    			                       ")", 
    			                    "VALUES (",
 			                       		"?,", // 1
 			                       		"?,", // 2
 			                       		"?,", // 3
 			                       		"?,", // 4
 			                       		"?,", // 5
 			                       		"?,", // 6
 			                       		"?,", // 7
 			                       		"?,", // 8
 			                       		"?,", // 9
 			                       		"?,", // 10
 			                       		"?,", // 11
 			                       		"?,", // 12
 			                       		"?,", // 13
 			                       		"?,", // 14
 			                       		"?,", // 15
 			                       		"?,", // 16
 			                       		"?,", // 17
 			                       		"?,", // 18
 			                       		"?,", // 19
 			                       		"?,", // 20
 			                       		"?,", // 21
 			                       		"?,", // 22
 			                       		"?,", // 23
 			                       		"?", // 24
 			                       		")" };
    	
    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }
    
    public static PreparedStatement createInsertDet(PreparedStatement pStatement, Cbl_fact_turquia_det_2364 p_Cbl_fact_turquia_det_2364) throws SQLException
    {
    	pStatement.setObject(1, p_Cbl_fact_turquia_det_2364.getNUM_FACTURA_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(2, p_Cbl_fact_turquia_det_2364.getLINEA_2364(), java.sql.Types.NUMERIC);

    	pStatement.setObject(3, p_Cbl_fact_turquia_det_2364.getINVOICED_QUANTITY_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(4, p_Cbl_fact_turquia_det_2364.getLINE_EXT_AMOUNT_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(5, p_Cbl_fact_turquia_det_2364.getLINE_EXT_AMOUNT_ID_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(6, p_Cbl_fact_turquia_det_2364.getALLOW_CHARGE_INDICATOR_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(7, p_Cbl_fact_turquia_det_2364.getALLOW_MULT_FAC_NUM_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(8, p_Cbl_fact_turquia_det_2364.getALLOW_AMOUNT_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(9, p_Cbl_fact_turquia_det_2364.getALLOW_AMOUNT_CURR_ID_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(10, p_Cbl_fact_turquia_det_2364.getALLOW_BASE_AMOUNT_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(11, p_Cbl_fact_turquia_det_2364.getALLOW_BASE_CURR_ID_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(12, p_Cbl_fact_turquia_det_2364.getTAX_AMOUNT_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(13, p_Cbl_fact_turquia_det_2364.getTAX_AMOUNT_ID_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(14, p_Cbl_fact_turquia_det_2364.getTAXABLE_AMOUNT_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(15, p_Cbl_fact_turquia_det_2364.getTAXABLE_AMOUNT_ID_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(16, p_Cbl_fact_turquia_det_2364.getSUBTAX_AMOUNT_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(17, p_Cbl_fact_turquia_det_2364.getSUBTAX_AMOUNT_ID_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(18, p_Cbl_fact_turquia_det_2364.getPERCENT_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(19, p_Cbl_fact_turquia_det_2364.getTAX_NAME_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(20, p_Cbl_fact_turquia_det_2364.getTAX_TYPE_CODE_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(21, p_Cbl_fact_turquia_det_2364.getITEM_NAME_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(22, p_Cbl_fact_turquia_det_2364.getITEM_DESC_2364(), java.sql.Types.VARCHAR);
    	pStatement.setObject(23, p_Cbl_fact_turquia_det_2364.getPRECIO_2364(), java.sql.Types.NUMERIC);
    	pStatement.setObject(24, p_Cbl_fact_turquia_det_2364.getPRECIO_ID_2364(), java.sql.Types.VARCHAR);
    	
    	return pStatement;
    }

    public void setRow(ResultSet pRsDet) throws SQLException
    {
		this.setNUM_FACTURA_2364(pRsDet.getString("NUM_FACTURA_2364"));
		this.setLINEA_2364(pRsDet.getInt("LINEA_2364"));
		this.setINVOICED_QUANTITY_2364(pRsDet.getInt("INVOICED_QUANTITY_2364"));
		this.setLINE_EXT_AMOUNT_2364(pRsDet.getBigDecimal("LINE_EXT_AMOUNT_2364"));
		this.setLINE_EXT_AMOUNT_ID_2364(pRsDet.getString("LINE_EXT_AMOUNT_ID_2364"));
		this.setALLOW_CHARGE_INDICATOR_2364(pRsDet.getInt("ALLOW_CHARGE_INDICATOR_2364"));
		this.setALLOW_MULT_FAC_NUM_2364(pRsDet.getBigDecimal("ALLOW_MULT_FAC_NUM_2364"));
		this.setALLOW_AMOUNT_2364(pRsDet.getBigDecimal("ALLOW_AMOUNT_2364"));
		this.setALLOW_AMOUNT_CURR_ID_2364(pRsDet.getString("ALLOW_AMOUNT_CURR_ID_2364"));
		this.setALLOW_BASE_AMOUNT_2364(pRsDet.getBigDecimal("ALLOW_BASE_AMOUNT_2364"));
		this.setALLOW_BASE_CURR_ID_2364(pRsDet.getString("ALLOW_BASE_CURR_ID_2364"));
		this.setTAX_AMOUNT_2364(pRsDet.getBigDecimal("TAX_AMOUNT_2364"));
		this.setTAX_AMOUNT_ID_2364(pRsDet.getString("TAX_AMOUNT_ID_2364"));
		this.setTAXABLE_AMOUNT_2364(pRsDet.getBigDecimal("TAXABLE_AMOUNT_2364"));
		this.setTAXABLE_AMOUNT_ID_2364(pRsDet.getString("TAXABLE_AMOUNT_ID_2364"));
		this.setSUBTAX_AMOUNT_2364(pRsDet.getBigDecimal("SUBTAX_AMOUNT_2364"));
		this.setSUBTAX_AMOUNT_ID_2364(pRsDet.getString("SUBTAX_AMOUNT_ID_2364"));
		this.setPERCENT_2364(pRsDet.getBigDecimal("PERCENT_2364"));
		this.setTAX_NAME_2364(pRsDet.getString("TAX_NAME_2364"));
		this.setTAX_TYPE_CODE_2364(pRsDet.getString("TAX_TYPE_CODE_2364"));
		this.setITEM_NAME_2364(pRsDet.getString("ITEM_NAME_2364"));
		this.setITEM_DESC_2364(pRsDet.getString("ITEM_DESC_2364"));
		this.setPRECIO_2364(pRsDet.getBigDecimal("PRECIO_2364"));
		this.setPRECIO_ID_2364(pRsDet.getString("PRECIO_ID_2364"));
    }
}
