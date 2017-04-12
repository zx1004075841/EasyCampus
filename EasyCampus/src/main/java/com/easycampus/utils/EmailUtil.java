package com.easycampus.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	private Properties props;
	
	private MimeMessage init(){
		props = new Properties();
		try {
			props.load(this.getClass().getResourceAsStream("mail.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Session session = Session.getDefaultInstance(props);
		return new MimeMessage(session);
	}
	
	public void send(String address,String title) throws AddressException, MessagingException{
		MimeMessage message = init();
		message.setFrom(new InternetAddress(props.getProperty("from")));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(address));
		message.setSubject(title);
		message.
		
	}
}
