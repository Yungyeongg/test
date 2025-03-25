package com.list.home.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.list.home.Model.Eccess;
import com.list.home.Model.Page;
import com.list.home.repository.PageRepository;

@Controller
public class IntroductionController {
	
	private final PageRepository pageRepository;
	
	public IntroductionController(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}
	
	@GetMapping("submenu/introduction")
	public String submenu1(Model model, Long id) {
		
		Optional<Page> pageOptional = pageRepository.findById(1L);
		
		 if(pageOptional.isPresent()) {
			Page retrievedPage = pageOptional.get();
			
			String title = retrievedPage.getTitle();
			
			int index1 = title.indexOf("IT企業SIS");
			int index2 = title.indexOf("が皆様と共に作っていきます。");
			
			String title1 = (index1 > 0) ? title.substring(0, index1):title;
			String title2 = (index1 >= 0 && index2 > 0) ? title.substring(index1, index2) : "";
			String title3 = (index2 >= 0) ? title.substring(index2) : "";
			
			String contentText = retrievedPage.getContent();
			String[] contents = contentText.split("。");
			
			model.addAttribute("title1", title1);
			model.addAttribute("title2", title2);
			model.addAttribute("title3", title3);
			model.addAttribute("subtitle", retrievedPage.getSubtitle());
			model.addAttribute("file_path", retrievedPage.getFile_path());
			model.addAttribute("contents", contents);
		}else {
			return "redirect:/index";  
		}		
		return "submenu/introduction";
	}
}
