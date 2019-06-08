package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*
 * Clase para crear el Xml que enviaremos al web service
 */
public class XmlInvoice {

	public static final 	String 		BLANCO = " ";

	private String m_sResponseCode;
	private String m_sResponseDescription;
	private String m_sInvoiceURL;
	private boolean m_USAR_BD;
	
	public XmlInvoice(boolean pUSAR_BD)
	{
		m_USAR_BD = pUSAR_BD;
		m_sResponseCode = m_sResponseDescription = m_sInvoiceURL = null;
	}
	public Long getResponseCode()
	{
        if (m_sResponseCode == null)
        {
        	m_sResponseCode = "0";
        }
		return Long.parseLong(m_sResponseCode);
	}

	public String getResponseDescription()
	{
        if (m_sResponseDescription == null)
        {
        	m_sResponseDescription = BLANCO;
        }
		return m_sResponseDescription;
	}

	public String getInvoiceURL()
	{
        if (m_sInvoiceURL == null)
        {
        	m_sInvoiceURL = BLANCO;
        }
		return m_sInvoiceURL;
	}


	public void parseXMLString(String pStringToParse)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;

		m_sResponseCode = m_sResponseDescription = m_sInvoiceURL = null;

		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(new InputSource(new StringReader(pStringToParse)));
		} catch (ParserConfigurationException e1) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e1.getMessage());
			}
		} catch (SAXException e) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e.getMessage());
			}
		} catch (IOException e) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e.getMessage());
			}
		}

		NodeList responseList = doc.getElementsByTagName("Response");
		for (int i = 0; i < responseList.getLength(); ++i)
		{
		    Element response = (Element) responseList.item(i);
		    //String labTestType = labTest.getAttribute("type");

		    NodeList responseCodeList = response.getElementsByTagName("ResponseCode");
		    for (int j = 0; j < responseCodeList.getLength(); ++j)
		    {
		        Element element = (Element) responseCodeList.item(j);
		        m_sResponseCode = element.getFirstChild().getNodeValue();
		        if ((m_sResponseCode.trim().equals("")) ||(m_sResponseCode == null))
		        	m_sResponseCode = "0";
	        	//System.out.println("ResponseCode=" + responseCode);
		    }
		    NodeList responseDescriptionList = response.getElementsByTagName("ResponseDescription");
		    for (int j = 0; j < responseDescriptionList.getLength(); ++j)
		    {
		        Element element = (Element) responseDescriptionList.item(j);
		        m_sResponseDescription = element.getFirstChild().getNodeValue().toString();
		        //if (m_sResponseDescription.trim().equals(""))
		        //	m_sResponseDescription = "(null)";
	        	//System.out.println("ResponseDescription=" + responseDescription);
		    }
		    NodeList invoiceURLList = response.getElementsByTagName("InvoiceURL");
		    for (int j = 0; j < invoiceURLList.getLength(); ++j)
		    {
		        Element element = (Element) invoiceURLList.item(j);
		        m_sInvoiceURL = element.getFirstChild().getNodeValue().toString();
		        //if (m_sInvoiceURL.trim().equals(""))
		        //	m_sInvoiceURL = "(null)";
	        	//System.out.println("invoiceURL=" + invoiceURL);
		    }
		}
	}
	
	public String generateXml(Cbl_fact_turquia_2363 p_cbl_fact_turquia_2363) throws Exception
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e.getMessage());
			}
		}
		
		// root elements
		Document doc = docBuilder.newDocument();
		Element invoiceElement = doc.createElement("Invoice");
		doc.appendChild(invoiceElement);
		
		Element xmlVersion = doc.createElement("XmlVersionID");
		xmlVersion.appendChild(doc.createTextNode("1.0"));
		invoiceElement.appendChild(xmlVersion);
		
		Element styleSheet = doc.createElement("StyleSheet");
		//styleSheet.appendChild(doc.createTextNode("general_guid"));
		if (p_cbl_fact_turquia_2363.getORIGEN_2363().equals("T"))
		{
			styleSheet.appendChild(doc.createTextNode("f4ff78c1-933b-45e2-89b4-6ec61127b829")); // tiendas
		}
		else
		{
			styleSheet.appendChild(doc.createTextNode("d05cce9e-bdae-4c8b-82f7-15f2f4721980")); // online
		}
		invoiceElement.appendChild(styleSheet);
		
		Element profileID = doc.createElement("ProfileID");
		profileID.appendChild(doc.createTextNode("TEMELFATURA"));
		invoiceElement.appendChild(profileID);
		
		Element iD = doc.createElement("ID");
		iD.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getNUM_FACTURA_2363().trim()));
		invoiceElement.appendChild(iD);
		
		Element uUID = doc.createElement("UUID");
		uUID.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getUUID_2363().trim()));
		invoiceElement.appendChild(uUID);
		
		Element issueDate = doc.createElement("IssueDate");
		String sDate_FECHA_2363 = Long.toString(p_cbl_fact_turquia_2363.getFECHA_2363());
		String sAny_FECHA_2363 = sDate_FECHA_2363.substring(0, 4);
		String sMes_FECHA_2363 = sDate_FECHA_2363.substring(4, 6);
		String sDia_FECHA_2363 = sDate_FECHA_2363.substring(6, 8);
		issueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363));
		invoiceElement.appendChild(issueDate);
		
		Element issueTime = doc.createElement("IssueTime");
		issueTime.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getHORA_2363().trim()));
		invoiceElement.appendChild(issueTime);
		
		Element note = doc.createElement("Note");
		note.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getNOTE_2363().trim()));
		invoiceElement.appendChild(note);
		
		if ((!p_cbl_fact_turquia_2363.getMETODO_PAGO_2363().trim().equals("")) 
				&& (p_cbl_fact_turquia_2363.getMETODO_PAGO_2363() != null) 
				&& (p_cbl_fact_turquia_2363.getORIGEN_2363().trim().equals("T")))
		{
			// Payment method (tiendas)
			Element note2 = doc.createElement("Note");
			note2.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getMETODO_PAGO_2363().trim()));
			invoiceElement.appendChild(note2);
		}
		
		Element invoiceTypeCode = doc.createElement("InvoiceTypeCode");
		// 14/05/2018 Cambio a peticion de Logo, autorizado por Marta Igea
		if (p_cbl_fact_turquia_2363.getTAX_EXEMPT_REASON_CODE_2363().trim().equals("301")) {
			invoiceTypeCode.appendChild(doc.createTextNode("ISTISNA"));
		}
		else
		{
			invoiceTypeCode.appendChild(doc.createTextNode("SATIS"));
		}
		invoiceElement.appendChild(invoiceTypeCode);
		
		Element documentCurrencyCode = doc.createElement("DocumentCurrencyCode");
		documentCurrencyCode.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCURRENCY_CODE_2363().trim()));
		invoiceElement.appendChild(documentCurrencyCode);
		
		Element lineCountNumeric = doc.createElement("LineCountNumeric");
		lineCountNumeric.appendChild(doc.createTextNode(Long.toString(p_cbl_fact_turquia_2363.getNUM_LINEAS_2363())));
		invoiceElement.appendChild(lineCountNumeric);
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String sCurrentDate = dateFormat.format(date);
		String sCurrentAny = sCurrentDate.substring(0, 4);
		String sCurrentMes = sCurrentDate.substring(4, 6);
		String sCurrentDia = sCurrentDate.substring(6, 8);
		String sCurrentHora = sCurrentDate.substring(9, 11);
		String sCurrentMinutos = sCurrentDate.substring(12, 14);
		String sCurrentSegundos = sCurrentDate.substring(15, 17);

		
        if (!(p_cbl_fact_turquia_2363.getCODIGO_PEDIDO_2363().trim().equals("")) && (p_cbl_fact_turquia_2363.getCODIGO_PEDIDO_2363() != null))
        {

        	Element orderReference = doc.createElement("OrderReference");
        	invoiceElement.appendChild(orderReference);
		
        	{ // inside "OrderReference"
        		
        		Element oDiD = doc.createElement("ID");
        		oDiD.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCODIGO_PEDIDO_2363()));
        		orderReference.appendChild(oDiD);
			
        		Element addIssueDate = doc.createElement("IssueDate");
        		addIssueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363)); // FECHA_2363
        		orderReference.appendChild(addIssueDate);
			
        	}
		
        }
        
        // Form of submission
        
		Element additionalDocumentReference = doc.createElement("AdditionalDocumentReference");
		invoiceElement.appendChild(additionalDocumentReference);
		
		{ // inside "AdditionalDocumentReference"
			
			Element addID = doc.createElement("ID");
			addID.appendChild(doc.createTextNode("gonderimSekli"));
			additionalDocumentReference.appendChild(addID);
			
			Element addIssueDate = doc.createElement("IssueDate");
			addIssueDate.appendChild(doc.createTextNode(sCurrentAny + "-" + sCurrentMes + "-" + sCurrentDia));
			additionalDocumentReference.appendChild(addIssueDate);
			
			Element documentType = doc.createElement("DocumentType");
			documentType.appendChild(doc.createTextNode("ELEKTRONIK"));
			additionalDocumentReference.appendChild(documentType);
			
		}
		
		// Date of arrangement
		
		Element additionalDocumentReference2 = doc.createElement("AdditionalDocumentReference");
		invoiceElement.appendChild(additionalDocumentReference2);
		
		{ // inside "AdditionalDocumentReference"
			
			Element addID = doc.createElement("ID");
			addID.appendChild(doc.createTextNode("duzenlemeTarihi"));
			additionalDocumentReference2.appendChild(addID);
			
			Element addIssueDate = doc.createElement("IssueDate");
			addIssueDate.appendChild(doc.createTextNode(sCurrentAny + "-" + sCurrentMes + "-" + sCurrentDia));
			additionalDocumentReference2.appendChild(addIssueDate);
			
			Element documentType = doc.createElement("DocumentType");
			documentType.appendChild(doc.createTextNode(sCurrentHora + ":" + sCurrentMinutos + ":" + sCurrentSegundos));
			additionalDocumentReference2.appendChild(documentType);
			
		}
		
		if ((!p_cbl_fact_turquia_2363.getDIRECCION_WEB_2363().trim().equals("")) && (p_cbl_fact_turquia_2363.getDIRECCION_WEB_2363() != null))
		{
			// Internet Sales Information
			
			Element additionalDocumentReference3 = doc.createElement("AdditionalDocumentReference");
			invoiceElement.appendChild(additionalDocumentReference3);
			
			{ // inside "AdditionalDocumentReference"
				
				Element addID = doc.createElement("ID");
				addID.appendChild(doc.createTextNode("EINVOICE"));
				additionalDocumentReference3.appendChild(addID);
				
				Element documentType = doc.createElement("DocumentType");
				documentType.appendChild(doc.createTextNode("3"));
				additionalDocumentReference3.appendChild(documentType);
				
			}
			
			Element additionalDocumentReference4 = doc.createElement("AdditionalDocumentReference");
			invoiceElement.appendChild(additionalDocumentReference4);
			
			{ // inside "AdditionalDocumentReference"
				
				Element addID = doc.createElement("ID");
				addID.appendChild(doc.createTextNode("internetSatisBilgi/webAdresi"));
				additionalDocumentReference4.appendChild(addID);
				
				Element addIssueDate = doc.createElement("IssueDate");
				addIssueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363));
				additionalDocumentReference4.appendChild(addIssueDate);
				
				Element documentType = doc.createElement("DocumentType");
				documentType.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getDIRECCION_WEB_2363().trim()));
				additionalDocumentReference4.appendChild(documentType);
				
			}
			
		}
		
		if ((p_cbl_fact_turquia_2363.getFECHA_EXPEDICION_2363() != 0) && (p_cbl_fact_turquia_2363.getFECHA_EXPEDICION_2363() != null))
		{
			// Internet Sales Information
			
			String sDate_FECHA_EXPEDICION_2363 = Long.toString(p_cbl_fact_turquia_2363.getFECHA_EXPEDICION_2363());
			String sAny_FECHA_EXPEDICION_2363 = sDate_FECHA_EXPEDICION_2363.substring(0, 4);
			String sMes_FECHA_EXPEDICION_2363 = sDate_FECHA_EXPEDICION_2363.substring(4, 6);
			String sDia_FECHA_EXPEDICION_2363 = sDate_FECHA_EXPEDICION_2363.substring(6, 8);

			Element additionalDocumentReference5 = doc.createElement("AdditionalDocumentReference");
			invoiceElement.appendChild(additionalDocumentReference5);
			
			{ // inside "AdditionalDocumentReference"
				
				Element addID = doc.createElement("ID");
				addID.appendChild(doc.createTextNode("internetSatisBilgi/gonderiBilgileri/gonderimTarihi"));
				additionalDocumentReference5.appendChild(addID);

				Element addIssueDate = doc.createElement("IssueDate");
				addIssueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363));
				additionalDocumentReference5.appendChild(addIssueDate);
				
				Element documentType = doc.createElement("DocumentType");
				documentType.appendChild(doc.createTextNode(sAny_FECHA_EXPEDICION_2363 + "-" + sMes_FECHA_EXPEDICION_2363 + "-" + sDia_FECHA_EXPEDICION_2363));
				additionalDocumentReference5.appendChild(documentType);
				
			}
			
		}
		
		if ((!p_cbl_fact_turquia_2363.getMETODO_PAGO_2363().trim().equals("")) 
				&& (p_cbl_fact_turquia_2363.getMETODO_PAGO_2363() != null) 
				&& (!p_cbl_fact_turquia_2363.getORIGEN_2363().trim().equals("T")))
		{
			// Payment method
			
				Element additionalDocumentReference6 = doc.createElement("AdditionalDocumentReference");
				invoiceElement.appendChild(additionalDocumentReference6);
			
				{ // inside "AdditionalDocumentReference"
					
					Element addID = doc.createElement("ID");
					addID.appendChild(doc.createTextNode("internetSatisBilgi/odemeSekli"));
					additionalDocumentReference6.appendChild(addID);

					Element addIssueDate = doc.createElement("IssueDate");
					addIssueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363));
					additionalDocumentReference6.appendChild(addIssueDate);
				
					Element documentType = doc.createElement("DocumentType");
					documentType.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getMETODO_PAGO_2363().trim()));
					additionalDocumentReference6.appendChild(documentType);
				
				}
			
		}
		
		if ((p_cbl_fact_turquia_2363.getFECHA_PAGO_2363() != 0) && (p_cbl_fact_turquia_2363.getFECHA_PAGO_2363() != null))
		{
			// Payment date
			
			String sDate_FECHA_PAGO_2363 = Long.toString(p_cbl_fact_turquia_2363.getFECHA_PAGO_2363());
			String sAny_FECHA_PAGO_2363 = sDate_FECHA_PAGO_2363.substring(0, 4);
			String sMes_FECHA_PAGO_2363 = sDate_FECHA_PAGO_2363.substring(4, 6);
			String sDia_FECHA_PAGO_2363 = sDate_FECHA_PAGO_2363.substring(6, 8);

			Element additionalDocumentReference7 = doc.createElement("AdditionalDocumentReference");
			invoiceElement.appendChild(additionalDocumentReference7);
			
			{ // inside "AdditionalDocumentReference"
				
				Element addID = doc.createElement("ID");
				addID.appendChild(doc.createTextNode("internetSatisBilgi/odemeTarihi"));
				additionalDocumentReference7.appendChild(addID);

				Element addIssueDate = doc.createElement("IssueDate");
				addIssueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363));
				additionalDocumentReference7.appendChild(addIssueDate);
				
				Element documentType = doc.createElement("DocumentType");
				documentType.appendChild(doc.createTextNode(sAny_FECHA_PAGO_2363 + "-" + sMes_FECHA_PAGO_2363 + "-" + sDia_FECHA_PAGO_2363));
				additionalDocumentReference7.appendChild(documentType);
				
			}
			
		}
		
		if ((p_cbl_fact_turquia_2363.getTAX_ID_CARGO_2363() != 0) && (p_cbl_fact_turquia_2363.getTAX_ID_CARGO_2363() != null))
		{
			// Payment date
			
			Element additionalDocumentReference8 = doc.createElement("AdditionalDocumentReference");
			invoiceElement.appendChild(additionalDocumentReference8);
			
			{ // inside "AdditionalDocumentReference"
				
				Element addID = doc.createElement("ID");
				addID.appendChild(doc.createTextNode("internetSatisBilgi/gonderiBilgileri/gonderiTasiyan/tuzelKisi/vkn"));
				additionalDocumentReference8.appendChild(addID);

				Element addIssueDate = doc.createElement("IssueDate");
				addIssueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363));
				additionalDocumentReference8.appendChild(addIssueDate);
				
				Element documentType = doc.createElement("DocumentType");
				documentType.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAX_ID_CARGO_2363().toString()));
				additionalDocumentReference8.appendChild(documentType);
				
			}
			
		}
		
		if ((!p_cbl_fact_turquia_2363.getNOMBRE_CARGO_2363().trim().equals("")) && (p_cbl_fact_turquia_2363.getNOMBRE_CARGO_2363() != null))
		{
			// Send the carrying
			
			Element additionalDocumentReference9 = doc.createElement("AdditionalDocumentReference");
			invoiceElement.appendChild(additionalDocumentReference9);
			
			{ // inside "AdditionalDocumentReference"
				
				Element addID = doc.createElement("ID");
				addID.appendChild(doc.createTextNode("internetSatisBilgi/gonderiBilgileri/gonderiTasiyan/tuzelKisi/unvan"));
				additionalDocumentReference9.appendChild(addID);

				Element addIssueDate = doc.createElement("IssueDate");
				addIssueDate.appendChild(doc.createTextNode(sAny_FECHA_2363 + "-" + sMes_FECHA_2363 + "-" + sDia_FECHA_2363));
				additionalDocumentReference9.appendChild(addIssueDate);
				
				Element documentType = doc.createElement("DocumentType");
				documentType.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getNOMBRE_CARGO_2363().trim()));
				additionalDocumentReference9.appendChild(documentType);
				
			}
			
		}
		
		
		// Cancelaciones
		//if (p_cbl_fact_turquia_2363.getESTADO_2363().equals("K"))
		if (p_cbl_fact_turquia_2363.getESTADO_2363().equals("2"))
		{
			Element additionalDocumentReference10 = doc.createElement("AdditionalDocumentReference");
			invoiceElement.appendChild(additionalDocumentReference10);
			
			{ // inside "AdditionalDocumentReference"
				
				Element addID = doc.createElement("ID");
				addID.appendChild(doc.createTextNode("faturaIptal"));
				additionalDocumentReference10.appendChild(addID);
				
				Element addIssueDate = doc.createElement("IssueDate");
				addIssueDate.appendChild(doc.createTextNode(sCurrentAny + "-" + sCurrentMes + "-" + sCurrentDia));
				additionalDocumentReference10.appendChild(addIssueDate);
				
				Element documentType = doc.createElement("DocumentType");
				documentType.appendChild(doc.createTextNode("1"));
				additionalDocumentReference10.appendChild(documentType);
			}
		}
		
		Element accountingSupplierParty = doc.createElement("AccountingSupplierParty");
		invoiceElement.appendChild(accountingSupplierParty);
		
		{ // goes inside "AccountingSupplierParty"
			Element partySupplier = doc.createElement("Party");
			accountingSupplierParty.appendChild(partySupplier);
			
			{ // goes inside "Party"
			
				Element partyIdentification = doc.createElement("PartyIdentification");
			
				{ // goes inside "PartyIdentification"
					Element iD2 = doc.createElement("ID");

					{ // attribute
						Attr schemeID = doc.createAttribute("schemeID");
						schemeID.setValue("VKN");
						iD2.setAttributeNode(schemeID);
					}
					iD2.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_PARTY_ID_2363().trim()));
					partySupplier.appendChild(partyIdentification);
					partyIdentification.appendChild(iD2);
				}
				Element partyName = doc.createElement("PartyName");
				partySupplier.appendChild(partyName);
				
				{ // goes inside "PartyName"
					Element name = doc.createElement("Name");
					name.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_PARTY_NAME_2363().trim()));
					partyName.appendChild(name);
				}
				
				Element postalAddress = doc.createElement("PostalAddress");
				partySupplier.appendChild(postalAddress);
				
				{ // inside "PostalAddress"
					Element iD3 = doc.createElement("ID");
					iD3.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_POST_ID_2363().trim()));
					postalAddress.appendChild(iD3);

					Element streetName = doc.createElement("StreetName");
					streetName.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_STREET_NAME_2363().trim()));
					postalAddress.appendChild(streetName);

					Element buildingNumber = doc.createElement("BuildingNumber");
					buildingNumber.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_BUILDING_NUM_2363().trim()));
					postalAddress.appendChild(buildingNumber);

					Element citySubdivisionName = doc.createElement("CitySubdivisionName");
					citySubdivisionName.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_CITY_SUBDIV_NAME_2363().trim()));
					postalAddress.appendChild(citySubdivisionName);

					Element cityName = doc.createElement("CityName");
					cityName.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_CITY_NAME_2363().trim()));
					postalAddress.appendChild(cityName);

					Element postalZone = doc.createElement("PostalZone");
					postalZone.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_POSTAL_ZONE_2363().trim()));
					postalAddress.appendChild(postalZone);

					Element country = doc.createElement("Country");
					postalAddress.appendChild(country);
					
					{ // inside "Country"
						Element name = doc.createElement("Name");
						name.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_COUNTRY_2363().trim()));
						country.appendChild(name);
					}
				}
				
				Element partyTaxScheme = doc.createElement("PartyTaxScheme");
				partySupplier.appendChild(partyTaxScheme);
				
				{ // inside "PartyTaxScheme"
					Element taxScheme = doc.createElement("TaxScheme");
					partyTaxScheme.appendChild(taxScheme);
					
					{ // inside "TaxScheme"
						Element name = doc.createElement("Name");
						name.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_TAX_NAME_2363().trim()));
						taxScheme.appendChild(name);
                        /*
						Element taxTypeCode = doc.createElement("TaxTypeCode");
						taxTypeCode.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_TAX_TYPE_CODE_2363()));
						taxScheme.appendChild(taxTypeCode);
						*/
					}
				}
				
				Element contact = doc.createElement("Contact");
				partySupplier.appendChild(contact);
				
				{ // inside "Contact"
					Element telephone = doc.createElement("Telephone");
					telephone.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_TELF_2363().trim()));
					contact.appendChild(telephone);

					Element telefax = doc.createElement("Telefax");
					telefax.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_FAX_2363().trim()));
					contact.appendChild(telefax);

					Element electronicMail = doc.createElement("ElectronicMail");
					electronicMail.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUP_EMAIL_2363().trim()));
					contact.appendChild(electronicMail);
				}
				
			}
			
			Element accountingCustomerParty = doc.createElement("AccountingCustomerParty");
			invoiceElement.appendChild(accountingCustomerParty);

			{ // goes inside "AccountingCustomerParty"
				Element partyCustomer = doc.createElement("Party");
				accountingCustomerParty.appendChild(partyCustomer);
				
				{ // goes inside "Party"
					
					Element partyIdentification = doc.createElement("PartyIdentification");
					
					{ // goes inside "PartyIdentification"
						Element iD2 = doc.createElement("ID");

						{ // attribute
							Attr schemeID = doc.createAttribute("schemeID");
							schemeID.setValue(p_cbl_fact_turquia_2363.getCUS_SCHEME_ID_2363().trim());
							iD2.setAttributeNode(schemeID);
						}
						iD2.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_PARTY_ID_2363().trim()));
						partyCustomer.appendChild(partyIdentification);
						partyIdentification.appendChild(iD2);
					}
					if (p_cbl_fact_turquia_2363.getCUS_SCHEME_ID_2363().trim().equalsIgnoreCase("VKN"))
					{
						Element partyName = doc.createElement("PartyName");
						partyCustomer.appendChild(partyName);
					
						{ // goes inside "PartyName"
							Element name = doc.createElement("Name");
							name.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_PARTY_NAME_2363().trim()));
							partyName.appendChild(name);
						}
					}
					else
					{
						Element person = doc.createElement("Person");
						partyCustomer.appendChild(person);
					
						{ // goes inside "Person"
							Element firstName = doc.createElement("FirstName");
							StringBuilder myStringBuilder = new StringBuilder();
							String[] splitStr = p_cbl_fact_turquia_2363.getCUS_PARTY_NAME_2363().split("\\s+");
							String sFamilyName = splitStr[(splitStr.length - 1)];
							for (int ix=0; ix < (splitStr.length - 1);ix++)
							{
								//System.out.println(splitStr[ix]);
								myStringBuilder.append(splitStr[ix]);
								myStringBuilder.append(" ");
							}
							String sFirstName = myStringBuilder.toString();
							sFirstName = sFirstName.replace(',', ' ');
							firstName.appendChild(doc.createTextNode(sFirstName.trim()));
							person.appendChild(firstName);

							Element familyName = doc.createElement("FamilyName");
							familyName.appendChild(doc.createTextNode(sFamilyName.trim()));
							person.appendChild(familyName);
						}
					}
					
					Element postalAddress = doc.createElement("PostalAddress");
					partyCustomer.appendChild(postalAddress);
					
					{ // inside "PostalAddress"
						Element iD3 = doc.createElement("ID");
						iD3.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_POST_ID_2363().trim()));
						postalAddress.appendChild(iD3);

						Element streetName = doc.createElement("StreetName");
						streetName.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_STREET_NAME_2363().trim()));
						postalAddress.appendChild(streetName);
						
						Element buildingNumber = doc.createElement("BuildingNumber");
						buildingNumber.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_BUILDING_NUM_2363().trim()));
						postalAddress.appendChild(buildingNumber);

						Element citySubdivisionName = doc.createElement("CitySubdivisionName");
						citySubdivisionName.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_CITY_SUBDIV_NAME_2363().trim()));
						postalAddress.appendChild(citySubdivisionName);

						Element cityName = doc.createElement("CityName");
						cityName.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_CITY_NAME_2363().trim()));
						postalAddress.appendChild(cityName);

						Element postalZone = doc.createElement("PostalZone");
						postalZone.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_POSTAL_ZONE_2363().trim()));
						postalAddress.appendChild(postalZone);

						Element country = doc.createElement("Country");
						postalAddress.appendChild(country);
						
						{ // inside "Country"
							Element name = doc.createElement("Name");
							name.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_COUNTRY_2363().trim()));
							country.appendChild(name);
						}
					}
					
					Element partyTaxScheme = doc.createElement("PartyTaxScheme");
					partyCustomer.appendChild(partyTaxScheme);
					
					{ // inside "PartyTaxScheme"
						Element taxScheme = doc.createElement("TaxScheme");
						partyTaxScheme.appendChild(taxScheme);
						
						{ // inside "TaxScheme"
							Element name = doc.createElement("Name");
							name.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_TAX_NAME_2363().trim()));
							taxScheme.appendChild(name);
                            /*
							Element taxTypeCode = doc.createElement("TaxTypeCode");
							taxTypeCode.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_TAX_TYPE_CODE_2363()));
							taxScheme.appendChild(taxTypeCode);
							*/
						}
					}
					Element contact = doc.createElement("Contact");
					partyCustomer.appendChild(contact);
					
					{ // inside "Contact"
						Element telephone = doc.createElement("Telephone");
						telephone.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_TELF_2363().trim()));
						contact.appendChild(telephone);

						Element telefax = doc.createElement("Telefax");
						telefax.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_FAX_2363().trim()));
						contact.appendChild(telefax);

						Element electronicMail = doc.createElement("ElectronicMail");
						electronicMail.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getCUS_EMAIL_2363().trim()));
						contact.appendChild(electronicMail);
					}
					
					
				}
			}
			Element taxTotal = doc.createElement("TaxTotal");
			invoiceElement.appendChild(taxTotal);
			
			{ // inside "TaxTotal"

				Element taxAmount = doc.createElement("TaxAmount");
				taxAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAX_AMOUNT_2363_toString()));
				
				{ // inside "TaxAmount"
					Attr currencyID = doc.createAttribute("currencyID");
					currencyID.setValue(p_cbl_fact_turquia_2363.getTAX_AMOUNT_ID_2363().trim());
					taxAmount.setAttributeNode(currencyID);
				}

				taxTotal.appendChild(taxAmount);
				
				Element taxSubtotal = doc.createElement("TaxSubtotal");
					
				{ // inside "TaxSubtotal"
						
					Element taxableAmount = doc.createElement("TaxableAmount");
					taxableAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAXABLE_AMOUNT_2363_toString()));

					{ // inside "TaxableAmount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(p_cbl_fact_turquia_2363.getTAXABLE_AMOUNT_ID_2363().trim());
						taxableAmount.setAttributeNode(currencyID);
					}
					
					taxSubtotal.appendChild(taxableAmount);
					
					Element subTaxAmount = doc.createElement("TaxAmount");
					subTaxAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getSUBTAX_AMOUNT_2363_toString()));

					{ // inside "TaxAmount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(p_cbl_fact_turquia_2363.getSUBTAX_AMOUNT_ID_2363().trim());
						subTaxAmount.setAttributeNode(currencyID);
					}
					
					taxSubtotal.appendChild(subTaxAmount);
					
					Element taxCategory = doc.createElement("TaxCategory");

					Element taxExemptionReasonCode = doc.createElement("TaxExemptionReasonCode");
					taxExemptionReasonCode.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAX_EXEMPT_REASON_CODE_2363().trim()));
					taxCategory.appendChild(taxExemptionReasonCode);
					if (!p_cbl_fact_turquia_2363.getTAX_EXEMPT_REASON_CODE_2363().trim().equals(""))
					{
						String Reason = "***Unknown";
						for (VatExceptReason myExcept : ReadExemptionReasons.arVatExceptReason) {
							if (ReadExemptionReasons.arVatExceptReason.contains(p_cbl_fact_turquia_2363.getTAX_EXEMPT_REASON_CODE_2363().trim().equals(myExcept.getCode())))
							{
								Reason = myExcept.getName(); 
							}
						}
						Element taxExemptionReason = doc.createElement("TaxExemptionReason");
						taxExemptionReason.appendChild(doc.createTextNode(Reason));
						taxCategory.appendChild(taxExemptionReason);
					}
					

					{ //inside "TaxCategory"
						Element taxScheme = doc.createElement("TaxScheme");
						
						{ // inside "TaxScheme"
							Element taxTypeCode = doc.createElement("TaxTypeCode");
							taxTypeCode.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAX_TYPE_CODE_2363().trim()));
							taxScheme.appendChild(taxTypeCode);
						}
						
						taxCategory.appendChild(taxScheme);
					}
					
					taxSubtotal.appendChild(taxCategory);
						
				}
				taxTotal.appendChild(taxSubtotal);
				
			}
			
			if (p_cbl_fact_turquia_2363.getALLOWANCE_AMOUNT_2363().intValue() != 0)
			{
				Element allowanceCharge = doc.createElement("AllowanceCharge");
				invoiceElement.appendChild(allowanceCharge);
				{ // inside "AllowanceCharge"
					Element chargeIndicator = doc.createElement("ChargeIndicator");
					chargeIndicator.appendChild(doc.createTextNode("false"));
					allowanceCharge.appendChild(chargeIndicator);

					Element multiplierFactorNumeric = doc.createElement("MultiplierFactorNumeric");
					multiplierFactorNumeric.appendChild(doc.createTextNode("10"));
					allowanceCharge.appendChild(multiplierFactorNumeric);

					Element amount = doc.createElement("Amount");
					amount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getALLOWANCE_AMOUNT_2363_toString()));
					{ // inside "Amount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(p_cbl_fact_turquia_2363.getALLOWANCE_ID_2363().trim());
						amount.setAttributeNode(currencyID);
					}
					allowanceCharge.appendChild(amount);

					Element baseAmount = doc.createElement("BaseAmount");
					baseAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getALLOWANCE_BASE_AMOUNT_2363_toString()));
					{ // inside "Amount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(p_cbl_fact_turquia_2363.getALLOWANCE_ID_2363().trim());
						baseAmount.setAttributeNode(currencyID);
					}
					allowanceCharge.appendChild(baseAmount);

				}

			}

			Element legalMonetaryTotal = doc.createElement("LegalMonetaryTotal");
			invoiceElement.appendChild(legalMonetaryTotal);
			
			{ // inside "LegalMonetaryTotal"
				Element lineExtensionAmount = doc.createElement("LineExtensionAmount");
				lineExtensionAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getLINE_EXT_AMOUNT_2363_toString()));

				{ // inside "LineExtensionAmount"
					Attr currencyID = doc.createAttribute("currencyID");
					currencyID.setValue(p_cbl_fact_turquia_2363.getLINE_EXT_AMOUNT_ID_2363().trim());
					lineExtensionAmount.setAttributeNode(currencyID);
				}
				legalMonetaryTotal.appendChild(lineExtensionAmount);

				Element taxExclusiveAmount  = doc.createElement("TaxExclusiveAmount");
				taxExclusiveAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAX_EXCLUS_AMOUNT_2363_toString()));

				{ // inside "TaxExclusiveAmount"
					Attr currencyID = doc.createAttribute("currencyID");
					currencyID.setValue(p_cbl_fact_turquia_2363.getTAX_EXCLUS_AMOUNT_ID_2363().trim());
					taxExclusiveAmount.setAttributeNode(currencyID);
				}
				legalMonetaryTotal.appendChild(taxExclusiveAmount);

				Element taxInclusiveAmount   = doc.createElement("TaxInclusiveAmount");
				taxInclusiveAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAX_INCLUS_AMOUNT_2363_toString()));

				{ // inside "TaxExclusiveAmount"
					Attr currencyID = doc.createAttribute("currencyID");
					currencyID.setValue(p_cbl_fact_turquia_2363.getTAX_INCLUS_AMOUNT_ID_2363().trim());
					taxInclusiveAmount.setAttributeNode(currencyID);
				}
				legalMonetaryTotal.appendChild(taxInclusiveAmount);

				Element payableAmount   = doc.createElement("PayableAmount");
				payableAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getPAYABLE_AMOUNT_2363_toString()));

				{ // inside "TaxExclusiveAmount"
					Attr currencyID = doc.createAttribute("currencyID");
					currencyID.setValue(p_cbl_fact_turquia_2363.getPAYABLE_AMOUNT_ID_2363().trim());
					payableAmount.setAttributeNode(currencyID);
				}
				legalMonetaryTotal.appendChild(payableAmount);
			}


			Iterator<Cbl_fact_turquia_det_2364> iteratorDet = p_cbl_fact_turquia_2363.getArCbl_fact_turquia_det_2364().iterator();
			while (iteratorDet.hasNext()) 
			{
				Cbl_fact_turquia_det_2364 myCbl_fact_turquia_det_2364 = new Cbl_fact_turquia_det_2364();
				
				myCbl_fact_turquia_det_2364 = iteratorDet.next();

				Element invoiceLine = doc.createElement("InvoiceLine");
				invoiceElement.appendChild(invoiceLine);
				
				Element invoiceLineiD = doc.createElement("ID");
				invoiceLineiD.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getLINEA_2364_toString()));
				invoiceLine.appendChild(invoiceLineiD);

				Element invoicedQuantity = doc.createElement("InvoicedQuantity");
				{ // attribute
					Attr unitCode = doc.createAttribute("unitCode");
					unitCode.setValue("C62");
					invoicedQuantity.setAttributeNode(unitCode);
				}
				invoicedQuantity.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getINVOICED_QUANTITY_2364_toString()));
				invoiceLine.appendChild(invoicedQuantity);

				Element lineExtensionAmount = doc.createElement("LineExtensionAmount");
				{ // attribute
					Attr currencyID = doc.createAttribute("currencyID");
					currencyID.setValue(myCbl_fact_turquia_det_2364.getLINE_EXT_AMOUNT_ID_2364().trim());
					lineExtensionAmount.setAttributeNode(currencyID);
				}
				lineExtensionAmount.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getLINE_EXT_AMOUNT_2364_toString()));
				invoiceLine.appendChild(lineExtensionAmount);

				Element allowanceCharge = doc.createElement("AllowanceCharge");
				invoiceLine.appendChild(allowanceCharge);
					
				{ // Inside "AllowanceCharge"
					Element chargeIndicator = doc.createElement("ChargeIndicator");
					if (myCbl_fact_turquia_det_2364.getALLOW_CHARGE_INDICATOR_2364() == 1)
					{
						chargeIndicator.appendChild(doc.createTextNode("true"));
					}
					else
					{
						chargeIndicator.appendChild(doc.createTextNode("false"));
					}
					allowanceCharge.appendChild(chargeIndicator);

					Element multiplierFactorNumeric = doc.createElement("MultiplierFactorNumeric");
					multiplierFactorNumeric.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getALLOW_MULT_FAC_NUM_2364_toString()));
					allowanceCharge.appendChild(multiplierFactorNumeric);

					Element amount = doc.createElement("Amount");
					amount.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getALLOW_AMOUNT_2364_toString()));

					{ // inside "Amount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(myCbl_fact_turquia_det_2364.getALLOW_AMOUNT_CURR_ID_2364().trim());
						amount.setAttributeNode(currencyID);
					}

					allowanceCharge.appendChild(amount);

					Element baseAmount = doc.createElement("BaseAmount");
					baseAmount.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getALLOW_BASE_AMOUNT_2364_toString()));

					{ // inside "BaseAmount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(myCbl_fact_turquia_det_2364.getALLOW_BASE_CURR_ID_2364().trim());
						baseAmount.setAttributeNode(currencyID);
					}

					allowanceCharge.appendChild(baseAmount);
				}
				
				Element taxTotalDet = doc.createElement("TaxTotal");
				invoiceLine.appendChild(taxTotalDet);
				
				{ // inside "TaxTotal"

					Element taxAmount = doc.createElement("TaxAmount");
					taxAmount.appendChild(doc.createTextNode(p_cbl_fact_turquia_2363.getTAX_AMOUNT_2363_toString()));

					{ // inside "TaxAmount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(p_cbl_fact_turquia_2363.getTAX_AMOUNT_ID_2363().trim());
						taxAmount.setAttributeNode(currencyID);
					}

					taxTotalDet.appendChild(taxAmount);
						
					Element taxSubtotal = doc.createElement("TaxSubtotal");
						
					{ // inside "TaxSubtotal"
							
						Element taxableAmount = doc.createElement("TaxableAmount");
						taxableAmount.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getTAXABLE_AMOUNT_2364_toString()));

						{ // inside "TaxableAmount"
							Attr currencyID = doc.createAttribute("currencyID");
							currencyID.setValue(myCbl_fact_turquia_det_2364.getTAXABLE_AMOUNT_ID_2364().trim());
							taxableAmount.setAttributeNode(currencyID);
						}
						
						taxSubtotal.appendChild(taxableAmount);
						
						Element subTaxAmount = doc.createElement("TaxAmount");
						subTaxAmount.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getSUBTAX_AMOUNT_2364_toString()));

						{ // inside "TaxAmount"
							Attr currencyID = doc.createAttribute("currencyID");
							currencyID.setValue(myCbl_fact_turquia_det_2364.getSUBTAX_AMOUNT_ID_2364().trim());
							subTaxAmount.setAttributeNode(currencyID);
						}
						
						taxSubtotal.appendChild(subTaxAmount);

						Element percent = doc.createElement("Percent");
						percent.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getPERCENT_2364_toString()));
						taxSubtotal.appendChild(percent);

						Element taxCategory = doc.createElement("TaxCategory");
						
						{ //inside "TaxCategory"
							Element taxScheme = doc.createElement("TaxScheme");
							
							{ // inside "TaxScheme"
								Element name = doc.createElement("Name");
								name.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getTAX_NAME_2364().trim()));
								taxScheme.appendChild(name);

								Element taxTypeCode = doc.createElement("TaxTypeCode");
								taxTypeCode.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getTAX_TYPE_CODE_2364()));
								taxScheme.appendChild(taxTypeCode);
							}
							
							taxCategory.appendChild(taxScheme);
						}
						
						taxSubtotal.appendChild(taxCategory);
							
					}
					taxTotalDet.appendChild(taxSubtotal);
					
				}
					
				Element item = doc.createElement("Item");
				invoiceLine.appendChild(item);
					
				{ // inside "Item"
					Element name = doc.createElement("Name");
					name.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getITEM_NAME_2364().trim()));
					item.appendChild(name);

					Element description = doc.createElement("Description");
					description.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getITEM_DESC_2364().trim()));
					item.appendChild(description);
				}

				Element price = doc.createElement("Price");
				invoiceLine.appendChild(price);
					
				{ // inside "Price"
					Element priceAmount = doc.createElement("PriceAmount");
					priceAmount.appendChild(doc.createTextNode(myCbl_fact_turquia_det_2364.getPRECIO_2364_toString()));

					{ // inside "TaxAmount"
						Attr currencyID = doc.createAttribute("currencyID");
						currencyID.setValue(myCbl_fact_turquia_det_2364.getPRECIO_ID_2364().trim());
						priceAmount.setAttributeNode(currencyID);
					}

					price.appendChild(priceAmount);
				}
			}
		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		DOMSource domSource = new DOMSource(doc);
		String entorno = System.getenv("VOL");
		if (entorno == null)
			entorno = "none";
		File myXmlFile = null;
		if (entorno.equals("none"))
		{
			myXmlFile = new File(System.getProperty("user.dir") + File.separator + "logo" + p_cbl_fact_turquia_2363.getNUM_FACTURA_2363() + ".xml");	
		}
		else
		{
			myXmlFile = new File(File.separator + "tmp" + File.separator + "logo" + p_cbl_fact_turquia_2363.getNUM_FACTURA_2363() + ".xml");
		}
		StreamResult streamResult = new StreamResult(myXmlFile);
		String sResult = null;
		try {
			transformer = transformerFactory.newTransformer();
			transformer.transform(domSource, streamResult);

			sResult = FileUtils.readFileToString(myXmlFile);
		} catch (TransformerException e) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e.getMessage());
			}
		} catch (FileNotFoundException e) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e.getMessage());
			}
		} catch (IOException e) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e.getMessage());
			}
		}
		if (m_USAR_BD)
		{
			//myXmlFile.delete();
		}

		return sResult;
	}
}
