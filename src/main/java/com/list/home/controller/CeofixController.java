package com.list.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.list.home.Model.Page;
import com.list.home.service.CeofixService;

import org.springframework.ui.Model;   
import jakarta.servlet.http.HttpSession;

@Controller
public class CeofixController {
	
	private final CeofixService ceofixService;
	
	public CeofixController(CeofixService ceofixService) {
		this.ceofixService = ceofixService;
	}
	
	@GetMapping("management/ceofix")
	public String ceoFixForm(HttpSession session, Model model) {
	    
		String adminId = (String) session.getAttribute("adminId");
		 
		if (adminId == null) {
		        return "redirect:/mainmenu/login";
		    }
		//Page page = ceofixService.findPage();	   
		Page  page = new Page(); // id가 없으면 새 객체 생성
	    model.addAttribute("page", page);
	    return "management/ceofix";
	}
	
	@PostMapping("/ceofix/save")
    public String saveCeofix(
    		@RequestParam(value = "id", required = false) Long id,
            @RequestParam("title") String title,
            @RequestParam("subtitle") String subtitle,
            @RequestParam("content") String content,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            ceofixService.saveOrUpdateCeo(id, title, subtitle, content, file);
            return "redirect:/submenu/ceo";
        } catch (Exception e) {
            return "redirect:/management/ceofix";
        }
    }
}
