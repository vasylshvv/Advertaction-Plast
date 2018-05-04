package plast.org.ua.upu.sendemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailAdvert {
	 private String username;
	    private String password;
	    private Properties props;
	 
	    public SendEmailAdvert(String username, String password) {
	    	this.username = username;
	        this.password = password;
	 
	        props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	    }
	 
	    public void send(String subject, String text, String fromEmail, String toEmail){
	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });
	 
	        try {
	            MimeMessage message = new MimeMessage(session);
	            //от кого
	            message.setFrom(new InternetAddress(username));
	            //кому
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
	            //Заголовок письма
	            message.setHeader("Content-Type", "text/html; charset=UTF-8");
	            message.setSubject(subject, "UTF-8");
	            
	            //текст
	           // message.setText(text);
	            
	            message.setContent(text, "text/html; charset=UTF-8");
	            
	            //Отправляем сообщение
	            Transport.send(message);
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        } finally {
	        	
	        }
	    }
}
