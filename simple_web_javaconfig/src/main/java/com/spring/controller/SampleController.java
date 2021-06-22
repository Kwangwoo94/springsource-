package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@RequestMapping("/basic")
	public void basic() {
		log.info("basic ��û .....");
	}
}
