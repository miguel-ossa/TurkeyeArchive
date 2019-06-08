package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/*
 * Clase que representa un registro de la tabla Cbl_fact_turquia_2363 (cabecera facturas Turquia)
 */
public class Cbl_fact_turquia_2363 {

	public static final 	String 		BLANCO = " ";
	//public static final     Integer     LIMITE_FACTURAS = 15001;
	public static final     Integer     LIMITE_FACTURAS = 10001;

	// Detalle de líneas de factura
	private List<Cbl_fact_turquia_det_2364>	m_arCbl_fact_turquia_det_2364;
	
	// Clave principal
	private String m_NUM_FACTURA_2363;
	
	// Datos
	private String m_ORIGEN_2363;
	private Integer m_FECHA_2363; // NUMBER(8)
	private String m_HORA_2363;
	private Integer m_TIENDA_2363;	// NUMBER(8)
	private String m_ESTADO_2363;	
	private String m_UUID_2363;	
	private String m_NOTE_2363;	
	private Integer m_FECHA_EXPEDICION_2363; // NUMBER(8)
	private Integer m_FECHA_PAGO_2363; // NUMBER(8)
	private String m_DIRECCION_WEB_2363;	
	private String m_METODO_PAGO_2363;	
	private Long m_TAX_ID_CARGO_2363;	
	private String m_NOMBRE_CARGO_2363;	
	private String m_CODIGO_PEDIDO_2363;	
	private String m_CURRENCY_CODE_2363;	
	private Integer m_NUM_LINEAS_2363;	
	private String m_SUP_PARTY_ID_2363;	
	private String m_SUP_PARTY_NAME_2363;	
	private String m_SUP_POST_ID_2363;	
	private String m_SUP_STREET_NAME_2363;
	private String m_SUP_BUILDING_NUM_2363;
	private String m_SUP_CITY_SUBDIV_NAME_2363;
	private String m_SUP_CITY_NAME_2363;
	private String m_SUP_POSTAL_ZONE_2363;
	private String m_SUP_COUNTRY_2363;
	private String m_SUP_TAX_NAME_2363;	
	private String m_SUP_TELF_2363;
	private String m_SUP_FAX_2363;
	private String m_SUP_EMAIL_2363;
	private String m_CUS_PARTY_ID_2363;	
	private String m_CUS_SCHEME_ID_2363;	
	private String m_CUS_PARTY_NAME_2363;	
	private String m_CUS_POST_ID_2363;	
	private String m_CUS_STREET_NAME_2363;	
	private String m_CUS_BUILDING_NUM_2363;
	private String m_CUS_CITY_SUBDIV_NAME_2363;
	private String m_CUS_CITY_NAME_2363;
	private String m_CUS_POSTAL_ZONE_2363;
	private String m_CUS_COUNTRY_2363;
	private String m_CUS_TAX_NAME_2363;	
	//private String m_CUS_TAX_TYPE_CODE_2363;	
	private String m_CUS_TELF_2363;	
	private String m_CUS_FAX_2363;
	private String m_CUS_EMAIL_2363;	
	private BigDecimal m_TAX_AMOUNT_2363;	// NUMBER(14,3)
	private String m_TAX_AMOUNT_ID_2363;
	private BigDecimal m_TAXABLE_AMOUNT_2363;	// NUMBER(14,3)
	private String m_TAXABLE_AMOUNT_ID_2363;
	private BigDecimal m_SUBTAX_AMOUNT_2363;	// NUMBER(14,3)
	private String m_SUBTAX_AMOUNT_ID_2363;
	private String m_TAX_EXEMPT_REASON_CODE_2363;
	private String m_TAX_TYPE_CODE_2363;
	private BigDecimal m_LINE_EXT_AMOUNT_2363; // NUMBER(14,3)	
	private String m_LINE_EXT_AMOUNT_ID_2363;
	private BigDecimal m_TAX_EXCLUS_AMOUNT_2363; // NUMBER(14,3)	
	private String m_TAX_EXCLUS_AMOUNT_ID_2363;
	private BigDecimal m_TAX_INCLUS_AMOUNT_2363; // NUMBER(14,3)	
	private String m_TAX_INCLUS_AMOUNT_ID_2363;
	private BigDecimal m_PAYABLE_AMOUNT_2363; // NUMBER(14,3)	
	private String m_PAYABLE_AMOUNT_ID_2363;
	private BigDecimal m_ALLOWANCE_BASE_AMOUNT_2363; // NUMBER(14,3)	
	private BigDecimal m_ALLOWANCE_AMOUNT_2363; // NUMBER(14,3)	
	private String m_ALLOWANCE_ID_2363;
	private Long m_ID_FACTURA_2363;
	private String m_URL_FACTURA_2363;
	
	public Cbl_fact_turquia_2363()
	{
		// Instanciamos la matriz de líneas de esta factura
		m_arCbl_fact_turquia_det_2364 = new ArrayList<Cbl_fact_turquia_det_2364>();
	}
	
	public void finalize()
	{
		// Instanciamos la matriz de líneas de esta factura
		m_arCbl_fact_turquia_det_2364 = null;
		try {
			super.finalize();
		} catch (Throwable e) {
			Main.logger.log(Level.WARNING, e.getMessage());
		}
	}
	
	public List<Cbl_fact_turquia_det_2364> getArCbl_fact_turquia_det_2364()
	{
		return m_arCbl_fact_turquia_det_2364; 
	}
	
	// NUM_FACTURA_2363
	public void setNUM_FACTURA_2363(String p_NUM_FACTURA_2363)
	{
		m_NUM_FACTURA_2363 = p_NUM_FACTURA_2363;
	}
	public String getNUM_FACTURA_2363()
	{
		return m_NUM_FACTURA_2363;
	}
	
	// ORIGEN_2363
	public void setORIGEN_2363(String p_ORIGEN_2363)
	{
		m_ORIGEN_2363 = p_ORIGEN_2363;
	}
	public String getORIGEN_2363()
	{
		return m_ORIGEN_2363;
	}
	
	// FECHA_2363
	public void setFECHA_2363(Integer p_FECHA_2363)
	{
		m_FECHA_2363 = p_FECHA_2363;
	}
	public Integer getFECHA_2363()
	{
		if (m_FECHA_2363 == null)
		{
			return 0;
		}
		else
		{
			return m_FECHA_2363;
		}
	}
	public String getFECHA_2363_toString()
	{
		if (m_FECHA_2363 == null)
		{
			return "";
		}
		else
		{
			return Integer.toString(m_FECHA_2363);
		}
	}
	
	// FECHA_EXPEDICION_2363
	public void setFECHA_EXPEDICION_2363(Integer p_FECHA_EXPEDICION_2363)
	{
		m_FECHA_EXPEDICION_2363 = p_FECHA_EXPEDICION_2363;
	}
	public Integer getFECHA_EXPEDICION_2363()
	{
		if (m_FECHA_EXPEDICION_2363 == null)
		{
			return 0;
		}
		else
		{
			return m_FECHA_EXPEDICION_2363;
		}
	}
	public String getFECHA_EXPEDICION_2363_toString()
	{
		if (m_FECHA_EXPEDICION_2363 == null)
		{
			return "";
		}
		else
		{
			return Integer.toString(m_FECHA_EXPEDICION_2363);
		}
	}
	
	// FECHA_PAGO_2363
	public void setFECHA_PAGO_2363(Integer p_FECHA_PAGO_2363)
	{
		m_FECHA_PAGO_2363 = p_FECHA_PAGO_2363;
	}
	public Integer getFECHA_PAGO_2363()
	{
		if (m_FECHA_PAGO_2363 == null)
		{
			return 0;
		}
		else
		{
			return m_FECHA_PAGO_2363;
		}
	}
	public String getFECHA_PAGO_2363_toString()
	{
		if (m_FECHA_PAGO_2363 == null)
		{
			return "";
		}
		else
		{
			return Integer.toString(m_FECHA_PAGO_2363);
		}
	}
	
	// HORA_2363
	public void setHORA_2363(String p_HORA_2363)
	{
		m_HORA_2363 = p_HORA_2363;
	}
	public String getHORA_2363()
	{
		return m_HORA_2363;
	}
	
	// TIENDA_2363 
	public void setTIENDA_2363(Integer p_TIENDA_2363)
	{
		m_TIENDA_2363 = p_TIENDA_2363;
	}
	public Integer getTIENDA_2363()
	{
		if (m_TIENDA_2363 == null)
		{
			return 0;
		}
		else
		{
			return m_TIENDA_2363;
		}
	}
	public String getTIENDA_2363_toString()
	{
		if (m_TIENDA_2363 == null)
		{
			return "";
		}
		else
		{
			return Integer.toString(m_TIENDA_2363);
		}
	}
	
	// ESTADO_2363
	public void setESTADO_2363(String p_ESTADO_2363)
	{
		m_ESTADO_2363 = p_ESTADO_2363;
	}
	public String getESTADO_2363()
	{
		return m_ESTADO_2363;
	}
	
	// UUID_2363
	public void setUUID_2363(String p_UUID_2363)
	{
		m_UUID_2363 = p_UUID_2363;
	}
	public String getUUID_2363()
	{
		return m_UUID_2363;
	}
	
