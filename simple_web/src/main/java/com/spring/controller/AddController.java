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
		log.info("add.jsp 요청");
	}
	@GetMapping("/four")
	public void fourForm() {
		log.info("fout.jsp 요청");
	}
	
	//add.jsp 값 가져오기
	@PostMapping("/add")
	public void addPost(int num1,int num2) {
		log.info("add 값 가져오기");
		log.info("Num1 : "+num1);
		log.info("Num2 : "+num2);
	}
//	@PostMapping("/four")
//	public void fourPost(int num1,String op,int num2) {
//		log.info("four 값 가져오기");
//		log.info("Num1 : "+num1);
//		log.info("op : "+op);
//		log.info("Num2 : "+num2);
//	}
	@PostMapping("/four")
	public void fourPost(CalcVO calc,@ModelAttribute("page") int page) {
		log.info("four 값 가져오기");
		log.info("Num1 : "+calc.getNum1());
		log.info("op : "+calc.getOp());
		log.info("Num2 : "+calc.getNum2());
		log.info("page : "+page);
		
		//page 값을 유지시키고 싶다면?
		//model.addAttribute("page",page);
	}
}
