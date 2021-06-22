package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.config.Config;

public class HelloApp {
	public static void main(String[] args) {
//		MessageBean msg = new MessageBeanKo();
//		msg.sayHello("ȫ�浿");
		
		System.out.println("������ �����̳� ���� ��");
		//1.������ �����̳� ����
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		//2.������ �����̳ʷκ��� ��ü lookup(�����̳ʰ� �����ϴ� �� �߿��� �ʿ��� �� ã��)
		MessageBean msg = (MessageBean)ctx.getBean("messageBean");
		//3.����
		msg.sayHello("hong");
	}

}