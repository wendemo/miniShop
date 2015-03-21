package cn.springmvc.common;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;


public class SmtpMail {
	
	Session mSession = null;
	
	public SmtpMail(){
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
		properties.setProperty("mail.smtp.auth", "true");//需要验证
		
		mSession = Session.getInstance(properties);
		mSession.setDebug(true);
	}
	
	public void sendMail(String subject, String content)
	{
		Message messgae = new MimeMessage(mSession);
		try {
			//设置发送人
			messgae.setFrom(new InternetAddress("wendemo@163.com"));
			messgae.setSubject(subject);//设置邮件主题
			messgae.setText(content);//设置邮件内容
			
			Transport tran = mSession.getTransport();
			
			tran.connect("smtp.163.com", 25, "wendemo@163.com", "z40255634");
		
			tran.sendMessage(messgae, new Address[]{ new InternetAddress("zhang13730865557@163.com")});
			
			tran.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
