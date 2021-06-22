package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.CalcVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/calc/*")
public class AddController {
	
	@GetMapping("/add")
	//@RequestMapping(value="/add",method=RequestMethod.GET)
	public void addForm() {
		log.info("add.jsp ��û");
	}
	@GetMapping("/four")
	public void fourForm() {
		log.info("fout.jsp ��û");
	}
	
	//add.jsp �� ��������
	@PostMapping("/add")
	public void addPost(int num1,int num2) {
		log.info("add �� ��������");
		log.info("Num1 : "+num1);
		log.info("Num2 : "+num2);
	}
//	@PostMapping("/four")
//	public void fourPost(int num1,String op,int num2) {
//		log.info("four �� ��������");
//		log.info("Num1 : "+num1);
//		log.info("op : "+op);
//		log.info("Num2 : "+num2);
//	}
	@PostMapping("/four")
	public void fourPost(CalcVO calc,@ModelAttribute("page") int page) {
		log.info("four �� ��������");
		log.info("Num1 : "+calc.getNum1());
		log.info("op : "+calc.getOp());
		log.info("Num2 : "+calc.getNum2());
		log.info("page : "+page);
		
		//page ���� ������Ű�� �ʹٸ�?
		//model.addAttribute("page",page);
	}
}
