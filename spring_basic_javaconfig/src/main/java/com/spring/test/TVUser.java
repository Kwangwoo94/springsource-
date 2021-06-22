package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.config.Config;

public class TVUser {
	public static void main(String[] args) {
//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.soundUp();
//		tv.turnOff();
//		
//		SamsungTV samsung = new SamsungTV();
//		samsung.powerOn();
//		samsung.volumeUp();
//		samsung.volumeUp();
//		samsung.powerOff();
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		LgTV lg = (LgTV)ctx.getBean("lg");
		lg.turnOn();
		lg.soundUp();
		lg.soundUp();
		lg.turnOff();
		
		SamsungTV samsung = (SamsungTV) ctx.getBean("samsung");
		samsung.powerOn();
		samsung.volumeUp();
		samsung.volumeUp();
		samsung.powerOff();
		
		SamsungTV samsung2 = (SamsungTV) ctx.getBean("samsung");
		
		if(samsung == samsung2) {
			System.out.println(samsung == samsung2); //true => SingleTon
		}
	}

}
