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
		log.info("로그인 폼 요청");
		
		return "/security/loginForm";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		log.info("로그인 에러");
		
		model.addAttribute("loginError", "아이디나 비밀번호를 확인해 주세요");
		
		return "/security/loginForm";
	}
	
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		log.info("페이지 접근 제한");
		
		return "/security/AccessDenied";
	}
	
	@ResponseBody
	@GetMapping("/auth")
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	/*
	 * {"authorities":[{"authority":"ROLE_USER"}], => 권한정보
	 * "details":{"remoteAddress":"0:0:0:0:0:0:0:1",
	 * "sessionId":"1E77B16004AC08A46C733DE8920E8795"}, => HttpServletRequest에서 얻어낼 수 있는 정보
	 * "authenticated":true,
	 * "principal":{"password":null,"username":"user1", => 인증된 결과(인증된 대상)
	 * "authorities":[{"authority":"ROLE_USER"}],
	 * "accountNonExpired":true,
	 * "accountNonLocked":true,"credentialsNonExpired":true,"enabled":true},"credentials":null,"name":"user1"}
	 */
}
