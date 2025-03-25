package com.list.home.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.list.home.Model.Eccess;
import com.list.home.repository.EccessRepository;

@Controller
public class EccessController {

	private final EccessRepository eccessRepository;
	
	public EccessController(EccessRepository eccessRepository) {
		this.eccessRepository = eccessRepository;
	}
	
	@GetMapping("submenu/access")
	public String submenu3(Model model) {
															// parameterないで最新情報持ってくる
		 Optional<Eccess> eccessOptional = eccessRepository.findTopByOrderByIdDesc();
		
		 if(eccessOptional.isPresent()) {
			Eccess eccess = eccessOptional.get();
			model.addAttribute("title", eccess.getTitle());
			model.addAttribute("subtitle", eccess.getSubtitle());
		}else {
			model.addAttribute("title", "error");
			model.addAttribute("subtitle", "error");
		}		
		return "submenu/access";
	}
	
	
}
