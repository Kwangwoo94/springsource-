package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SecurityController {
	
	
	@GetMapping("/login")
	public String loginGet() {
		log.info("security-loginForm ��û");
		
		return "/security/loginForm";
	}
	
	@GetMapping("/user-page")
	public String userPage() {
		log.info("security-userpage ��û");
		
		return "/security/UserPage";
	}
	
	@GetMapping("/admin-page")
	public String adminPage() {
		log.info("security-adminpage ��û");
		
		return "/security/AdminPage";
	}
	
	@GetMapping("/login-error.")
	public String loginError(Model model) {
		log.info("�α��� ����");
		
		model.addAttribute("loginError","���̵� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
		
		return "/security/loginForm";
	}
}
