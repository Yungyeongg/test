package com.list.home.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.list.home.Model.Eccess;
import com.list.home.Model.Inquiry;
import com.list.home.Model.Page;
import com.list.home.repository.PageRepository;
import com.list.home.service.CeofixService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CeoController {
	
	private final PageRepository pageRepository;
	private final CeofixService ceofixService;
	
	public CeoController(PageRepository pageRepository, CeofixService ceofixService) {
		this.pageRepository = pageRepository;
		this.ceofixService = ceofixService;
		
	}
	
	@GetMapping("submenu/ceo")
	public String submenu1(Model model, Long id) {
		
		Optional<Page> pageOptional = pageRepository.findById(2L);
		
		 if(pageOptional.isPresent()) {
			Page retrievedPage = pageOptional.get();
			
			String contentText = retrievedPage.getContent();
			String[] contents = contentText.split("。");
			//budoux
			String content1 = (contents.length > 0) ? contents[0] + "。" : "";
	        String content2 = (contents.length > 1) ? contents[1] + "。" : "";
	        String content3 = (contents.length > 2) ? contents[2] + "。" : "";
	        String content4 = (contents.length > 3) ? contents[3] + "。" : "";
	        
			model.addAttribute("title", retrievedPage.getTitle());
			model.addAttribute("subtitle", retrievedPage.getSubtitle());
			model.addAttribute("file_path", retrievedPage.getFile_path());
			model.addAttribute("content1", content1);
			model.addAttribute("content2", content2);
			model.addAttribute("content3", content3);
			model.addAttribute("content4", content4);
		}else {
			return "redirect:/index";  
		}		
		return "submenu/ceo";
	}
	
	@GetMapping("/management/ceofix")
	public String managementCeo(Model model) {
		Page page = new Page();
		model.addAttribute("page", page);
		return "management/ceofix";
	}
	
	//MultipartFileをfile_pathに自動バインディングしない:MultipartFileは別途で処理,file_pathはファイルをサーバーに保存以降手動設定
	@PostMapping("/ceofix/save")
	public String coeFix(@ModelAttribute Page page, @RequestParam("file") MultipartFile file) {
		
		System.out.println("Page data: " + page);
		
		if(file != null && !file.isEmpty()) {
			 System.out.println("file: " + file.getOriginalFilename());
		}
		else {
			  System.out.println("no file");
		}
		
		try {
			ceofixService.updateCeo(2L, page.getTitle(), page.getSubtitle(), page.getContent(), file);
		} catch(Exception e) {
			  e.printStackTrace();
			  return "redirect:/management/manage";  
		}
		return "redirect:/ceofixSuccess";
	}
	
	@GetMapping("/ceofixSuccess")
	public String ceoFixSuccess(Model model, Long id) {
		
		Optional<Page> pageOptional = pageRepository.findById(2L);
		
		 if(pageOptional.isPresent()) {
			Page retrievedPage = pageOptional.get();
			
			String contentText = retrievedPage.getContent();
			String[] contents = contentText.split("。");
			
			String content1 = (contents.length > 0) ? contents[0] + "。" : "";
	        String content2 = (contents.length > 1) ? contents[1] + "。" : "";
	        String content3 = (contents.length > 2) ? contents[2] + "。" : "";
	        String content4 = (contents.length > 3) ? contents[3] + "。" : "";
	        
			model.addAttribute("title", retrievedPage.getTitle());
			model.addAttribute("subtitle", retrievedPage.getSubtitle());
			model.addAttribute("file_path", retrievedPage.getFile_path());
			model.addAttribute("content1", content1);
			model.addAttribute("content2", content2);
			model.addAttribute("content3", content3);
			model.addAttribute("content4", content4);
		}else {
			return "redirect:/index";  
		}		
		return "submenu/ceo";
	}
}
