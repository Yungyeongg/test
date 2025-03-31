package com.list.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.list.home.Model.Admin;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("submenu/margin")
	public String submenu5() {
		return "submenu/margin";
	}

	@GetMapping("management/introfix")
	public String management1() {
		return "management/introfix";
	}
	
	@GetMapping("management/accessfix")
	public String management5() {
		return "management/accessfix";
	}
}
