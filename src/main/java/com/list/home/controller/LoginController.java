package com.list.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.list.home.Model.Admin;
import com.list.home.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	private final AdminService adminService;
	
	public LoginController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("mainmenu/login")
	public String mainmenu4(Model loginForm, Admin admin) {
		loginForm.addAttribute("admin", admin);
		return "mainmenu/login";
	}
	
	@PostMapping("/login/check")    
							//@ModelAttribute　：id, passwordがadminにオブジェクト自動マッピング 
							//@ValidがチェックしたらBindingResultに検証結果を保存
	public String loginCheck(@Valid @ModelAttribute Admin loginForm, BindingResult result, Model loginErrorMessage, HttpSession session) {

		if (loginForm.getId().isEmpty()) {//isEmpty(): 配列の長さを返還
			loginErrorMessage.addAttribute("idError", "IDを入力してください。");
			return "mainmenu/login";
		}

		if (loginForm.getPassword().isEmpty()) {
			loginErrorMessage.addAttribute("passwordError", "パスワードを入力してください。");
			return "mainmenu/login";
		}

		if (adminService.authenticate(loginForm.getId(),loginForm.getPassword())) {
			
			session.setAttribute("adminId", loginForm.getId());
			return "redirect:/management/manage";
		} else {
			loginErrorMessage.addAttribute("diffError", "IDまたはパスワードが違います。");
			return "mainmenu/login";
		}
}
		// loginでadmin認証して修正画面に遷移
		@GetMapping("management/manage")
		public String management(HttpSession session) {
			 
			String adminId = (String) session.getAttribute("adminId");
			 
			if (adminId == null) {
			        return "redirect:/mainmenu/login";
			    }
			
			return "management/manage";
		}
		
		@GetMapping("management/logout")
		public String logout(HttpSession session){
			session.invalidate();
			return "/index"; //css適用ができないエラー
		}
}
