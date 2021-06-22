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
		log.info("register ��û");
	}
	
	@RequestMapping("/modify")
	public String update() {
		log.info("update ��û");
		
		return "member/member_modify";
	}
	@GetMapping("/login")
	public void loginGet() {
		log.info("login ��û"); //member/login jsp�� ã�µ� ����
	}
	
	//������� �Է°� �������� - 1)HttpServletRequest req 2)���� ������ ȣ��(�� �ʵ� �̸��� ��ġ)

	//@PostMapping("/login")
	//public void loginPost(HttpServletRequest req) {
	//	log.info("login form ������ ��������");
	//	log.info("userid : "+req.getParameter("userid"));
	//	log.info("password : "+req.getParameter("password"));
	//}
//	@PostMapping("/login")
//	public void loginPost(@RequestParam("userid")String userid,String password) {
//		log.info("login form ������ ��������");
//		log.info("userid : "+userid);
//		log.info("password : "+password);
//	}
//	
//	@PostMapping("/login")
//	public String loginPost(LoginVO vo,Model model) {
//		//LoginVO vo => �̸��� loginVO�� ������
//		log.info("login form ������ ��������");
//		log.info("userid : "+vo.getUserid());
//		log.info("password : "+vo.getPassword());
//		
//		model.addAttribute("page", 1);
//		//���� �۾�
//		
//		//DB �۾�
//		
//		return "result"; // forward ��� + /WEB-INF/views/result ������ ����
//	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("vo") LoginVO vo,Model model) {
		//LoginVO vo => �̸��� �����ϰ� �ʹٸ�?
		log.info("login form ������ ��������");
		log.info("userid : "+vo.getUserid());
		log.info("password : "+vo.getPassword());
		
		model.addAttribute("page", 1);
	
		return "result"; 
	}
	
	
}
