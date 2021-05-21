package co.edu.poli.ins.service;

import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.ins.model.SMS;

public interface SMSService {
	
	public Message sendSMS(SMS sms);

}