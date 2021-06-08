package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
//		SamsungTV samsung = new SamsungTV();
//		samsung.turnOn();
//		samsung.turnOff();
		
		//������ ���̰� , ���յ� ���߱�
		
		// �θ� = new �ڽ�(extends, implements) => ������
//		TV tv = new SamsungTV(new SonySpeaker());
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		TV tv = (TV)ctx.getBean("samTv2");
		
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}