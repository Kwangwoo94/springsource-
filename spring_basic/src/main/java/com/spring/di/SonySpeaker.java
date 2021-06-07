package com.spring.di;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker ��ü ����");
	}
	@Override
	public void volumeUp() {
		System.out.println("===> SonySpeaker volume Up");
	}
	@Override
	public void volumeDown() {
		System.out.println("===> SonySpeaker volume Down");
	}
}
