package com.easycampus.utils;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 这个类主要是完成Email发送的功能
 * @author zhangxing
 *
 */
public class EmailUtil {

	private Properties props;
	private Session session;
	private MimeMessage message;
	
	/**
	 * 初始化一些mail必须的参数
	 * @return	MimeMessage的对象
	 */
	private MimeMessage init(){
		props = new Properties();
		try {
			props.load(this.getClass().getResourceAsStream("/mail.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session = Session.getDefaultInstance(props);
		session.setDebug(true);
		return new MimeMessage(session);
	}
	
	/**
	 * 给指定用户发送邮件的方法
	 * @param title 邮件的标题
	 * @param content	邮件的内容
	 * @param address	指定用户的地址
	 * @throws AddressException		地址异常
	 * @throws MessagingException	message异常
	 */
	public void sendToOne(String title,String content,String address) throws AddressException, MessagingException{
		message.setFrom(new InternetAddress(props.getProperty("mail.from")));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(address));
		message.setSubject(title);
		message.setSentDate(new Date(System.currentTimeMillis()));
		message.setText(content);
		Transport transport = session.getTransport();
		transport.connect(props.getProperty("server"), props.getProperty("from"), props.getProperty("password"));
		transport.sendMessage(message, new Address[]{new InternetAddress(address)});
		transport.close();
	}
	
	/**
	 * 给所有用户发送邮件的方法
	 * @param title		邮件的标题
	 * @param content	邮件的内容
	 * @param address	用户的地址
	 * @throws AddressException		地址异常
	 * @throws MessagingException	message异常
	 */
	public void sendToAll(String title,String content,String ...address) throws AddressException, MessagingException{
		message.setFrom(new InternetAddress(props.getProperty("from")));
		message.setSentDate(new Date(System.currentTimeMillis()));
		message.setSubject(title);
		message.setText(content);
		Transport transport = session.getTransport();
		transport.connect(props.getProperty("server"), props.getProperty("from"), props.getProperty("password"));
		InternetAddress[] addresses = new InternetAddress[address.length];
		for(int i = 0; i < address.length; i++){
			addresses[i].setAddress(address[i]);
		}
		transport.sendMessage(message, addresses);
		transport.close();
	}
	
	public EmailUtil(){
		this.message = init();
	}
}
