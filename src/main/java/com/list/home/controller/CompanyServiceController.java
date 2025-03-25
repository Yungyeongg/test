package com.list.home.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.list.home.Model.Page;
import com.list.home.repository.PageRepository;

@Controller
public class CompanyServiceController {
	
private final PageRepository pageRepository;
	
	public CompanyServiceController(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}
	
	@GetMapping("mainmenu/service")
	public String mainmenu1(Model model, Long id) {
		Optional<Page> pageOptional = pageRepository.findById(3L);
		
		 if(pageOptional.isPresent()) {
			Page retrievedPage = pageOptional.get();
			
			String contentText = retrievedPage.getContent();
			String[] contents = contentText.split("\\s+"); //空白を基準で分ける
			
			String content1 = (contents.length > 0) ? contents[0]  : "";
	        String content2 = (contents.length > 1) ? contents[1]  : "";
	        String content3 = (contents.length > 2) ? contents[2]  : "";
	        String content4 = (contents.length > 3) ? contents[3]  : "";
	        String content5 = (contents.length > 4) ? contents[4]  : "";
	        
			model.addAttribute("title", retrievedPage.getTitle());
			model.addAttribute("subtitle", retrievedPage.getSubtitle());
			model.addAttribute("file_path", retrievedPage.getFile_path());
			model.addAttribute("content1", content1);
			model.addAttribute("content2", content2);
			model.addAttribute("content3", content3);
			model.addAttribute("content4", content4);
			model.addAttribute("content5", content5);
		}else {
			return "redirect:/index";  
		}		
		return "mainmenu/service";
	}
}
