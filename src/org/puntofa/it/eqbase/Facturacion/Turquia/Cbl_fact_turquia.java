package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;

/*
 * Clase que representa un registro de la tabla Cbl_fact_turquia_2363 (cabecera facturas Turquia)
 * con sus lineas (Cbl_fact_turquia_det_2364)
 */
public class Cbl_fact_turquia {

	public static final 	String 		BLANCO = " ";

	// Fila de cabecera de factura
	private Cbl_fact_turquia_2363 m_cbl_fact_turquia_2363;
	
	public void finalize()
	{
		m_cbl_fact_turquia_2363 = null;
		try {
			super.finalize();
		} catch (Throwable e) {
			Main.logger.log(Level.WARNING, e.getMessage());
		}
	}
	
	public Cbl_fact_turquia_2363 getCbl_fact_turquia_2363()
	{
		return m_cbl_fact_turquia_2363;
	}
	
	public void setCbl_fact_turquia_2363(Cbl_fact_turquia_2363 p_cbl_fact_turquia_2363)
	{
		m_cbl_fact_turquia_2363 = p_cbl_fact_turquia_2363;
	}

	public void createSample(Integer p_number)
	{
		Integer number = p_number; //+ 1000;
		Integer num_lineas = (int) (Math.random() * 10)+1; // líneas aleatorias, de 1 a 20
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat yearFormat = new SimpleDateFormat("yyyy");
		String sNumFactura = "CAX" + yearFormat.format(date) + String.format("%09d", number);
		
		m_cbl_fact_turquia_2363 = null;
		
		m_cbl_fact_turquia_2363 = new Cbl_fact_turquia_2363();
		
		m_cbl_fact_turquia_2363.setNUM_FACTURA_2363(sNumFactura);

		m_cbl_fact_turquia_2363.setORIGEN_2363("T");
		m_cbl_fact_turquia_2363.setFECHA_2363(Integer.parseInt(dateFormat.format(date)));
		m_cbl_fact_turquia_2363.setHORA_2363("09:03:00");
		m_cbl_fact_turquia_2363.setTIENDA_2363(number);
		m_cbl_fact_turquia_2363.setESTADO_2363(BLANCO);
		m_cbl_fact_turquia_2363.setUUID_2363(UUID.randomUUID().toString());
		m_cbl_fact_turquia_2363.setNOTE_2363("YUZ YIRMI BES MILYON BES YUZ BIN YEDI YUZ OTUZ ALTI TURK LIRASI OTUZ UC KURUS");
		m_cbl_fact_turquia_2363.setCODIGO_PEDIDO_2363("1234567890");
		m_cbl_fact_turquia_2363.setCURRENCY_CODE_2363("TRY");
		m_cbl_fact_turquia_2363.setNUM_LINEAS_2363(num_lineas); // Número de líneas
		m_cbl_fact_turquia_2363.setSUP_PARTY_ID_2363("1234567890");
		m_cbl_fact_turquia_2363.setSUP_PARTY_NAME_2363("5" + "-" + number.toString());
		m_cbl_fact_turquia_2363.setSUP_POST_ID_2363("6" + "-" + number.toString());
		m_cbl_fact_turquia_2363.setSUP_STREET_NAME_2363("7" + "-" + number.toString());
		m_cbl_fact_turquia_2363.setSUP_BUILDING_NUM_2363(number.toString());
		m_cbl_fact_turquia_2363.setSUP_CITY_SUBDIV_NAME_2363("Sabadell");
		m_cbl_fact_turquia_2363.setSUP_CITY_NAME_2363("Barna");
		m_cbl_fact_turquia_2363.setSUP_POSTAL_ZONE_2363("08180");
		m_cbl_fact_turquia_2363.setSUP_COUNTRY_2363("Spain");
		m_cbl_fact_turquia_2363.setSUP_TAX_NAME_2363("8");
		m_cbl_fact_turquia_2363.setSUP_TELF_2363("555-55-55");
		m_cbl_fact_turquia_2363.setSUP_FAX_2363("666-66-66");
		m_cbl_fact_turquia_2363.setSUP_EMAIL_2363("chewacca@yahoo.com");
		m_cbl_fact_turquia_2363.setCUS_PARTY_ID_2363("98765432101");
		m_cbl_fact_turquia_2363.setCUS_SCHEME_ID_2363("TCKN");
		if (number == 1)
		{
			m_cbl_fact_turquia_2363.setCUS_PARTY_NAME_2363("Miguel de la Ossa Abellán");
		}
		else
		{
			m_cbl_fact_turquia_2363.setCUS_PARTY_NAME_2363("Miguel de la Ossa, Abellán");
		}
		m_cbl_fact_turquia_2363.setCUS_POST_ID_2363("12" + "-" + number.toString());
		m_cbl_fact_turquia_2363.setCUS_STREET_NAME_2363("13" + "-" + number.toString());
		m_cbl_fact_turquia_2363.setCUS_BUILDING_NUM_2363(number.toString());
		m_cbl_fact_turquia_2363.setCUS_CITY_SUBDIV_NAME_2363("Sabadell");
		m_cbl_fact_turquia_2363.setCUS_CITY_NAME_2363("Barna");
		m_cbl_fact_turquia_2363.setCUS_POSTAL_ZONE_2363("08180");
		m_cbl_fact_turquia_2363.setCUS_COUNTRY_2363("Spain");
		m_cbl_fact_turquia_2363.setCUS_TAX_NAME_2363("14");
		//m_cbl_fact_turquia_2363.setCUS_TAX_TYPE_CODE_2363("15");
		m_cbl_fact_turquia_2363.setCUS_TELF_2363("444-44-44");
		m_cbl_fact_turquia_2363.setCUS_FAX_2363("333-33-33");
		m_cbl_fact_turquia_2363.setCUS_EMAIL_2363("dart.vader@yahoo.com");
		m_cbl_fact_turquia_2363.setTAX_AMOUNT_2363(new BigDecimal("125500736.33"));
		m_cbl_fact_turquia_2363.setTAXABLE_AMOUNT_2363(new BigDecimal("5500736.33"));
		m_cbl_fact_turquia_2363.setSUBTAX_AMOUNT_2363(new BigDecimal("5500736.33"));
		//m_cbl_fact_turquia_2363.setTAX_EXEMPT_REASON_CODE_2363("301");
		m_cbl_fact_turquia_2363.setTAX_EXEMPT_REASON_CODE_2363(" ");
		m_cbl_fact_turquia_2363.setTAX_AMOUNT_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setTAXABLE_AMOUNT_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setSUBTAX_AMOUNT_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setTAX_TYPE_CODE_2363("0015");
		m_cbl_fact_turquia_2363.setLINE_EXT_AMOUNT_2363(new BigDecimal("0.0"));
		m_cbl_fact_turquia_2363.setLINE_EXT_AMOUNT_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setTAX_EXCLUS_AMOUNT_2363(new BigDecimal("0.0"));
		m_cbl_fact_turquia_2363.setTAX_EXCLUS_AMOUNT_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setTAX_INCLUS_AMOUNT_2363(new BigDecimal("0.0"));
		m_cbl_fact_turquia_2363.setTAX_INCLUS_AMOUNT_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setPAYABLE_AMOUNT_2363(new BigDecimal("125500736.33"));
		m_cbl_fact_turquia_2363.setPAYABLE_AMOUNT_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setALLOWANCE_BASE_AMOUNT_2363(new BigDecimal("0.0"));
		m_cbl_fact_turquia_2363.setALLOWANCE_AMOUNT_2363(new BigDecimal("0.0"));
		m_cbl_fact_turquia_2363.setALLOWANCE_ID_2363("TRY");
		m_cbl_fact_turquia_2363.setURL_FACTURA_2363(BLANCO);

		m_cbl_fact_turquia_2363.createSampleDet(sNumFactura, num_lineas);
		
	}
	

}
