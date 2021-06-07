package com.spring.scan;

import org.springframework.stereotype.Component;

@Component("speaker2")
public class SamsungSpeaker implements Speaker {
	
	public SamsungSpeaker() {
		System.out.println("===SamsungSpeaker ��ü ����");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("===SamsungSpeaker ���� Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("===SamsungSpeaker ���� Down");
	}

}