	// NOTE_2363
	public void setNOTE_2363(String p_NOTE_2363)
	{
		m_NOTE_2363 = p_NOTE_2363;
	}
	public String getNOTE_2363()
	{
		return m_NOTE_2363;
	}
	
	// CODIGO_PEDIDO_2363
	public void setCODIGO_PEDIDO_2363(String p_CODIGO_PEDIDO_2363)
	{
		m_CODIGO_PEDIDO_2363 = p_CODIGO_PEDIDO_2363;
	}
	public String getCODIGO_PEDIDO_2363()
	{
		return m_CODIGO_PEDIDO_2363;
	}
	
	// DIRECCION_WEB_2363
	public void setDIRECCION_WEB_2363(String p_DIRECCION_WEB_2363)
	{
		m_DIRECCION_WEB_2363 = p_DIRECCION_WEB_2363;
	}
	public String getDIRECCION_WEB_2363()
	{
		return m_DIRECCION_WEB_2363;
	}
	
	// METODO_PAGO_2363
	public void setMETODO_PAGO_2363(String p_METODO_PAGO_2363)
	{
		m_METODO_PAGO_2363 = p_METODO_PAGO_2363;
	}
	public String getMETODO_PAGO_2363()
	{
		return m_METODO_PAGO_2363;
	}
	
	// TAX_ID_CARGO_2363
	public void setTAX_ID_CARGO_2363(Long p_TAX_ID_CARGO_2363)
	{
		m_TAX_ID_CARGO_2363 = p_TAX_ID_CARGO_2363;
	}
	public Long getTAX_ID_CARGO_2363()
	{
		return m_TAX_ID_CARGO_2363;
	}
	public String getTAX_ID_CARGO_toString()
	{
		return Long.toString(m_TAX_ID_CARGO_2363);
	}

	// NOMBRE_CARGO_2363
	public void setNOMBRE_CARGO_2363(String p_NOMBRE_CARGO_2363)
	{
		m_NOMBRE_CARGO_2363 = p_NOMBRE_CARGO_2363;
	}
	public String getNOMBRE_CARGO_2363()
	{
		return m_NOMBRE_CARGO_2363;
	}
	
	// CURRENCY_CODE_2363
	public void setCURRENCY_CODE_2363(String p_CURRENCY_CODE_2363)
	{
		m_CURRENCY_CODE_2363 = p_CURRENCY_CODE_2363;
	}
	public String getCURRENCY_CODE_2363()
	{
		return m_CURRENCY_CODE_2363;
	}
	
	// NUM_LINEAS_2363
	public void setNUM_LINEAS_2363(Integer p_NUM_LINEAS_2363)
	{
		m_NUM_LINEAS_2363 = p_NUM_LINEAS_2363;
	}
	public Integer getNUM_LINEAS_2363()
	{
		if (m_NUM_LINEAS_2363 == null)
		{
			return 0;
		}
		else 
		{
			return m_NUM_LINEAS_2363;
		}
	}
	public String getNUM_LINEAS_2363_toString()
	{
		if (m_NUM_LINEAS_2363 == null)
		{
			return "";
		}
		else
		{
			return Integer.toString(m_NUM_LINEAS_2363);
		}
	}
	
	// SUP_PARTY_ID_2363
	public void setSUP_PARTY_ID_2363(String p_SUP_PARTY_ID_2363)
	{
		m_SUP_PARTY_ID_2363 = p_SUP_PARTY_ID_2363;
	}
	public String getSUP_PARTY_ID_2363()
	{
		return m_SUP_PARTY_ID_2363;
	}
	
	// SUP_PARTY_NAME_2363
	public void setSUP_PARTY_NAME_2363(String p_SUP_PARTY_NAME_2363)
	{
		m_SUP_PARTY_NAME_2363 = p_SUP_PARTY_NAME_2363;
	}
	public String getSUP_PARTY_NAME_2363()
	{
		return m_SUP_PARTY_NAME_2363;
	}
	
	// SUP_POST_ID_2363
	public void setSUP_POST_ID_2363(String p_SUP_POST_ID_2363)
	{
		m_SUP_POST_ID_2363 = p_SUP_POST_ID_2363;
	}
	public String getSUP_POST_ID_2363()
	{
		return m_SUP_POST_ID_2363;
	}
	
	// SUP_STREET_NAME_2363
	public void setSUP_STREET_NAME_2363(String p_SUP_STREET_NAME_2363)
	{
		m_SUP_STREET_NAME_2363 = p_SUP_STREET_NAME_2363;
	}
	public String getSUP_STREET_NAME_2363()
	{
		return m_SUP_STREET_NAME_2363;
	}

	// SUP_BUILDING_NUM_2363
	public void setSUP_BUILDING_NUM_2363(String p_SUP_BUILDING_NUM_2363)
	{
		m_SUP_BUILDING_NUM_2363 = p_SUP_BUILDING_NUM_2363;
	}
	public String getSUP_BUILDING_NUM_2363()
	{
		return m_SUP_BUILDING_NUM_2363;
	}

	// SUP_BUILDING_NUM_2363
	public void setSUP_CITY_SUBDIV_NAME_2363(String p_SUP_CITY_SUBDIV_NAME_2363)
	{
		m_SUP_CITY_SUBDIV_NAME_2363 = p_SUP_CITY_SUBDIV_NAME_2363;
	}
	public String getSUP_CITY_SUBDIV_NAME_2363()
	{
		return m_SUP_CITY_SUBDIV_NAME_2363;
	}

	// SUP_CITY_NAME_2363
	public void setSUP_CITY_NAME_2363(String p_SUP_CITY_NAME_2363)
	{
		m_SUP_CITY_NAME_2363 = p_SUP_CITY_NAME_2363;
	}
	public String getSUP_CITY_NAME_2363()
	{
		return m_SUP_CITY_NAME_2363;
	}

	// SUP_POSTAL_ZONE_2363
	public void setSUP_POSTAL_ZONE_2363(String p_SUP_POSTAL_ZONE_2363)
	{
		m_SUP_POSTAL_ZONE_2363 = p_SUP_POSTAL_ZONE_2363;
	}
	public String getSUP_POSTAL_ZONE_2363()
	{
		return m_SUP_POSTAL_ZONE_2363;
	}

	// SUP_COUNTRY_2363
	public void setSUP_COUNTRY_2363(String p_SUP_COUNTRY_2363)
	{
		m_SUP_COUNTRY_2363 = p_SUP_COUNTRY_2363;
	}
	public String getSUP_COUNTRY_2363()
	{
		return m_SUP_COUNTRY_2363;
	}

	// SUP_TAX_NAME_2363
	public void setSUP_TAX_NAME_2363(String p_SUP_TAX_NAME_2363)
	{
		m_SUP_TAX_NAME_2363 = p_SUP_TAX_NAME_2363;
	}
	public String getSUP_TAX_NAME_2363()
	{
		return m_SUP_TAX_NAME_2363;
	}
	
	// SUP_TELF_2363
	public void setSUP_TELF_2363(String p_SUP_TELF_2363)
	{
		m_SUP_TELF_2363 = p_SUP_TELF_2363;
	}
	public String getSUP_TELF_2363()
	{
		return m_SUP_TELF_2363;
	}
	
	// SUP_FAX_2363
	public void setSUP_FAX_2363(String p_SUP_FAX_2363)
	{
		m_SUP_FAX_2363 = p_SUP_FAX_2363;
	}
	public String getSUP_FAX_2363()
	{
		return m_SUP_FAX_2363;
	}
	
	// SUP_MAIL_2363
	public void setSUP_EMAIL_2363(String p_SUP_EMAIL_2363)
	{
		m_SUP_EMAIL_2363 = p_SUP_EMAIL_2363;
	}
	public String getSUP_EMAIL_2363()
	{
		return m_SUP_EMAIL_2363;
	}
	
	// CUS_PARTY_ID_2363
	public void setCUS_PARTY_ID_2363(String p_CUS_PARTY_ID_2363)
	{
		m_CUS_PARTY_ID_2363 = p_CUS_PARTY_ID_2363;
	}
	public String getCUS_PARTY_ID_2363()
	{
		return m_CUS_PARTY_ID_2363;
	}
	
	// CUS_SCHEME_ID_2363
	public void setCUS_SCHEME_ID_2363(String p_CUS_SCHEME_ID_2363)
	{
		m_CUS_SCHEME_ID_2363 = p_CUS_SCHEME_ID_2363;
	}
	public String getCUS_SCHEME_ID_2363()
	{
		return m_CUS_SCHEME_ID_2363;
	}
	
	// CUS_PARTY_NAME_2363
	public void setCUS_PARTY_NAME_2363(String p_CUS_PARTY_NAME_2363)
	{
		m_CUS_PARTY_NAME_2363 = p_CUS_PARTY_NAME_2363;
	}
	public String getCUS_PARTY_NAME_2363()
	{
		return m_CUS_PARTY_NAME_2363;
	}
	
