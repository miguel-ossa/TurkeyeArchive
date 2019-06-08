package org.puntofa.it.eqbase.Facturacion.Turquia;

import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	private static boolean m_USAR_BD;
    private static final String SMTP_HOST_NAME = "pappexch01.intranet.mango.es";
    private static final String SMTP_AUTH_USER = "notifications@mango.com";
    private static final String SMTP_AUTH_PWD  = "u5qfCF0D";
    
	public static void setDebug(boolean pDEBUG)
	{
	}
	
	public static void setUsarBD(boolean pUSAR_BD)
	{
		m_USAR_BD = pUSAR_BD;
	}
	
	public static void Sendmail(String asunto, String ficheroLogErr)
	{
		java.net.InetAddress localMachine = null;
		try {
			localMachine = java.net.InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e1.getMessage());
			}
			else
			{
				e1.printStackTrace();
			}
		}
		
		Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", false);
	    props.put("mail.smtp.host", SMTP_HOST_NAME);
	    props.put("mail.smtp.starttls.required", false);
	    
	    Session session = Session.getInstance(props, null);
	    try
	    {
	    	String hostName = localMachine.getHostName();
	    	if (hostName == null) hostName = "Unknown";
	    	
	    	Message message = new MimeMessage(session);
	    	message.setContent(message, "text/plain; charset=UTF-8");
	    	//message.setFrom(new InternetAddress("TurkeyeArchive@mango.com"));
	    	message.setFrom(new InternetAddress(SMTP_AUTH_USER));
			String entorno = System.getenv("VOL");
	    	if ((hostName.equals("D-A0D3C114552C")) || !(entorno.equals("/MNG")))
	    	{
	    		String user = System.getenv("LOGNAME");
	    		if (user == null)
	    		{
	    			message.setRecipients(Message.RecipientType.TO,
	    					InternetAddress.parse("miguel.ossa@mango.com"));
	    		}
	    		else
	    		{
	    			message.setRecipients(Message.RecipientType.TO,
	    					InternetAddress.parse(user + "@mango.com"));
	    			message.setRecipients(Message.RecipientType.CC,
	    					InternetAddress.parse("miguel.ossa@mango.com"));
	    		}
	    	}
	    	else
	    	{
	    		message.setRecipients(Message.RecipientType.TO,
	    				InternetAddress.parse("eqp.base@mango.com"));
	    		message.setRecipients(Message.RecipientType.CC,
	    				InternetAddress.parse("eqg2.support@mango.com, equipo.tiendas@mango.com, eqp.mol.support@mango.com"));
	    	}
    		message.setSubject(asunto + " en " + hostName);
	    	
			String myLogFileName = ficheroLogErr;
	    	String logShortCut = myLogFileName.toLowerCase();
	    	try
	    	{
	    		logShortCut = logShortCut.replaceAll("c:", "");
	    		logShortCut = logShortCut.replaceAll("d:", "");
	    		logShortCut = logShortCut.replaceAll(".txt", ".err");
	    		logShortCut = logShortCut.replace('/', '\\');
	    	}
	    	catch(Exception e) {}
	    	
	        message.setText(logShortCut);

	        Transport transport = session.getTransport("smtp");
	        transport.connect(SMTP_HOST_NAME, SMTP_AUTH_USER, SMTP_AUTH_PWD);
	        
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();

	    } catch (MessagingException e) {
    		System.out.println("SendMail Error " + e.getMessage());
	    	
	    	if (m_USAR_BD)
	    	{
	    		Main.logger.log(Level.FINE, e.getMessage());
	    	}
	    	else
	    	{
	    		e.printStackTrace();
	    	}
	    }
	}

	public static void SendmailEInvoice(String pError, String pFactura, String pOrigen, String pPedido)
	{
		java.net.InetAddress localMachine = null;
		try {
			localMachine = java.net.InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			if (m_USAR_BD)
			{
				Main.logger.log(Level.FINE, e1.getMessage());
			}
			else
			{
				e1.printStackTrace();
			}
		}
		
		Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", false);
	    props.put("mail.smtp.host", SMTP_HOST_NAME);
	    props.put("mail.smtp.starttls.required", false);

	    Session session = Session.getInstance(props, null);
	    try
	    {
	    	String hostName = localMachine.getHostName();
	    	if (hostName == null) hostName = "Unknown";
	    	
	    	Message message = new MimeMessage(session);
	    	message.setContent(message, "text/plain; charset=UTF-8");
	    	//message.setFrom(new InternetAddress("TurkeyeArchive@mango.com"));
	    	message.setFrom(new InternetAddress(SMTP_AUTH_USER));
			String entorno = System.getenv("VOL");
    		String user = System.getenv("LOGNAME");
	    	if ((hostName.equals("D-A0D3C114552C")) || !(entorno.equals("/MNG")))
	    	{
	    		if (user == null)
	    		{
	    			message.setRecipients(Message.RecipientType.TO,
	    					InternetAddress.parse("miguel.ossa@mango.com"));
	    		}
	    		else
	    		{
	    			message.setRecipients(Message.RecipientType.TO,
	    					InternetAddress.parse(user + "@mango.com"));
	    			message.setRecipients(Message.RecipientType.CC,
	    					InternetAddress.parse("miguel.ossa@mango.com"));
	    		}
	    	}
	    	else
	    	{
	    		message.setRecipients(Message.RecipientType.TO,
	    				InternetAddress.parse("it.tst@mango.com, marta.igea@mango.com, ruben.aguilera@mango.com, lorena.iglesias@mango.com"));
    			message.setRecipients(Message.RecipientType.CC,
    					InternetAddress.parse("miguel.ossa@mango.com"));
	    	}
    		message.setSubject("Error e-Invoice " + pFactura + ", origen " + pOrigen + " en " + hostName + "\n\n" +
	    	                   "Guia errores: https://confluence.mango.com/pages/viewpage.action?pageId=10177502");
	    	
    		if ((pPedido.trim().equals("")) || (pPedido == null))
    		{
    			message.setText("Error=[" + pError + "]");
    		}
    		else
    		{
    			message.setText("Error=[" + pError + "]\n\nPedido: " + pPedido);
    		}

	        Transport transport = session.getTransport("smtp");
	        transport.connect(SMTP_HOST_NAME, SMTP_AUTH_USER, SMTP_AUTH_PWD);
	        
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();

	    } catch (MessagingException e) {
	    	if (m_USAR_BD)
	    	{
	    		Main.logger.log(Level.FINE, e.getMessage());
	    	}
	    	else
	    	{
	    		e.printStackTrace();
	    	}
	    }
	}
	
}
class SMTPAuthenticator extends javax.mail.Authenticator {
    private static final String SMTP_AUTH_USER = "bm90aWZpY2F0aW9uc0BtYW5nby5jb20="; //notifications@mango.com
    private static final String SMTP_AUTH_PWD  = "dTVxZkNGMEQ="; //u5qfCF0D

    public PasswordAuthentication getPasswordAuthentication() {
       String username = SMTP_AUTH_USER;
       String password = SMTP_AUTH_PWD;
       return new PasswordAuthentication(username, password);
    }
}
