package com.list.home.service;

import java.util.List;

import com.list.home.Model.Admin;
import com.list.home.Model.Inquiry;

public interface MailService {

	public void sendInquiryMail (List<Admin> adminEmails, Inquiry inquiry);
	public String buildEmailContent(Inquiry inquiry);
}
