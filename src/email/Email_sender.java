package email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import constant_variables.Constant_variables;

public class Email_sender {
	
	public static void sendmail(String recepient_mail, String recepient_name) throws Exception
	{
		System.out.println("Preparing to send E-mail.");
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		
		Session session=Session.getInstance(properties, new Authenticator() 
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication() 
			{	
				return new PasswordAuthentication(Constant_variables.MYACCOUNTEMAIL, Constant_variables.PASSWORD);
			}
		});	
	
	    Message message=preparemessage(session,Constant_variables.MYACCOUNTEMAIL,recepient_mail,recepient_name);
	    Transport.send(message);
	    System.out.println("Email sent successfully.");
	}

	private static Message preparemessage(Session session, String myaccountemail,String recepient, String student_name) 
	{
		Message message=null;
		try 
		{
			message=new MimeMessage(session);
			message.setFrom(new InternetAddress(myaccountemail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject(Constant_variables.SUBJECT);
			message.setText("Dear "+student_name+", \n"+Constant_variables.BIRTHDAY_WISH_EMAIL);
		} 
		catch (AddressException e) 
		{	
			e.printStackTrace();
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
		return message;
	}
}
