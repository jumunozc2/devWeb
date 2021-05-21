package co.edu.poli.ins.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.ins.model.SMS;

@Service
public class SMSServiceTwilio implements SMSService{
	
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC2d8ef67d41dbf38f9c92fc37e2631b0f";
    public static final String AUTH_TOKEN = "41278f7cbc7937a95307ae0cded71781";

    @Override
    public Message sendSMS(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(sms.getCelular()),
                new com.twilio.type.PhoneNumber("+16812294129"),//The Twilio phone number
                sms.setBody("TU CUENTA EN EL POLI AH SIDO CREADA SATISFACTORIAMENTE"))
           .create();

        return message;
    }
    
}

