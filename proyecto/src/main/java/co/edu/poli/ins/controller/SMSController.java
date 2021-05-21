package co.edu.poli.ins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.ins.model.SMS;
import co.edu.poli.ins.service.SMSService;

@RestController
@CrossOrigin(origins = "*")
public class SMSController {

	@Autowired
	private SMSService smsService;

	@PostMapping("/api/v1/SMS")
	public Message sendSMS(@RequestBody SMS sms) {
		return smsService.sendSMS(sms);
	}

}