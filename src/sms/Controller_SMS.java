package sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import constant_variables.Constant_variables;

public class Controller_SMS 
{	
	public static void sendSMS(String mobilenumber, String recepient_name)
	{
		System.out.println("Preparing to Send SMS");
		
		Twilio.init(Constant_variables.ACCOUNT_SID, Constant_variables.AUTH_TOKEN);
		
		Message message=Message.creator(new PhoneNumber(mobilenumber), new PhoneNumber(Constant_variables.SENDER_PHONE_NUMBER), 
				"Dear "+recepient_name+", \n"+Constant_variables.BIRTHDAY_WISH_SMS).create();
		
		System.out.println(message.getSid());
		
		System.out.println("SMS sent successfully.");
	}
}