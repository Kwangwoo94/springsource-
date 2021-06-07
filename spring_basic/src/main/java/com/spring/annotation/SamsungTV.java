package com.spring.annotation;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SamsungTV implements TV {
	
	//������ ��ü ����
	//@Autowired
	@Inject
	@Qualifier("speaker2") //������ ������(�̸����� ���Դ���� ������ �� ���� ������ ���ִ� ���� �ƴ�)
	private Speaker speaker; //SonySpeaker or SamsungSpeaker
	
	public SamsungTV() {
		System.out.println("SamsungTV - ��ü����(1)");
	}

	@Override
	public void turnOn() {
		System.out.println("SamsungTV - �Ŀ� On");
	}

	@Override
	public void turnOff() {
		System.out.println("SamsungTV - �Ŀ� Off");
	}

	@Override
	public void soundUp() {
		speaker.volumeUp();
	}

	@Override
	public void soundDown() {
		speaker.volumeDown();
	}

}
