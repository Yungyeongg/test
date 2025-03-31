package com.list.home.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.list.home.Model.Partner;
import com.list.home.repository.PartnerRepository;
import com.list.home.service.PartnerService;

@Controller
public class PartnerController {
	
	private final PartnerRepository partnerRepository;
	private final PartnerService partnerService;
	
	public PartnerController(PartnerRepository partnerRepository, PartnerService partnerService) {
	        this.partnerRepository = partnerRepository;
	        this.partnerService = partnerService;
	    }
	
	  
		/*
		 * @GetMapping("/list") public ResponseEntity<List<Partner>> getPartners() {
		 * 
		 * List<Partner> partners = partnerRepository.findAll();
		 * 
		 * return ResponseEntity.ok(partners); }
		 */
	
	@GetMapping("submenu/partner")
	public String submenuPartner(Model model) {
		
		List<Partner> partners = partnerService.getPartners();
		model.addAttribute("partners", partners);
		  
		partnerService.getPartnerById(1L).ifPresent(partner -> {
		        model.addAttribute("partnerTitle", partner.getTitle());
		        model.addAttribute("partnerSubtitle", partner.getSubtitle());
		    });
		 return "submenu/partner";
	}
	
	@GetMapping("management/partnerfix")
	public String management4(Model model) {
		
		List<Partner> partners = partnerService.getPartners();
		model.addAttribute("partners", partners);
		return "management/partnerfix";
	}
	
	@PostMapping("/savePartners")
	public String savePartners(@RequestParam("partners") List<Partner> partners, @RequestParam("partnerFiles") MultipartFile[] files) {
		partnerService.savePartners(partners, files);
		return "redirect:/submenu/partner";
	}
}
