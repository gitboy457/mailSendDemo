package javaMailDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;

public class MailSendDemo {
	
	  public static void main(String [] args)  
	   {     
	      // email ID of Recipient. 
	      String recipient = "nileshkumarjaiswal7@gmail.com"; 
	  
	      // email ID of  Sender. 
	      final String sender = "nileshkumarjaiswal46@gmail.com"; 
	      final String password="pr0t0c0l55";
	  
	      // using host as localhost 
	      String host = "localhost"; 
	  
	      // Getting system properties 
	     // Properties properties = System.getProperties(); 
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        
	        VelocityEngine ve = new VelocityEngine();
	        try {
				ve.init();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	      // Setting up mail server 
	    //  prop.setProperty("mail.smtp.host", host); 
	  
	      // creating session object to get properties 
	    // Session session = Session.getDefaultInstance(prop); 
	     Session session = Session.getInstance(props, new Authenticator() {
	    	    @Override
	    	    protected PasswordAuthentication getPasswordAuthentication() {
	    	        return new PasswordAuthentication(sender, password);
	    	    }
	    	});
	  
	     try {
	            //Creating a Message object to set the email content
	            MimeMessage msg = new MimeMessage(session);
	            //Storing the comma seperated values to email addresses
	            String to = recipient;//"recepient1@email.com,recepient2@gmail.com";
	            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
	            addresses in an array of InternetAddress objects*/
	            InternetAddress[] address = InternetAddress.parse(to, true);
	            //Setting the recepients from the address variable
	            msg.setRecipients(Message.RecipientType.TO, address);
	            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
	            msg.setSubject("Sample Mail : " + timeStamp);
	            msg.setSentDate(new Date());
	            msg.setText("hi nilesh kumar");
	            msg.setHeader("XPriority", "1");
	            Transport.send(msg);
	            System.out.println("Mail has been sent successfully");
	        } catch (MessagingException mex) {
	            System.out.println("Unable to send an email" + mex);
	        } 
	   } 
	} 


