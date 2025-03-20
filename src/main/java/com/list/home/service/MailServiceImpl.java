package com.list.home.service;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.list.home.Model.Admin;
import com.list.home.Model.Inquiry;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {
	
	public final JavaMailSender mailSender;
	
	public MailServiceImpl (JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendInquiryMail (List<Admin> adminEmails, Inquiry inquiry) {
		
		try {
	    	MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	        helper.setFrom("yun990217@gmail.com");
	        //helper.setTo(adminEmails.toArray(new String[0]));
	        helper.setTo(adminEmails.stream().map(Admin::getMail).toArray(String[]::new));
	        helper.setSubject("お問い合わせが来ました。");
	        helper.setText(buildEmailContent(inquiry), true);

	        mailSender.send(message);
	        
	       } catch (MessagingException e) {
	    	  
	    	   e.printStackTrace();
	            // または例外を再throwできる
	            throw new RuntimeException("Failed to send email", e);
	       }
	}
	
	public String buildEmailContent(Inquiry inquiry) {
        // お問い合わせの情報を乗せる
        StringBuilder content = new StringBuilder();
        content.append("<h1>お問い合わせ</h1>");
        content.append("<p>番号: ").append(inquiry.getId()).append("</p>");
        content.append("<p>名前: ").append(inquiry.getName()).append("</p>");
        content.append("<p>メール: ").append(inquiry.getMail()).append("</p>");
        content.append("<p>タイトル: ").append(inquiry.getTitle()).append("</p>");
        content.append("<p>内容: ").append(inquiry.getContent()).append("</p>");
        content.append("<p>登録日: ").append(inquiry.getRegist_date()).append("</p>");
        return content.toString();
    }
}
