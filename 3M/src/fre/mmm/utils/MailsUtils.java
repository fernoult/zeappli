package fre.mmm.utils;

import java.io.File;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import fre.mmm.resources.Resources;


public class MailsUtils {

    private final static String MAILER_VERSION = "Java";
    
	public static void sendNavetteHebdoEmail(){
		
		// Init des ressources
		Resources ress = Resources.getInstance();

		// Init de l'expediteur,
		// et du mot de passe expediteur.
		final String userName = ress.getAppliLabel("mail.configuration.expediteur.text");
		final String passw = ress.getAppliLabel("mail.configuration.expediteur.passw");
		
		try {
			
			
			// L'objet de proprietes
			// On y fou les protocole, auth, port,etc...
		    Properties prop = System.getProperties();
			prop.put(ress.getAppliLabel("mail.configuration.smtp.host.text"), 
					ress.getAppliLabel("mail.configuration.smtp.host.value"));
			
			prop.put(ress.getAppliLabel("mail.configuration.smtp.port.text"), 
					ress.getAppliLabel("mail.configuration.smtp.port.value"));
			
			prop.put(ress.getAppliLabel("mail.configuration.smtp.authentification.text"), 
					ress.getAppliLabel("mail.configuration.smtp.authentification.value"));
			
		    prop.put(ress.getAppliLabel("mail.configuration.smtp.ssl.enable.text"), 
		    		ress.getAppliLabel("mail.configuration.smtp.ssl.enable.value"));
		    
		    prop.put(ress.getAppliLabel("mail.configuration.smtp.starttls.enable.text"), 
		    		ress.getAppliLabel("mail.configuration.smtp.starttls.enable.value"));
		    
		    
		    // L'authentification
		     Authenticator auth = new Authenticator() {
	             @Override
	             protected PasswordAuthentication getPasswordAuthentication() {
	                 return new PasswordAuthentication(userName, passw);
	             }
	         };
	         
	         // La piece jointe et le corps du mail
	         File file = ress.getAppliFileDocument(ress.getAppliLabel("document.navette.hebdo.name.text"));
	         FileDataSource fileDataSource = new FileDataSource(file);
	         DataHandler dataHandler = new DataHandler(fileDataSource);
	         
	         StringBuilder corpsMailBuilder = new StringBuilder("<html><body>");
	         corpsMailBuilder.append("<p>Bonjour,<br/></br>");
	         corpsMailBuilder.append("Veuillez trouver ci-joint le fichier navette hebdomadaire.</br></br></p>");
	         corpsMailBuilder.append("<p>Cordialement.</p>");
	         corpsMailBuilder.append("</body></html>");
	         
	         String corpsMail = corpsMailBuilder.toString();
	         
	         MimeBodyPart navette = new MimeBodyPart();
	         MimeBodyPart content = new MimeBodyPart();
	         MimeMultipart mimeMultiPart = new MimeMultipart();
	         
	         
	         try {
	        	/* Les MimeBodyPart */
				navette.setDataHandler(dataHandler);
				navette.setFileName(fileDataSource.getName());
				content.setContent(corpsMail, "text/html");
				
				/* Le MimeMultiPart */
				mimeMultiPart.addBodyPart(content);
				mimeMultiPart.addBodyPart(navette);
				
			} catch (MessagingException MExcep) {
				MExcep.printStackTrace();
			    JOptionPane.showMessageDialog(null, MExcep.getMessage());
			}
	         
	        
	         // L'objet Session
		    Session session = Session.getDefaultInstance(prop, auth);
		    session.setDebug(true);
		    
		    
		    // L'objet Message
		    Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(userName));
		    InternetAddress[] internetAddresses = new InternetAddress[1];
		    internetAddresses[0] = new InternetAddress("do.jianying@gmail.com");
		    message.addRecipients(Message.RecipientType.TO,internetAddresses);
		    message.setSubject(ress.getAppliLabel("document.navette.subject.text"));
		    message.setContent(mimeMultiPart);
		    message.setHeader("X-Mailer", MAILER_VERSION);
		    message.setSentDate(new Date());
		    
		    
		    // Envoi du message
		    Transport transport = session.getTransport("smtp");
		    transport.connect(ress.getAppliLabel("mail.configuration.smtp.host.value"), 
		    		userName, passw);// mail.configuration.expediteur.text
		    message.saveChanges();
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();

		} catch (AddressException AExcept) {
			AExcept.printStackTrace();
		    JOptionPane.showMessageDialog(null, AExcept.getMessage());
		} catch (MessagingException MExcept) {
			MExcept.printStackTrace();
		    JOptionPane.showMessageDialog(null, MExcept.getMessage());
		}
	}
	
	

}
