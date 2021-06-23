package com.spring.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
public class CommonController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		log.info("Welcome home!");
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginGet() {
		log.info("�α��� �� ��û");
		
		return "/security/loginForm";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		log.info("�α��� ����");
		
		model.addAttribute("loginError", "���̵� ��й�ȣ�� Ȯ���� �ּ���");
		
		return "/security/loginForm";
	}
	
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		log.info("������ ���� ����");
		
		return "/security/AccessDenied";
	}
	
	@ResponseBody
	@GetMapping("/auth")
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	/*
	 * {"authorities":[{"authority":"ROLE_USER"}], => ��������
	 * "details":{"remoteAddress":"0:0:0:0:0:0:0:1",
	 * "sessionId":"1E77B16004AC08A46C733DE8920E8795"}, => HttpServletRequest���� �� �� �ִ� ����
	 * "authenticated":true,
	 * "principal":{"password":null,"username":"user1", => ������ ���(������ ���)
	 * "authorities":[{"authority":"ROLE_USER"}],
	 * "accountNonExpired":true,
	 * "accountNonLocked":true,"credentialsNonExpired":true,"enabled":true},"credentials":null,"name":"user1"}
	 */
}