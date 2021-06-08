package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class RegisterController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/step1")
	public void step1Get() {
		log.info("step1 ������ ��û");
	}
	
	//step1 ���� ��� ���Ǹ� �� �� �Ѿ����ó��
	
	@PostMapping("/step2")
	public String step2Post(boolean agree,RedirectAttributes rttr) {
		log.info("step2 ������ ��û"+agree);
		
		if(!agree) {
			rttr.addFlashAttribute("check", "false");
			//step1 �ٽ� �����ֱ�
			return "redirect:step1";
		}
		//true
		return "step2";
	}
	
	//ȸ������������ �������� ��Ʈ�ѷ� ����
	//domain => MemberVO(memberTBL)
	@PostMapping("/step3")
	public String step3Post(@ModelAttribute("member") MemberVO vo) {
		log.info("ȸ������ ��û"+vo);
		
		//���� �۾�
		if(service.insert(vo)) {
			return "redirect:/member/login";
		}else {
			return "step2";
		}
		
		//return "step2";
		
	}
	
	// /step2,/step3 ���� ������ �����ϴ� ��� - 405 ����
	@GetMapping(value= {"/step2","/step3"})
	public String handleStep() {
		return "redirect:step1";
	}
}
