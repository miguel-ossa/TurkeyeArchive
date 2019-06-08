package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ReadExemptionReasons {

	private final String cnVatExcepts = "./VatExcepts.xml";
	public static List<VatExceptReason> arVatExceptReason;
	
	public static void createReasonList() {
		arVatExceptReason = new ArrayList<VatExceptReason>();
	}
	
	public void parseXmlFile() {
		Document dom = null;
		createReasonList();
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			File file = new File(cnVatExcepts);
			DocumentBuilder db = dbf.newDocumentBuilder();
			//parse using builder to get DOM representation of the XML file
			try {
				dom =  db.parse(file);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			};

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		//get the root elememt
		Element docEle = dom.getDocumentElement();
		
		// ---Averiguar si estamos en pruebas-----
		try
		{
			NodeList cfReason = docEle.getElementsByTagName("VATEXCEPTREASON");
			if (cfReason != null && cfReason.getLength() > 0) {
				for(int i = 0 ; i < cfReason.getLength();i++) {
					Element cfgElement = (Element)cfReason.item(i);
					
					VatExceptReason newReason = new VatExceptReason();
					newReason.setCode(getTextValue(cfgElement, "CODE"));
					newReason.SetName(getTextValue(cfgElement, "NAME"));
					
					arVatExceptReason.add(newReason);
					
					//System.out.println("code=" + newReason.getCode());
					//System.out.println("name=" + newReason.getName());
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println("Error " + ex.getMessage());
		}
	}
	/**
	 * I take a xml element and the tag name, look for the tag and get
	 * the text content 
	 * @param ele
	 * @param tagName
	 * @return
	 */
	private static String getTextValueIndex(Element ele, String tagName, int index) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(index);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	/**
	 * I take a xml element and the tag name, look for the tag and get
	 * the text content 
	 * @param ele
	 * @param tagName
	 * @return
	 */
	private static String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	/**
	 * Calls getTextValue and returns a int value
	 * @param ele
	 * @param tagName
	 * @return
	 */
	private static int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}
}
