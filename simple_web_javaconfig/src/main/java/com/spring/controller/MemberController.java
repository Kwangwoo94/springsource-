package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginVO;

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
		log.info("login 요청"); //member/login jsp를 찾는데 사용됨
	}
	
	//사용자의 입력값 가져오기 - 1)HttpServletRequest req 2)변수 선언후 호출(폼 필드 이름과 일치)

	//@PostMapping("/login")
	//public void loginPost(HttpServletRequest req) {
	//	log.info("login form 데이터 가져오기");
	//	log.info("userid : "+req.getParameter("userid"));
	//	log.info("password : "+req.getParameter("password"));
	//}
//	@PostMapping("/login")
//	public void loginPost(@RequestParam("userid")String userid,String password) {
//		log.info("login form 데이터 가져오기");
//		log.info("userid : "+userid);
//		log.info("password : "+password);
//	}
//	
//	@PostMapping("/login")
//	public String loginPost(LoginVO vo,Model model) {
//		//LoginVO vo => 이름은 loginVO로 설정됨
//		log.info("login form 데이터 가져오기");
//		log.info("userid : "+vo.getUserid());
//		log.info("password : "+vo.getPassword());
//		
//		model.addAttribute("page", 1);
//		//서비스 작업
//		
//		//DB 작업
//		
//		return "result"; // forward 방식 + /WEB-INF/views/result 페이지 지시
//	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("vo") LoginVO vo,Model model) {
		//LoginVO vo => 이름을 지정하고 싶다면?
		log.info("login form 데이터 가져오기");
		log.info("userid : "+vo.getUserid());
		log.info("password : "+vo.getPassword());
		
		model.addAttribute("page", 1);
	
		return "result"; 
	}
	
	
}
