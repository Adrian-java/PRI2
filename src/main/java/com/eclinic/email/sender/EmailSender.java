package com.eclinic.email.sender;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
	
	private String senderEmail = "eclinicemailsender@gmail.com";
	
	private String subject = "[no-reply] Potwierdzenie wizyty";
	
	private String content = "Szanowny Pacjencie! \n Twoja wizyta została pomyślnie zapisana.";
	
	private String username = "eclinicemailsender";
	
	private String password = "EclinicEmail123"; 
	
	private Properties properties = setEmailServerProperties();
	
	private Session session = createSession(properties);
	
	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void send(String email) {
		try {
			createMessage(email, session);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private Session createSession(Properties properties) {
		return Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
	}

	private Properties setEmailServerProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		return properties;
	}

	private void createMessage(String email, Session session) throws MessagingException, AddressException {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(senderEmail));
		message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(email));
		message.setSubject(subject);
		message.setText(content);

		Transport.send(message);
	}	
}
