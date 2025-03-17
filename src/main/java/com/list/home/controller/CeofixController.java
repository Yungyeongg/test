package com.list.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CeofixController {
	
	@GetMapping("management/ceofix")
	public String management2(HttpSession session) {
		
		String adminId = (String) session.getAttribute("adminId");
		 
		if (adminId == null) {
		        return "redirect:/mainmenu/login";
		    }
		return "management/ceofix";
	}
}
