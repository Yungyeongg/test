package com.list.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.list.home.Model.Admin;
import com.list.home.Model.Inquiry;
import com.list.home.repository.AdminRepository;
import com.list.home.repository.InquiryRepository;

import jakarta.transaction.Transactional;

@Service
public class InquiryServiceImpl implements InquiryService {

	private final InquiryRepository inquiryRepository;
	private final AdminRepository adminRepository;
	private final MailService mailService;
	
	public InquiryServiceImpl(InquiryRepository inquiryRepository, AdminRepository adminRepository, MailService mailService) {
		this.inquiryRepository = inquiryRepository;
		this.adminRepository = adminRepository;
		this.mailService = mailService;
	}
	
	@Transactional
	@Override
    public void saveInquiry(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
        List<Admin> adminEmails = adminRepository.findAllMailsNotNull();
		mailService.sendInquiryMail(adminEmails, inquiry);
    }
}