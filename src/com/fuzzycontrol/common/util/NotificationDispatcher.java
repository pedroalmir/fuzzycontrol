package com.fuzzycontrol.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author Cleiton Moura, Pedro Almir
 *
 */
public enum NotificationDispatcher {
	
	EMAIL {
		@Override
		public void sendHTMLMessage(String subject, String msg, String email, String name) {
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);
			try {
				MimeMessage message = new MimeMessage(session);
				message.setSubject(subject, "UTF-8");
				/* Set sender */
				message.setFrom(new InternetAddress("petrus.cc@gmail.com", "Pedro Almir"));
				/* Set Recipient */
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(email, name));
				
				/* Create MultiPart mail message */
				Multipart mp = new MimeMultipart();
				/* Create MimeBodyPart */
				MimeBodyPart htmlPart = new MimeBodyPart();
				/* Set mail content */
				htmlPart.setContent(msg, "text/html");
				/* addBodyPart */
				mp.addBodyPart(htmlPart);
				/* Put MultiPart Message in Message Representation */
				message.setContent(mp);
				
				/* Send Mail */
				Transport.send(message);
				/* Logger informations */
				log.info("\n\nSend E-mail to: " + email + " with this message: \n\n" + msg + "\n\n");
			} catch (UnsupportedEncodingException unsupportedEncodingException) {
				unsupportedEncodingException.printStackTrace();
			} catch (MessagingException messagingException) {
				messagingException.printStackTrace();
			}

		}

		@Override
		public void sendSMSMessage(String sourceName, String destinationPhoneNumber, String message) throws Exception {
			throw new Exception("Not supported");
		}
	}, SMS{

		@Override
		public void sendHTMLMessage(String subject, String msg, String email, String name) throws Exception {
			throw new Exception("Not supported");
		}

		@Override
		public void sendSMSMessage(String sourceName, String destinationPhoneNumber, String message) throws Exception {
			/* Make Parameters */
			String params = String.format("chave=%s&de=%s&tel=%s&msg=%s", KEY, sourceName, destinationPhoneNumber, message);
			/* Make URI */
			String uri = new URI("http", URL_DOMAIN, URL_SUBDOMAIN, params, null).toURL().toString();
			
			log.info("URI: " + uri);
			
			URL url = new URL(uri);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line;
		    
		    StringBuffer buffer = new StringBuffer();
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line + "\n");
		    }
		    reader.close();
			
		    log.info("Response: " + buffer.toString());
		}
		
	};
	
	
	private static final Logger log = Logger.getLogger(NotificationDispatcher.class.getName());
	private final static String URL_DOMAIN = "www.dbmkt.com.br";
	private final static String URL_SUBDOMAIN = "/__envio/gw.php";
	private final static String KEY = "f7f7dbfbe951c7224abc996a3f276dfd";
	
	/**
	 * This method is responsible for sending Email messages.
	 * 
	 * @param subject
	 * @param msg
	 * @param email
	 * @param name
	 */
	public abstract void sendHTMLMessage(String subject, String msg, String email, String name) throws Exception;
	/**
	 * This method is responsible for sending SMS messages.
	 * 
	 * @param sourceName
	 * @param destinationPhoneNumber
	 * @param message
	 * @throws Exception
	 * 
	 * @author Pedro Almir
	 */
	public abstract void sendSMSMessage(String sourceName, String destinationPhoneNumber, String message) throws Exception;
}