	// CUS_POST_ID_2363
	public void setCUS_POST_ID_2363(String p_CUS_POST_ID_2363)
	{
		m_CUS_POST_ID_2363 = p_CUS_POST_ID_2363;
	}
	public String getCUS_POST_ID_2363()
	{
		return m_CUS_POST_ID_2363;
	}
	
	// CUS_STREET_NAME_2363
	public void setCUS_STREET_NAME_2363(String p_CUS_STREET_NAME_2363)
	{
		m_CUS_STREET_NAME_2363 = p_CUS_STREET_NAME_2363;
	}
	public String getCUS_STREET_NAME_2363()
	{
		return m_CUS_STREET_NAME_2363;
	}
	
	// CUS_BUILDING_NUM_2363
	public void setCUS_BUILDING_NUM_2363(String p_CUS_BUILDING_NUM_2363)
	{
		m_CUS_BUILDING_NUM_2363 = p_CUS_BUILDING_NUM_2363;
	}
	public String getCUS_BUILDING_NUM_2363()
	{
		return m_CUS_BUILDING_NUM_2363;
	}
	
	// CUS_CITY_SUBDIV_NAME_2363
	public void setCUS_CITY_SUBDIV_NAME_2363(String p_CUS_CITY_SUBDIV_NAME_2363)
	{
		m_CUS_CITY_SUBDIV_NAME_2363 = p_CUS_CITY_SUBDIV_NAME_2363;
	}
	public String getCUS_CITY_SUBDIV_NAME_2363()
	{
		return m_CUS_CITY_SUBDIV_NAME_2363;
	}
	
	// CUS_CITY_NAME_2363
	public void setCUS_CITY_NAME_2363(String p_CUS_CITY_NAME_2363)
	{
		m_CUS_CITY_NAME_2363 = p_CUS_CITY_NAME_2363;
	}
	public String getCUS_CITY_NAME_2363()
	{
		return m_CUS_CITY_NAME_2363;
	}
	
	// CUS_POSTAL_ZONE_2363
	public void setCUS_POSTAL_ZONE_2363(String p_CUS_POSTAL_ZONE_2363)
	{
		m_CUS_POSTAL_ZONE_2363 = p_CUS_POSTAL_ZONE_2363;
	}
	public String getCUS_POSTAL_ZONE_2363()
	{
		return m_CUS_POSTAL_ZONE_2363;
	}
	
	// CUS_COUNTRY_2363
	public void setCUS_COUNTRY_2363(String p_CUS_COUNTRY_2363)
	{
		m_CUS_COUNTRY_2363 = p_CUS_COUNTRY_2363;
	}
	public String getCUS_COUNTRY_2363()
	{
		return m_CUS_COUNTRY_2363;
	}
	
	// CUS_TAX_NAME_2363
	public void setCUS_TAX_NAME_2363(String p_CUS_TAX_NAME_2363)
	{
		m_CUS_TAX_NAME_2363 = p_CUS_TAX_NAME_2363;
	}
	public String getCUS_TAX_NAME_2363()
	{
		return m_CUS_TAX_NAME_2363;
	}
	
	/*
	// CUS_TAX_TYPE_CODE_2363
	public void setCUS_TAX_TYPE_CODE_2363(String p_CUS_TAX_TYPE_CODE_2363)
	{
		m_CUS_TAX_TYPE_CODE_2363 = p_CUS_TAX_TYPE_CODE_2363;
	}
	public String getCUS_TAX_TYPE_CODE_2363()
	{
		return m_CUS_TAX_TYPE_CODE_2363;
	}
	*/
	
	// CUS_TELF_2363
	public void setCUS_TELF_2363(String p_CUS_TELF_2363)
	{
		m_CUS_TELF_2363 = p_CUS_TELF_2363;
	}
	public String getCUS_TELF_2363()
	{
		return m_CUS_TELF_2363;
	}
	
	// CUS_FAX_2363
	public void setCUS_FAX_2363(String p_CUS_FAX_2363)
	{
		m_CUS_FAX_2363 = p_CUS_FAX_2363;
	}
	public String getCUS_FAX_2363()
	{
		return m_CUS_FAX_2363;
	}
	
	// CUS_EMAIL_2363
	public void setCUS_EMAIL_2363(String p_CUS_EMAIL_2363)
	{
		m_CUS_EMAIL_2363 = p_CUS_EMAIL_2363;
	}
	public String getCUS_EMAIL_2363()
	{
		return m_CUS_EMAIL_2363;
	}
	
