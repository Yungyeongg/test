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

	@GetMapping("mainmenu/service")
	public String mainmenu1() {
		return "mainmenu/service";
	}

	@GetMapping("mainmenu/recruitment")
	public String mainmenu2() {
		return "mainmenu/recruitment";
	}

	@GetMapping("mainmenu/inquiry")
	public String mainmenu3() {
		return "mainmenu/inquiry";
	}

	@GetMapping("submenu/introduction")
	public String submenu1() {
		return "submenu/introduction";
	}

	@GetMapping("submenu/ceo")
	public String submenu2() {
		return "submenu/ceo";
	}

	@GetMapping("submenu/access")
	public String submenu3() {
		return "submenu/access";
	}

	@GetMapping("submenu/partner")
	public String submenu4() {
		return "submenu/partner";
	}
	
	@GetMapping("submenu/margin")
	public String submenu5() {
		return "submenu/margin";
	}

	@GetMapping("management/introfix")
	public String management1() {
		return "management/introfix";
	}
	
	@GetMapping("management/menufix")
	public String management3() {
		return "management/menufix";
	}
	
	@GetMapping("management/partnerfix")
	public String management4() {
		return "management/partnerfix";
	}
	
	@GetMapping("management/accessfix")
	public String management5() {
		return "management/accessfix";
	}
}
