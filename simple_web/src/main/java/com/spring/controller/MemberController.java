package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping("/register")
	public void regist() {
		log.info("register 요청");
	}
	
	@RequestMapping("/modify")
	public String update() {
		log.info("update 요청");
		
		return "member/member_modify";
	}
	@GetMapping("/login")
	public void loginGet() {
		log.info("login 요청");
	}
	
	@PostMapping("/login")
	public void loginPost() {
		log.info("login form 데이터 가져오기");
	}
}
