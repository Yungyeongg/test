package com.list.home.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.list.home.Model.Admin;
import com.list.home.Model.Inquiry;
import com.list.home.repository.AdminRepository;
import com.list.home.service.InquiryService;
import com.list.home.service.MailService;

@Controller
public class InquiryController {
	
	private final InquiryService inquiryService;
	
	public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }
	
	@GetMapping("mainmenu/inquiry")
	public String mainmenu3(Model model) {
		Inquiry inquiry = new Inquiry();
		model.addAttribute("inquiry", inquiry);
		return "mainmenu/inquiry";
	}
	
	@PostMapping("/inquery/submit")
    public String submitInquiry(@ModelAttribute Inquiry inquiry) {
		inquiry.setAnswer(0);
		inquiry.setRegist_date(LocalDateTime.now());
        inquiryService.saveInquiry(inquiry);
        return "redirect:/mainmenu/inquiry/success";
    }
	
	@GetMapping("/mainmenu/inquiry/success")
	public String submitInquirySuccess() {
		return "/index";
	}
}
