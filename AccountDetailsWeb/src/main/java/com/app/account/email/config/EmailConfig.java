package com.app.account.email.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Configuration
@Component
@PropertySource("classpath:mail.properties")
public class EmailConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	public JavaMailSender getMailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setJavaMailProperties(getMailProperties());
		mailSender.setHost(environment.getProperty("mail.host"));
		mailSender.setPort(Integer.valueOf(environment.getProperty("mail.port")));
		mailSender.setUsername(environment.getProperty("mail.username"));
		mailSender.setPassword(environment.getProperty("mail.password"));
		return mailSender;
	}
	
	private Properties getMailProperties(){
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.protocol", environment.getProperty("mail.smtp.protocol"));
		properties.put("mail.smtp.ssl.trust",environment.getProperty("mail.host"));
		properties.setProperty("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
		properties.setProperty("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable"));
		properties.setProperty("mail.debug", environment.getProperty("mail.debug"));
		
		return properties;
		
	}
	
	
	
}
