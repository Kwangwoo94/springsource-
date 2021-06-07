package com.spring.scan;

import org.springframework.stereotype.Component;

@Component("speaker1")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker °´Ã¼ »ý¼º");
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
