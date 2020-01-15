package com.everis.service;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class SendVerificationCode {

	private static Logger logger = Logger.getLogger(SendVerificationCode.class);

	public static String sendCodeVerification(String name, String email, String code) {
		
		logger.info("Start sendCodeVerification() function, params: email="+email+" and code="+code);
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("noreply.technojava@gmail.com", "zaouiatitechnojava");
				} 
			});
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("noreply.technojava@gmail.com", false));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			msg.setSubject("Verification Code");
			msg.setContent("Hi "+name+",<br/> Here is your verification code : <h2>" + code + "</h2><br/> Thank you", "text/html");
			msg.setSentDate(new Date());

			Transport.send(msg);
			
			logger.info("End sendCodeVerification() function");

			return "Success";
		}

		catch (Exception e) {
			
			logger.info(e.getMessage());
			return "Faillure";
		}
			
	}
}
