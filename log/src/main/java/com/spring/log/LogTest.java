package com.spring.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogTest {
	
	//private static final Logger logger = LogManager.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		//logger.error("error ����");
//		logger.warn("warn ����");
//		logger.info("info ����");
//		logger.debug("debug ����");
//		logger.trace("trace ����");
		log.info("info ����");
	}

}
