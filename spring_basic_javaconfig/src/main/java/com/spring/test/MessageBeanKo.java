package com.spring.test;

public class MessageBeanKo implements MessageBean {
	@Override
	public void sayHello(String name) {
		System.out.println("�ȳ�!"+name);
	}
}
