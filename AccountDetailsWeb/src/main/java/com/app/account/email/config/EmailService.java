package com.app.account.email.config;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmailWithAttachment(String to, String from, String ccAddress,String sub, String msgBody,String fileName) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(msgBody);
			if( ccAddress != null ){
				helper.setCc(ccAddress);
			}
			
			if( fileName != null ){
				File file = new File(fileName);
					helper.addAttachment(file.getName(), new FileSystemResource(file));
			}
			
			mailSender.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean sendEmailWith(String to, String from, String ccAddress,String sub, String msgBody, byte[] content,String fileName) {
		try {
			SimpleMailMessage helper = new SimpleMailMessage();
			//helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(msgBody);	
			if( ccAddress != null ){
				helper.setCc(ccAddress);
			}
			
			/*if( fileName != null )
					helper.addAttachment(fileName, new ByteArrayResource(content));*/
			
			mailSender.send(helper);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}