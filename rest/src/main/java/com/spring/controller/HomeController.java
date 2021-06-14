package com.spring.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.SampleVO;

/**
 * Handles requests for the application home page.
 */
@Controller
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
	
	@ResponseBody
	@GetMapping(value="/send2",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setMno("1234");
		sample.setFirstName("Hong");
		sample.setLastName("Dong");
		
		return sample;
	}
	@GetMapping(value="/send-list2",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SampleVO> sendList() {
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		for(int i=0;i<10;i++) {
			SampleVO sample = new SampleVO();
			sample.setMno("1234");
			sample.setFirstName("Hong");
			sample.setLastName("Dong");
			list.add(sample);
		}
		return list;
	}
}
