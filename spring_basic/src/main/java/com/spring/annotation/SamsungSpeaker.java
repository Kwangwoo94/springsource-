package com.spring.annotation;

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
