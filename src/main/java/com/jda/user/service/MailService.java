package com.jda.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {
	@Autowired
	private  JavaMailSender mailSender;
	public  void sendMail(String toAddress, String Subject, String body) 
	{
		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
		passwordResetEmail.setFrom("shravanbossu@gmail.com");
		passwordResetEmail.setTo(toAddress);
		passwordResetEmail.setSubject("Password Reset Request");
		passwordResetEmail.setText(body);
		
		mailSender.send(passwordResetEmail);
		
		System.out.println(Subject);
	}

}