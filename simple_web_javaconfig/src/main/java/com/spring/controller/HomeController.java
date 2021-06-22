package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public void login() {
		log.info("login ��û.....");
	}
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout ��û");
	}
	@RequestMapping("/doA")
	public String doA() {
		log.info("doA ��û");
		return "board/read";
	}
	
	@RequestMapping("/doC")
	public ModelAndView doC() {
		log.info("/doC ��û");
		//Model => request ����
		//View => ����ڰ� ���� ������
		ModelAndView mav = new ModelAndView();
		mav.addObject("test", "ModelAndView");
		mav.setViewName("result");
		
		return mav;
	}
	@GetMapping("/doB")
	public String doB(RedirectAttributes rttr) {
		log.info("doB ��û");
		
		//���� ������Ű�� �ʹٸ�?
		rttr.addAttribute("age1", 20); //http://localhost:8082/?age=10 / path +="?bno=3&page=1"
		rttr.addFlashAttribute("age",10); //http://localhost:8082/ ���ǰ�ü(�ӽ�)
		
		return "redirect:/";
	}
}