	// TAX_AMOUNT_2363
	public void setTAX_AMOUNT_2363(BigDecimal p_TAX_AMOUNT_2363)
	{
		m_TAX_AMOUNT_2363 = p_TAX_AMOUNT_2363;
		m_TAX_AMOUNT_2363.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
	public BigDecimal getTAX_AMOUNT_2363()
	{
		return m_TAX_AMOUNT_2363;
	}
	public String getTAX_AMOUNT_2363_toString()
	{
		return m_TAX_AMOUNT_2363.toString();
	}
	
	// TAX_AMOUNT_ID_2363
	public void setTAX_AMOUNT_ID_2363(String p_TAX_AMOUNT_ID_2363)
	{
		m_TAX_AMOUNT_ID_2363 = p_TAX_AMOUNT_ID_2363;
	}
	
	public String getTAX_AMOUNT_ID_2363()
	{
		return m_TAX_AMOUNT_ID_2363;
	}

	// TAXABLE_AMOUNT_2363
	public void setTAXABLE_AMOUNT_2363(BigDecimal p_TAXABLE_AMOUNT_2363)
	{
		m_TAXABLE_AMOUNT_2363 = p_TAXABLE_AMOUNT_2363;
	}
	public BigDecimal getTAXABLE_AMOUNT_2363()
	{
		return m_TAXABLE_AMOUNT_2363;
	}
	public String getTAXABLE_AMOUNT_2363_toString()
	{
		return m_TAXABLE_AMOUNT_2363.toString();
	}

	// TAXABLE_AMOUNT_ID_2363
	public void setTAXABLE_AMOUNT_ID_2363(String p_TAXABLE_AMOUNT_ID_2363)
	{
		m_TAXABLE_AMOUNT_ID_2363 = p_TAXABLE_AMOUNT_ID_2363;
	}
	
	public String getTAXABLE_AMOUNT_ID_2363()
	{
		return m_TAXABLE_AMOUNT_ID_2363;
	}

	// SUBTAX_AMOUNT_2363
	public void setSUBTAX_AMOUNT_2363(BigDecimal p_SUBTAX_AMOUNT_2363)
	{
		m_SUBTAX_AMOUNT_2363 = p_SUBTAX_AMOUNT_2363;
	}
	public BigDecimal getSUBTAX_AMOUNT_2363()
	{
		return m_SUBTAX_AMOUNT_2363;
	}
	public String getSUBTAX_AMOUNT_2363_toString()
	{
		return m_SUBTAX_AMOUNT_2363.toString();
	}

	// SUBTAX_AMOUNT_ID_2363
	public void setSUBTAX_AMOUNT_ID_2363(String p_SUBTAX_AMOUNT_ID_2363)
	{
		m_SUBTAX_AMOUNT_ID_2363 = p_SUBTAX_AMOUNT_ID_2363;
	}
	
	public String getSUBTAX_AMOUNT_ID_2363()
	{
		return m_SUBTAX_AMOUNT_ID_2363;
	}

	// TAX_EXEMPT_REASON_CODE_2363
	public void setTAX_EXEMPT_REASON_CODE_2363(String p_TAX_EXEMPT_REASON_CODE_2363)
	{
		m_TAX_EXEMPT_REASON_CODE_2363 = p_TAX_EXEMPT_REASON_CODE_2363;
	}
	
	public String getTAX_EXEMPT_REASON_CODE_2363()
	{
		return m_TAX_EXEMPT_REASON_CODE_2363;
	}

	// TAX_TYPE_CODE_2363
	public void setTAX_TYPE_CODE_2363(String p_TAX_TYPE_CODE_2363)
	{
		m_TAX_TYPE_CODE_2363 = p_TAX_TYPE_CODE_2363;
	}
	
	public String getTAX_TYPE_CODE_2363()
	{
		return m_TAX_TYPE_CODE_2363;
	}

	// LINE_EXT_AMOUNT_2363
	public void setLINE_EXT_AMOUNT_2363(BigDecimal p_LINE_EXT_AMOUNT_2363)
	{
		m_LINE_EXT_AMOUNT_2363 = p_LINE_EXT_AMOUNT_2363;
		m_LINE_EXT_AMOUNT_2363.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
	public BigDecimal getLINE_EXT_AMOUNT_2363()
	{
		return m_LINE_EXT_AMOUNT_2363;
	}
	public String getLINE_EXT_AMOUNT_2363_toString()
	{
		return m_LINE_EXT_AMOUNT_2363.toString();
	}
	
	// LINE_EXT_AMOUNT_ID_2363
	public void setLINE_EXT_AMOUNT_ID_2363(String p_LINE_EXT_AMOUNT_ID_2363)
	{
		m_LINE_EXT_AMOUNT_ID_2363 = p_LINE_EXT_AMOUNT_ID_2363;
	}
	
	public String getLINE_EXT_AMOUNT_ID_2363()
	{
		return m_LINE_EXT_AMOUNT_ID_2363;
	}
	
	// TAX_EXCLUS_AMOUNT_2363
	public void setTAX_EXCLUS_AMOUNT_2363(BigDecimal p_TAX_EXCLUS_AMOUNT_2363)
	{
		m_TAX_EXCLUS_AMOUNT_2363 = p_TAX_EXCLUS_AMOUNT_2363;
		m_TAX_EXCLUS_AMOUNT_2363.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
	public BigDecimal getTAX_EXCLUS_AMOUNT_2363()
	{
		return m_TAX_EXCLUS_AMOUNT_2363;
	}
	public String getTAX_EXCLUS_AMOUNT_2363_toString()
	{
		return m_TAX_EXCLUS_AMOUNT_2363.toString();
	}
	
	// TAX_EXCLUS_AMOUNT_ID_2363
	public void setTAX_EXCLUS_AMOUNT_ID_2363(String p_TAX_EXCLUS_AMOUNT_ID_2363)
	{
		m_TAX_EXCLUS_AMOUNT_ID_2363 = p_TAX_EXCLUS_AMOUNT_ID_2363;
	}
	
	public String getTAX_EXCLUS_AMOUNT_ID_2363()
	{
		return m_TAX_EXCLUS_AMOUNT_ID_2363;
	}
	
	// TAX_INCLUS_AMOUNT_2363
	public void setTAX_INCLUS_AMOUNT_2363(BigDecimal p_TAX_INCLUS_AMOUNT_2363)
	{
		m_TAX_INCLUS_AMOUNT_2363 = p_TAX_INCLUS_AMOUNT_2363;
		m_TAX_INCLUS_AMOUNT_2363.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
	public BigDecimal getTAX_INCLUS_AMOUNT_2363()
	{
		return m_TAX_INCLUS_AMOUNT_2363;
	}
	public String getTAX_INCLUS_AMOUNT_2363_toString()
	{
		return m_TAX_INCLUS_AMOUNT_2363.toString();
	}
	
	// TAX_INCLUS_AMOUNT_ID_2363
	public void setTAX_INCLUS_AMOUNT_ID_2363(String p_TAX_INCLUS_AMOUNT_ID_2363)
	{
		m_TAX_INCLUS_AMOUNT_ID_2363 = p_TAX_INCLUS_AMOUNT_ID_2363;
	}
	
	public String getTAX_INCLUS_AMOUNT_ID_2363()
	{
		return m_TAX_INCLUS_AMOUNT_ID_2363;
	}
	
	// PAYABLE_AMOUNT_2363
	public void setPAYABLE_AMOUNT_2363(BigDecimal p_PAYABLE_AMOUNT_2363)
	{
		m_PAYABLE_AMOUNT_2363 = p_PAYABLE_AMOUNT_2363;
		m_PAYABLE_AMOUNT_2363.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
	public BigDecimal getPAYABLE_AMOUNT_2363()
	{
		return m_PAYABLE_AMOUNT_2363;
	}
	public String getPAYABLE_AMOUNT_2363_toString()
	{
		return m_PAYABLE_AMOUNT_2363.toString();
	}
	
	// PAYABLE_AMOUNT_ID_2363
	public void setPAYABLE_AMOUNT_ID_2363(String p_PAYABLE_AMOUNT_ID_2363)
	{
		m_PAYABLE_AMOUNT_ID_2363 = p_PAYABLE_AMOUNT_ID_2363;
	}
	
	public String getPAYABLE_AMOUNT_ID_2363()
	{
		return m_PAYABLE_AMOUNT_ID_2363;
	}
	
	// ALLOWANCE_BASE_AMOUNT_2363           
	public void setALLOWANCE_BASE_AMOUNT_2363(BigDecimal p_ALLOWANCE_BASE_AMOUNT_2363)
	{
		m_ALLOWANCE_BASE_AMOUNT_2363 = p_ALLOWANCE_BASE_AMOUNT_2363;
		m_ALLOWANCE_BASE_AMOUNT_2363.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
	public BigDecimal getALLOWANCE_BASE_AMOUNT_2363()
	{
		return m_ALLOWANCE_BASE_AMOUNT_2363;
	}
	public String getALLOWANCE_BASE_AMOUNT_2363_toString()
	{
		return m_ALLOWANCE_BASE_AMOUNT_2363.toString();
	}
	
	// ALLOWANCE_AMOUNT_2363           
	public void setALLOWANCE_AMOUNT_2363(BigDecimal p_ALLOWANCE_AMOUNT_2363)
	{
		m_ALLOWANCE_AMOUNT_2363 = p_ALLOWANCE_AMOUNT_2363;
		m_ALLOWANCE_AMOUNT_2363.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
	public BigDecimal getALLOWANCE_AMOUNT_2363()
	{
		return m_ALLOWANCE_AMOUNT_2363;
	}
	public String getALLOWANCE_AMOUNT_2363_toString()
	{
		return m_ALLOWANCE_AMOUNT_2363.toString();
	}
	
	// ALLOWANCE_ID_2363                     
	public void setALLOWANCE_ID_2363(String p_ALLOWANCE_ID_2363)
	{
		m_ALLOWANCE_ID_2363 = p_ALLOWANCE_ID_2363;
	}
	
	public String getALLOWANCE_ID_2363()
	{
		return m_ALLOWANCE_ID_2363;
	}
	
	// ID_FACTURA_2363
	public void setID_FACTURA_2363(Long p_ID_FACTURA_2363)
	{
		m_ID_FACTURA_2363 = p_ID_FACTURA_2363;
	}
	public Long getID_FACTURA_2363()
	{
		if (m_ID_FACTURA_2363 == null)
		{
			return (long) 0;
		}
		else 
		{
			return m_ID_FACTURA_2363;
		}
	}
	public String getID_FACTURA_2363_toString()
	{
		if (m_ID_FACTURA_2363 == null)
		{
			return "";
		}
		else
		{
			return Long.toString(m_ID_FACTURA_2363);
		}
	}
	
	// URL_FACTURA_2363
	public void setURL_FACTURA_2363(String p_URL_FACTURA_2363)
	{
		m_URL_FACTURA_2363 = p_URL_FACTURA_2363;
	}
	public String getURL_FACTURA_2363()
	{
		if (m_URL_FACTURA_2363 == null)
		{
			m_URL_FACTURA_2363 = BLANCO;
		}
		return m_URL_FACTURA_2363;
	}

    /*
    SELECT NUM_FACTURA_2363, 
        	 FECHA_2363, 				
        	 HORA_2363, 				
        	 TIENDA_2363, 			
        	 ORIGEN_2363,				
        	 ESTADO_2363, 			
        	 UUID_2363, 				
        	 NOTE_2363,
        	 DIRECCION_WEB_2363,
        	 FECHA_EXPEDICION_2363,
        	 METODO_PAGO_2363,
        	 FECHA_PAGO_2363,
        	 TAX_ID_CARGO_2363,
        	 NOMBRE_CARGO_2363,
        	 CODIGO_PEDIDO_2363, 				
        	 CURRENCY_CODE_2363,
        	 NUM_LINEAS_2363, 	
        	 SUP_PARTY_ID_2363, 
        	 SUP_PARTY_NAME_2363,
        	 SUP_POST_ID_2363, 		
        	 SUP_STREET_NAME_2363,
        	 SUP_BUILDING_NUM_2363,
        	 SUP_CITY_SUBDIV_NAME_2363, 
        	 SUP_CITY_NAME_2363, 			
        	 SUP_POSTAL_ZONE_2363, 		
        	 SUP_COUNTRY_2363, 				
        	 SUP_TAX_NAME_2363, 			
        	 SUP_TELF_2363, 					
        	 SUP_FAX_2363, 				
        	 SUP_EMAIL_2363, 			
        	 CUS_PARTY_ID_2363, 	
        	 CUS_SCHEME_ID_2363, 	
        	 CUS_PARTY_NAME_2363, 
        	 CUS_POST_ID_2363, 		
        	 CUS_STREET_NAME_2363, 
        	 CUS_BUILDING_NUM_2363, 	
        	 CUS_CITY_SUBDIV_NAME_2363, 
        	 CUS_CITY_NAME_2363, 				
        	 CUS_POSTAL_ZONE_2363, 			
        	 CUS_COUNTRY_2363, 			
        	 CUS_TAX_NAME_2363, 		
        	 CUS_TELF_2363, 				
        	 CUS_FAX_2363, 					
        	 CUS_EMAIL_2363, 				
        	 TAX_AMOUNT_2363, 			
        	 TAX_AMOUNT_ID_2363, 		
        	 TAXABLE_AMOUNT_2363, 	
        	 TAXABLE_AMOUNT_ID_2363,
        	 SUBTAX_AMOUNT_2363, 		
        	 SUBTAX_AMOUNT_ID_2363,
        	 TAX_EXEMPT_REASON_CODE_2363, 
        	 TAX_TYPE_CODE_2363, 		
        	 LINE_EXT_AMOUNT_2363, 	
        	 LINE_EXT_AMOUNT_ID_2363,
        	 TAX_EXCLUS_AMOUNT_2363, 
        	 TAX_EXCLUS_AMOUNT_ID_2363,
        	 TAX_INCLUS_AMOUNT_2363, 		
        	 TAX_INCLUS_AMOUNT_ID_2363, 
        	 PAYABLE_AMOUNT_2363, 			
        	 PAYABLE_AMOUNT_ID_2363,
        	 ALLOWANCE_BASE_AMOUNT_2363,	
        	 ALLOWANCE_AMOUNT_2363,	
        	 ALLOWANCE_ID_2363	
    FROM Cbl_fact_turquia_2363
    --NO WHERE ESTADO_2363 IN (' ', 'P', 'C', 'K') AND
    WHERE ESTADO_2363 IN (' ', 'P', 'C', '1', 'R', '2') AND
	      ORIGEN_2363 = ? AND  
          NUM_LINEAS_2363 <> 0 AND  
          rownum < 15000;
     */
    /*
     * para cambiar el estado: UPDATE Cbl_fact_turquia_2363 SET ESTADO_2363 = ' '; COMMIT WORK;
     */
    public static String prepareSelectCabeceras() throws SQLException
    {
    	String sTemplate[] = { "SELECT NUM_FACTURA_2363,", 
    	    	 					"FECHA_2363,", 				
    	    	 					"HORA_2363,", 				
    	    	 					"TIENDA_2363,", 			
    	    	 					"ORIGEN_2363,", 			
    	    	 					"ESTADO_2363,", 			
    	    	 					"UUID_2363,", 				
    	    	 					"NOTE_2363,", 				
    	    	 		        	"DIRECCION_WEB_2363,",
    	    	 		        	"FECHA_EXPEDICION_2363,",
    	    	 		        	"METODO_PAGO_2363,",
    	    	 		        	"FECHA_PAGO_2363,",
    	    	 		        	"TAX_ID_CARGO_2363,",
    	    	 		        	"NOMBRE_CARGO_2363,",
    	    	 					"CODIGO_PEDIDO_2363,", 				
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
    	    	 					"CUS_SCHEME_ID_2363,", 	
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
    	    	 					"PAYABLE_AMOUNT_ID_2363,",	
    	    	 		        	"ALLOWANCE_BASE_AMOUNT_2363,",	
    	    	 		        	"ALLOWANCE_AMOUNT_2363,",	
    	    	 		        	"ALLOWANCE_ID_2363 ",
    	    	 				"FROM Cbl_fact_turquia_2363 ",
    	    	 				//"WHERE ESTADO_2363 IN (' ', 'P', 'C', 'K') AND ",
    	    	 				"WHERE ESTADO_2363 IN (' ', 'P', 'C', '1', 'R', '2') AND ",
    	    	 				"      NUM_LINEAS_2363 <> 0 AND ", 
    	    	 				"      rownum < " + LIMITE_FACTURAS.toString()};

    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }

    /*
    SELECT NUM_FACTURA_2363, 
        	 FECHA_2363, 				
        	 HORA_2363, 				
        	 TIENDA_2363, 			
        	 ORIGEN_2363,				
        	 ESTADO_2363, 			
        	 UUID_2363, 				
        	 NOTE_2363,
        	 DIRECCION_WEB_2363,
        	 FECHA_EXPEDICION_2363,
        	 METODO_PAGO_2363,
        	 FECHA_PAGO_2363,
        	 TAX_ID_CARGO_2363,
        	 NOMBRE_CARGO_2363,
        	 CODIGO_PEDIDO_2363, 				
        	 CURRENCY_CODE_2363,
        	 NUM_LINEAS_2363, 	
        	 SUP_PARTY_ID_2363, 
        	 SUP_PARTY_NAME_2363,
        	 SUP_POST_ID_2363, 		
        	 SUP_STREET_NAME_2363,
        	 SUP_BUILDING_NUM_2363,
        	 SUP_CITY_SUBDIV_NAME_2363, 
        	 SUP_CITY_NAME_2363, 			
        	 SUP_POSTAL_ZONE_2363, 		
        	 SUP_COUNTRY_2363, 				
        	 SUP_TAX_NAME_2363, 			
        	 SUP_TELF_2363, 					
        	 SUP_FAX_2363, 				
        	 SUP_EMAIL_2363, 			
        	 CUS_PARTY_ID_2363, 	
        	 CUS_SCHEME_ID_2363, 	
        	 CUS_PARTY_NAME_2363, 
        	 CUS_POST_ID_2363, 		
        	 CUS_STREET_NAME_2363, 
        	 CUS_BUILDING_NUM_2363, 	
        	 CUS_CITY_SUBDIV_NAME_2363, 
        	 CUS_CITY_NAME_2363, 				
        	 CUS_POSTAL_ZONE_2363, 			
        	 CUS_COUNTRY_2363, 			
        	 CUS_TAX_NAME_2363, 		
        	 CUS_TELF_2363, 				
        	 CUS_FAX_2363, 					
        	 CUS_EMAIL_2363, 				
        	 TAX_AMOUNT_2363, 			
        	 TAX_AMOUNT_ID_2363, 		
        	 TAXABLE_AMOUNT_2363, 	
        	 TAXABLE_AMOUNT_ID_2363,
        	 SUBTAX_AMOUNT_2363, 		
        	 SUBTAX_AMOUNT_ID_2363,
        	 TAX_EXEMPT_REASON_CODE_2363, 
        	 TAX_TYPE_CODE_2363, 		
        	 LINE_EXT_AMOUNT_2363, 	
        	 LINE_EXT_AMOUNT_ID_2363,
        	 TAX_EXCLUS_AMOUNT_2363, 
        	 TAX_EXCLUS_AMOUNT_ID_2363,
        	 TAX_INCLUS_AMOUNT_2363, 		
        	 TAX_INCLUS_AMOUNT_ID_2363, 
        	 PAYABLE_AMOUNT_2363, 			
        	 PAYABLE_AMOUNT_ID_2363,
        	 ALLOWANCE_BASE_AMOUNT_2363,	
        	 ALLOWANCE_AMOUNT_2363,	
        	 ALLOWANCE_ID_2363	
    FROM Cbl_fact_turquia_2363
    -- NO WHERE ESTADO_2363 IN (' ', 'C', 'P', 'K') AND
    WHERE ESTADO_2363 IN (' ', 'P', 'C', '1', 'R', '2') AND
	      ORIGEN_2363 = ? AND  
          NUM_LINEAS_2363 <> 0 AND  
          rownum < 15000;
     */
    /*
     * para cambiar el estado: UPDATE Cbl_fact_turquia_2363 SET ESTADO_2363 = ' '; COMMIT WORK;
     */
    public static String prepareSelectCabecerasOrigenNuevas() throws SQLException
    {
    	String sTemplate[] = { "SELECT NUM_FACTURA_2363,", 
    	    	 					"FECHA_2363,", 				
    	    	 					"HORA_2363,", 				
    	    	 					"TIENDA_2363,", 			
    	    	 					"ORIGEN_2363,", 			
    	    	 					"ESTADO_2363,", 			
    	    	 					"UUID_2363,", 				
    	    	 					"NOTE_2363,", 				
    	    	 		        	"DIRECCION_WEB_2363,",
    	    	 		        	"FECHA_EXPEDICION_2363,",
    	    	 		        	"METODO_PAGO_2363,",
    	    	 		        	"FECHA_PAGO_2363,",
    	    	 		        	"TAX_ID_CARGO_2363,",
    	    	 		        	"NOMBRE_CARGO_2363,",
    	    	 					"CODIGO_PEDIDO_2363,", 				
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
    	    	 					"CUS_SCHEME_ID_2363,", 	
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
    	    	 					"PAYABLE_AMOUNT_ID_2363,",	
    	    	 		        	"ALLOWANCE_BASE_AMOUNT_2363,",	
    	    	 		        	"ALLOWANCE_AMOUNT_2363,",	
    	    	 		        	"ALLOWANCE_ID_2363 ",
    	    	 				"FROM Cbl_fact_turquia_2363 ",
    	    	 				//"WHERE ESTADO_2363 IN (' ', 'C') AND ",
    	    	 				//"WHERE ESTADO_2363 IN (' ', 'C', 'P', 'K') AND ",
    	    	 				"WHERE ESTADO_2363 IN (' ', 'P', 'C', '1', 'R', '2') AND ",
    	    	 				"      ORIGEN_2363 = ? AND ", 
    	    	 				"      NUM_LINEAS_2363 <> 0 AND ", 
    	    	 				"      rownum < " + LIMITE_FACTURAS.toString()};

    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }

    public static String prepareSelectCabecerasNuevas() throws SQLException
    {
    	String sTemplate[] = { "SELECT NUM_FACTURA_2363,", 
    	    	 					"FECHA_2363,", 				
    	    	 					"HORA_2363,", 				
    	    	 					"TIENDA_2363,", 			
    	    	 					"ORIGEN_2363,", 			
    	    	 					"ESTADO_2363,", 			
    	    	 					"UUID_2363,", 				
    	    	 					"NOTE_2363,", 				
    	    	 		        	"DIRECCION_WEB_2363,",
    	    	 		        	"FECHA_EXPEDICION_2363,",
    	    	 		        	"METODO_PAGO_2363,",
    	    	 		        	"FECHA_PAGO_2363,",
    	    	 		        	"TAX_ID_CARGO_2363,",
    	    	 		        	"NOMBRE_CARGO_2363,",
    	    	 					"CODIGO_PEDIDO_2363,", 				
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
    	    	 					"CUS_SCHEME_ID_2363,", 	
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
    	    	 					"PAYABLE_AMOUNT_ID_2363,",	
    	    	 		        	"ALLOWANCE_BASE_AMOUNT_2363,",	
    	    	 		        	"ALLOWANCE_AMOUNT_2363,",	
    	    	 		        	"ALLOWANCE_ID_2363 ",
    	    	 				"FROM Cbl_fact_turquia_2363 ",
    	    	 				//"WHERE ESTADO_2363 IN (' ', 'C') AND ",
    	    	 				//"WHERE ESTADO_2363 IN (' ', 'C', 'P', 'K') AND ",
    	    	 				"WHERE ESTADO_2363 IN (' ', 'P', 'C', '1', 'R', '2') AND ",
    	    	 				"      NUM_LINEAS_2363 <> 0 AND ", 
    	    	 				"      rownum < " + LIMITE_FACTURAS.toString()};
    	
    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }

    public static String prepareInsertCab() throws SQLException
    {
    	String sTemplate[] = { "INSERT INTO Cbl_fact_turquia_2363",
    			                       "(",
    			                       "NUM_FACTURA_2363,", 				// 1 VARCHAR2
    			                       "ORIGEN_2363,",						// 2 VARCHAR2
    			                       "FECHA_2363,", 						// 3 NUMBER(8,0)
    			                       "HORA_2363,", 						// 4 VARCHAR2
    			                       "TIENDA_2363,", 						// 5 NUMBER(8,0)
    			                       "ESTADO_2363,", 						// 6 VARCHAR2
    			                       "UUID_2363,", 						// 7 VARCHAR2
    			                       "NOTE_2363,", 						// 8 VARCHAR2
       	    	 		        	   "DIRECCION_WEB_2363,",				// 9 VARCHAR2
       	    	 		        	   "FECHA_EXPEDICION_2363,",            // 10 NUMBER(8,0)
       	    	 		        	   "METODO_PAGO_2363,",					// 11 VARCHAR2
       	    	 		        	   "FECHA_PAGO_2363,",					// 12 NUMBER(8,0)
       	    	 		        	   "TAX_ID_CARGO_2363,",				// 13 NUMBER(10,0)
       	    	 		        	   "NOMBRE_CARGO_2363,", 				// 14 VARCHAR2
    			                       "CODIGO_PEDIDO_2363,", 				// 15 VARCHAR2
    			                       "CURRENCY_CODE_2363,", 				// 16 VARCHAR2
    			                       "NUM_LINEAS_2363,", 					// 17 NUMBER(2,0)
    			                       "SUP_PARTY_ID_2363,", 				// 18 VARCHAR2
    			                       "SUP_PARTY_NAME_2363,", 				// 19 VARCHAR2
    			                       "SUP_POST_ID_2363,", 				// 20 VARCHAR2
    			                       "SUP_STREET_NAME_2363,", 			// 21 VARCHAR2
    			                       "SUP_BUILDING_NUM_2363,", 			// 22 VARCHAR2
    			                       "SUP_CITY_SUBDIV_NAME_2363,", 		// 23 VARCHAR2
    			                       "SUP_CITY_NAME_2363,", 				// 24 VARCHAR2
    			                       "SUP_POSTAL_ZONE_2363,", 			// 25 VARCHAR2
    			                       "SUP_COUNTRY_2363,", 				// 26 VARCHAR2
    			                       "SUP_TAX_NAME_2363,", 				// 27 VARCHAR2
    			                       "SUP_TELF_2363,", 					// 28 VARCHAR2
    			                       "SUP_FAX_2363,", 					// 29 VARCHAR2
    			                       "SUP_EMAIL_2363,", 					// 30 VARCHAR2
    			                       "CUS_PARTY_ID_2363,", 				// 31 VARCHAR2
    			                       "CUS_SCHEME_ID_2363,", 				// 32 VARCHAR2
    			                       "CUS_PARTY_NAME_2363,", 				// 33 VARCHAR2
    			                       "CUS_POST_ID_2363,", 				// 34 VARCHAR2
    			                       "CUS_STREET_NAME_2363,", 			// 35 VARCHAR2
    			                       "CUS_BUILDING_NUM_2363,", 			// 36 VARCHAR2
    			                       "CUS_CITY_SUBDIV_NAME_2363,", 		// 37 VARCHAR2
    			                       "CUS_CITY_NAME_2363,", 				// 38 VARCHAR2
    			                       "CUS_POSTAL_ZONE_2363,", 			// 39 VARCHAR2
    			                       "CUS_COUNTRY_2363,", 				// 40 VARCHAR2
    			                       "CUS_TAX_NAME_2363,", 				// 41 VARCHAR2
    			                       "CUS_TELF_2363,", 					// 42 VARCHAR2
    			                       "CUS_FAX_2363,", 					// 43 VARCHAR2
    			                       "CUS_EMAIL_2363,", 					// 44 VARCHAR2
    			                       "TAX_AMOUNT_2363,", 					// 45 NUMBER(14,3)
    			                       "TAX_AMOUNT_ID_2363,", 				// 46 VARCHAR2
    			                       "TAXABLE_AMOUNT_2363,", 				// 47 NUMBER(14,3)
    			                       "TAXABLE_AMOUNT_ID_2363,", 			// 48 VARCHAR2
    			                       "SUBTAX_AMOUNT_2363,", 				// 49 NUMBER(14,3)
    			                       "SUBTAX_AMOUNT_ID_2363,", 			// 50 VARCHAR2
    			                       "TAX_EXEMPT_REASON_CODE_2363,",		// 51 VARCHAR2
    			                       "TAX_TYPE_CODE_2363,", 				// 52 VARCHAR2
    			                       "LINE_EXT_AMOUNT_2363,", 			// 53 NUMBER(14,3)
    			                       "LINE_EXT_AMOUNT_ID_2363,", 			// 54 VARCHAR2
    			                       "TAX_EXCLUS_AMOUNT_2363,", 			// 55 NUMBER(14,3)
    			                       "TAX_EXCLUS_AMOUNT_ID_2363,", 		// 56 VARCHAR2
    			                       "TAX_INCLUS_AMOUNT_2363,", 			// 57 NUMBER(14,3)
    			                       "TAX_INCLUS_AMOUNT_ID_2363,", 		// 58 VARCHAR2
    			                       "PAYABLE_AMOUNT_2363,", 				// 59 NUMBER(14,3)
    			                       "PAYABLE_AMOUNT_ID_2363,", 			// 60 VARCHAR2
       	    	 		        	   "ALLOWANCE_BASE_AMOUNT_2363,",		// 61 NUMBER(14,3)	
       	    	 		        	   "ALLOWANCE_AMOUNT_2363,",	        // 62 NUMBER(14,3)
       	    	 		        	   "ALLOWANCE_ID_2363,",                // 63 VARCHAR2
    			                       "ID_FACTURA_2363,", 					// 64 VARCHAR2
    			                       "URL_FACTURA_2363", 					// 65 VARCHAR2
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
 			                       		"?,", // 24
 			                       		"?,",  // 25
 			                       		"?,",  // 26
 			                       		"?,",  // 27
 			                       		"?,",  // 28
 			                       		"?,",  // 29
 			                       		"?,",  // 30
 			                       		"?,",  // 31
 			                       		"?,",  // 32
 			                       		"?,",  // 33
 			                       		"?,",  // 34
 			                       		"?,",  // 35
 			                       		"?,",  // 36
 			                       		"?,",  // 37
 			                       		"?,",  // 38
 			                       		"?,",  // 39
 			                       		"?,",  // 40
 			                       		"?,",  // 41
 			                       		"?,",  // 42
 			                       		"?,",  // 43
 			                       		"?,",  // 44
 			                       		"?,",  // 45
 			                       		"?,",  // 46
 			                       		"?,",  // 47
 			                       		"?,",  // 48
 			                       		"?,",  // 49
 			                       		"?,",  // 50
 			                       		"?,",  // 51
 			                       		"?,",  // 52
 			                       		"?,",  // 53
 			                       		"?,",  // 54
 			                       		"?,",  // 55
 			                       		"?,",  // 56
 			                       		"?,",  // 57
 			                       		"?,",  // 58
 			                       		"?,",  // 59
 			                       		"?,",  // 60
 			                       		"?,",  // 61
 			                       		"?,",  // 62
 			                       		"?,",  // 63
 			                       		"?,",  // 64
 			                       		"?",  // 65
 			                       		")" };
    	
    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }
    


	/*
	 * En modo CREATE_SAMPLES se crea una muestra de líneas
	 */
	public void createSampleDet(String sNumFactura, int pNumLineas)
	{
		for (Integer i=1; i<pNumLineas+1; i++)
		{
			Cbl_fact_turquia_det_2364 myCbl_fact_turquia_det_2364 = new Cbl_fact_turquia_det_2364();
			myCbl_fact_turquia_det_2364.setNUM_FACTURA_2364(sNumFactura);

			myCbl_fact_turquia_det_2364.setLINEA_2364(i);
		
			myCbl_fact_turquia_det_2364.setINVOICED_QUANTITY_2364(i);
			myCbl_fact_turquia_det_2364.setLINE_EXT_AMOUNT_2364(new BigDecimal("0.0"));
			myCbl_fact_turquia_det_2364.setLINE_EXT_AMOUNT_ID_2364("TRY");
			myCbl_fact_turquia_det_2364.setALLOW_CHARGE_INDICATOR_2364(0);
			myCbl_fact_turquia_det_2364.setALLOW_MULT_FAC_NUM_2364(new BigDecimal("0.0"));
			myCbl_fact_turquia_det_2364.setALLOW_AMOUNT_2364(new BigDecimal("0"));
			myCbl_fact_turquia_det_2364.setALLOW_AMOUNT_CURR_ID_2364("TRY");
			myCbl_fact_turquia_det_2364.setALLOW_BASE_AMOUNT_2364(new BigDecimal("0.0"));
			myCbl_fact_turquia_det_2364.setALLOW_BASE_CURR_ID_2364("TRY");
			myCbl_fact_turquia_det_2364.setTAX_AMOUNT_2364(new BigDecimal("0.0"));
			myCbl_fact_turquia_det_2364.setTAX_AMOUNT_ID_2364("TRY");
			myCbl_fact_turquia_det_2364.setTAXABLE_AMOUNT_2364(new BigDecimal("0.0"));
			myCbl_fact_turquia_det_2364.setTAXABLE_AMOUNT_ID_2364("TRY");
			myCbl_fact_turquia_det_2364.setSUBTAX_AMOUNT_2364(new BigDecimal("0.0"));
			myCbl_fact_turquia_det_2364.setSUBTAX_AMOUNT_ID_2364("TRY");
			myCbl_fact_turquia_det_2364.setPERCENT_2364(new BigDecimal("0.0"));
			myCbl_fact_turquia_det_2364.setTAX_NAME_2364("KDV");
			myCbl_fact_turquia_det_2364.setTAX_TYPE_CODE_2364("0015");
			myCbl_fact_turquia_det_2364.setITEM_NAME_2364("item name " + i.toString());
			myCbl_fact_turquia_det_2364.setITEM_DESC_2364("item desc " + i.toString());
			myCbl_fact_turquia_det_2364.setPRECIO_2364(new BigDecimal("125500736.33"));
			myCbl_fact_turquia_det_2364.setPRECIO_ID_2364("TRY");
		
			m_arCbl_fact_turquia_det_2364.add(myCbl_fact_turquia_det_2364);
			
			myCbl_fact_turquia_det_2364 = null;
		}
	}
	
	public void addDetalle(Cbl_fact_turquia_det_2364 pCbl_fact_turquia_det_2364)
	{
		m_arCbl_fact_turquia_det_2364.add(pCbl_fact_turquia_det_2364);
	}

    public static PreparedStatement createInsertCab(PreparedStatement pStatement, Cbl_fact_turquia p_Cbl_fact_turquia) throws SQLException
    {
    	
    	//PreparedStatement psStatement = m_Conn.prepareStatement(sStatement);
    	pStatement.setObject(1, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getNUM_FACTURA_2363(), java.sql.Types.VARCHAR);

    	pStatement.setObject(2, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getORIGEN_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(3, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getFECHA_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(4, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getHORA_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(5, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTIENDA_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(6, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getESTADO_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(7, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getUUID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(8, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getNOTE_2363(), java.sql.Types.VARCHAR);
    	
    	pStatement.setObject(9, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getDIRECCION_WEB_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(10, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getFECHA_EXPEDICION_2363(), java.sql.Types.INTEGER);
    	pStatement.setObject(11, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getMETODO_PAGO_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(12, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getFECHA_PAGO_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(13, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_ID_CARGO_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(14, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getNOMBRE_CARGO_2363(), java.sql.Types.VARCHAR);
    	
    	pStatement.setObject(15, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCODIGO_PEDIDO_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(16, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCURRENCY_CODE_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(17, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getNUM_LINEAS_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(18, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_PARTY_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(19, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_PARTY_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(20, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_POST_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(21, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_STREET_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(22, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_BUILDING_NUM_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(23, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_CITY_SUBDIV_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(24, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_CITY_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(25, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_POSTAL_ZONE_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(26, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_COUNTRY_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(27, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_TAX_NAME_2363(), java.sql.Types.VARCHAR);
    	//psStatement.setObject(14, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_TAX_TYPE_CODE_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(28, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_TELF_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(29, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_FAX_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(30, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUP_EMAIL_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(31, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_PARTY_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(32, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_SCHEME_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(33, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_PARTY_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(34, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_POST_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(35, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_STREET_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(36, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_BUILDING_NUM_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(37, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_CITY_SUBDIV_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(38, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_CITY_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(39, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_POSTAL_ZONE_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(40, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_COUNTRY_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(41, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_TAX_NAME_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(42, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_TELF_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(43, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_FAX_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(44, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getCUS_EMAIL_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(45, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(46, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_AMOUNT_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(47, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAXABLE_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(48, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAXABLE_AMOUNT_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(49, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUBTAX_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(50, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getSUBTAX_AMOUNT_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(51, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_EXEMPT_REASON_CODE_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(52, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_TYPE_CODE_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(53, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getLINE_EXT_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(54, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getLINE_EXT_AMOUNT_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(55, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_EXCLUS_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(56, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_EXCLUS_AMOUNT_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(57, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_INCLUS_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(58, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getTAX_INCLUS_AMOUNT_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(59, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getPAYABLE_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(60, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getPAYABLE_AMOUNT_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(61, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getALLOWANCE_BASE_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(62, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getALLOWANCE_AMOUNT_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(63, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getALLOWANCE_ID_2363(), java.sql.Types.VARCHAR);
    	pStatement.setObject(64, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getID_FACTURA_2363(), java.sql.Types.NUMERIC);
    	pStatement.setObject(65, p_Cbl_fact_turquia.getCbl_fact_turquia_2363().getURL_FACTURA_2363(), java.sql.Types.VARCHAR);
    	
    	return pStatement;
    }

    public static String getKey(ResultSet pRsCab)
    {
    	String sKey = null;
    	try {
    		sKey = pRsCab.getString("NUM_FACTURA_2363");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return sKey;
    }
    
    public void setRow(ResultSet pRsCab) throws SQLException
    {
		this.setNUM_FACTURA_2363(pRsCab.getString("NUM_FACTURA_2363"));
		this.setFECHA_2363(pRsCab.getInt("FECHA_2363"));
		this.setHORA_2363(pRsCab.getString("HORA_2363"));
		this.setTIENDA_2363(pRsCab.getInt("TIENDA_2363"));
		this.setORIGEN_2363(pRsCab.getString("ORIGEN_2363"));
		this.setESTADO_2363(pRsCab.getString("ESTADO_2363"));
		if (this.getESTADO_2363() == null)
		{
			this.setESTADO_2363(" "); // Forzamos estado inicial
		}
		else
		{
			/*
			if (this.getESTADO_2363().trim().equals("P"))
			{
				this.setESTADO_2363(" "); // Forzamos estado inicial
			}
			else if (this.getESTADO_2363().trim().equals("K"))
			{
				this.setESTADO_2363("C"); // Forzamos estado inicial
			*/
			if (this.getESTADO_2363().trim().equals("P"))
			{
				this.setESTADO_2363(" "); // Forzamos estado inicial
			}
			else if (this.getESTADO_2363().trim().equals("1"))
			{
				this.setESTADO_2363("C"); // Forzamos estado inicial
			}
			else if (this.getESTADO_2363().trim().equals("2"))
			{
				this.setESTADO_2363("R"); // Forzamos estado inicial
			}
		}
		this.setUUID_2363(pRsCab.getString("UUID_2363"));
		this.setNOTE_2363(pRsCab.getString("NOTE_2363"));
		this.setDIRECCION_WEB_2363(pRsCab.getString("DIRECCION_WEB_2363"));
		this.setFECHA_EXPEDICION_2363(pRsCab.getInt("FECHA_EXPEDICION_2363"));
		this.setMETODO_PAGO_2363(pRsCab.getString("METODO_PAGO_2363"));
		this.setFECHA_PAGO_2363(pRsCab.getInt("FECHA_PAGO_2363"));
		this.setTAX_ID_CARGO_2363(pRsCab.getLong("TAX_ID_CARGO_2363"));
		this.setNOMBRE_CARGO_2363(pRsCab.getString("NOMBRE_CARGO_2363"));
		this.setCODIGO_PEDIDO_2363(pRsCab.getString("CODIGO_PEDIDO_2363"));
		this.setCURRENCY_CODE_2363(pRsCab.getString("CURRENCY_CODE_2363"));
		this.setNUM_LINEAS_2363(pRsCab.getInt("NUM_LINEAS_2363"));
		this.setSUP_PARTY_ID_2363(pRsCab.getString("SUP_PARTY_ID_2363"));
		this.setSUP_PARTY_NAME_2363(pRsCab.getString("SUP_PARTY_NAME_2363"));
		this.setSUP_POST_ID_2363(pRsCab.getString("SUP_POST_ID_2363"));
		this.setSUP_STREET_NAME_2363(pRsCab.getString("SUP_STREET_NAME_2363"));
		this.setSUP_BUILDING_NUM_2363(pRsCab.getString("SUP_BUILDING_NUM_2363"));
		this.setSUP_CITY_SUBDIV_NAME_2363(pRsCab.getString("SUP_CITY_SUBDIV_NAME_2363"));
		this.setSUP_CITY_NAME_2363(pRsCab.getString("SUP_CITY_NAME_2363"));
		this.setSUP_POSTAL_ZONE_2363(pRsCab.getString("SUP_POSTAL_ZONE_2363"));
		this.setSUP_COUNTRY_2363(pRsCab.getString("SUP_COUNTRY_2363"));
		this.setSUP_TAX_NAME_2363(pRsCab.getString("SUP_TAX_NAME_2363"));
		this.setSUP_TELF_2363(pRsCab.getString("SUP_TELF_2363"));
		this.setSUP_FAX_2363(pRsCab.getString("SUP_FAX_2363"));
		this.setSUP_EMAIL_2363(pRsCab.getString("SUP_EMAIL_2363"));
		this.setCUS_PARTY_ID_2363(pRsCab.getString("CUS_PARTY_ID_2363"));
		this.setCUS_SCHEME_ID_2363(pRsCab.getString("CUS_SCHEME_ID_2363"));
		this.setCUS_PARTY_NAME_2363(pRsCab.getString("CUS_PARTY_NAME_2363"));
		this.setCUS_POST_ID_2363(pRsCab.getString("CUS_POST_ID_2363"));
		this.setCUS_STREET_NAME_2363(pRsCab.getString("CUS_STREET_NAME_2363"));
		this.setCUS_BUILDING_NUM_2363(pRsCab.getString("CUS_BUILDING_NUM_2363"));
		this.setCUS_CITY_SUBDIV_NAME_2363(pRsCab.getString("CUS_CITY_SUBDIV_NAME_2363"));
		this.setCUS_CITY_NAME_2363(pRsCab.getString("CUS_CITY_NAME_2363"));
		this.setCUS_POSTAL_ZONE_2363(pRsCab.getString("CUS_POSTAL_ZONE_2363"));
		this.setCUS_COUNTRY_2363(pRsCab.getString("CUS_COUNTRY_2363"));
		this.setCUS_TAX_NAME_2363(pRsCab.getString("CUS_TAX_NAME_2363"));
		this.setCUS_TELF_2363(pRsCab.getString("CUS_TELF_2363"));
		this.setCUS_FAX_2363(pRsCab.getString("CUS_FAX_2363"));
		this.setCUS_EMAIL_2363(pRsCab.getString("CUS_EMAIL_2363"));
		this.setTAX_AMOUNT_2363(pRsCab.getBigDecimal("TAX_AMOUNT_2363"));
		this.setTAX_AMOUNT_ID_2363(pRsCab.getString("TAX_AMOUNT_ID_2363"));
		this.setTAXABLE_AMOUNT_2363(pRsCab.getBigDecimal("TAXABLE_AMOUNT_2363"));
		this.setTAXABLE_AMOUNT_ID_2363(pRsCab.getString("TAXABLE_AMOUNT_ID_2363"));
		this.setSUBTAX_AMOUNT_2363(pRsCab.getBigDecimal("SUBTAX_AMOUNT_2363"));
		this.setSUBTAX_AMOUNT_ID_2363(pRsCab.getString("SUBTAX_AMOUNT_ID_2363"));
		this.setTAX_EXEMPT_REASON_CODE_2363(pRsCab.getString("TAX_EXEMPT_REASON_CODE_2363"));
		this.setTAX_TYPE_CODE_2363(pRsCab.getString("TAX_TYPE_CODE_2363"));
		this.setLINE_EXT_AMOUNT_2363(pRsCab.getBigDecimal("LINE_EXT_AMOUNT_2363"));
		this.setLINE_EXT_AMOUNT_ID_2363(pRsCab.getString("LINE_EXT_AMOUNT_ID_2363"));
		this.setTAX_EXCLUS_AMOUNT_2363(pRsCab.getBigDecimal("TAX_EXCLUS_AMOUNT_2363"));
		this.setTAX_EXCLUS_AMOUNT_ID_2363(pRsCab.getString("TAX_EXCLUS_AMOUNT_ID_2363"));
		this.setTAX_INCLUS_AMOUNT_2363(pRsCab.getBigDecimal("TAX_INCLUS_AMOUNT_2363"));
		this.setTAX_INCLUS_AMOUNT_ID_2363(pRsCab.getString("TAX_INCLUS_AMOUNT_ID_2363"));
		this.setPAYABLE_AMOUNT_2363(pRsCab.getBigDecimal("PAYABLE_AMOUNT_2363"));
		this.setPAYABLE_AMOUNT_ID_2363(pRsCab.getString("PAYABLE_AMOUNT_ID_2363"));
		this.setALLOWANCE_BASE_AMOUNT_2363(pRsCab.getBigDecimal("ALLOWANCE_BASE_AMOUNT_2363"));
		this.setALLOWANCE_AMOUNT_2363(pRsCab.getBigDecimal("ALLOWANCE_AMOUNT_2363"));
		this.setALLOWANCE_ID_2363(pRsCab.getString("ALLOWANCE_ID_2363"));
    }

    /*
     * para cambiar el estado: UPDATE Cbl_fact_turquia_2363 SET ESTADO_2363 = ' '; COMMIT WORK;
     */
    public static String prepareSelectErrors() throws SQLException
    {
    	String sTemplate[] = { "SELECT NUM_FACTURA_2363,", 
    	    	 					"FECHA_2363,", 				
    	    	 					"HORA_2363,", 				
    	    	 					"TIENDA_2363,", 			
    	    	 					"ESTADO_2363,", 			
    	    	 					"ORIGEN_2363,",
    	    	 					"URL_FACTURA_2363 ",	
    	    	 				"FROM Cbl_fact_turquia_2363 ",
    	    	 				//"WHERE ESTADO_2363 IN (' ', 'P', 'C', 'K') AND ",
    	    	 				"WHERE ESTADO_2363 IN (' ', 'P', '1', '2') AND ",
    	    	 				"TRIM(NVL(URL_FACTURA_2363, ' ')) <> ' '"};
    	
    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }

    public static String prepareSelectErrorsOrigen() throws SQLException
    {
    	String sTemplate[] = { "SELECT NUM_FACTURA_2363,", 
    	    	 					"FECHA_2363,", 				
    	    	 					"HORA_2363,", 				
    	    	 					"TIENDA_2363,", 			
    	    	 					"ESTADO_2363,",
    	    	 					"ORIGEN_2363,",
    	    	 					"URL_FACTURA_2363 ",	
    	    	 				"FROM Cbl_fact_turquia_2363 ",
    	    	 				//"WHERE ESTADO_2363 IN (' ', 'P', 'C', 'K') AND ",
    	    	 				"WHERE ESTADO_2363 IN (' ', 'P', '1', '2') AND ",
    	    	 				"ORIGEN_2363 = ? AND ",
    	    	 				"TRIM(NVL(URL_FACTURA_2363, ' ')) <> ' '"};
    	
    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < sTemplate.length; i++) {
    	   result.append( sTemplate[i] );
    	}
    	
    	return result.toString();    
    }

    public void setRowErrors(ResultSet pRsCab) throws SQLException
    {
		this.setNUM_FACTURA_2363(pRsCab.getString("NUM_FACTURA_2363"));
		this.setFECHA_2363(pRsCab.getInt("FECHA_2363"));
		this.setHORA_2363(pRsCab.getString("HORA_2363"));
		this.setTIENDA_2363(pRsCab.getInt("TIENDA_2363"));
		if (this.getESTADO_2363() == null)
		{
			this.setESTADO_2363(" "); // Forzamos estado inicial
		}
		else
		{
			/*
			if (this.getESTADO_2363().trim().equals("P"))
			{
				this.setESTADO_2363(" "); // Forzamos estado inicial
			}
			else if (this.getESTADO_2363().trim().equals("K"))
			{
				this.setESTADO_2363("C"); // Forzamos estado inicial
			}
			*/
			if (this.getESTADO_2363().trim().equals("P"))
			{
				this.setESTADO_2363(" "); // Forzamos estado inicial
			}
			else if (this.getESTADO_2363().trim().equals("1"))
			{
				this.setESTADO_2363("C"); // Forzamos estado inicial
			}
			else if (this.getESTADO_2363().trim().equals("2"))
			{
				this.setESTADO_2363("R"); // Forzamos estado inicial
			}
		}
		this.setORIGEN_2363(pRsCab.getString("ORIGEN_2363"));
		this.setURL_FACTURA_2363(pRsCab.getString("URL_FACTURA_2363"));
    }
}
