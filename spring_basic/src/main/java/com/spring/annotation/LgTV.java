package com.spring.annotation;

public class LgTV implements TV {

	@Override
	public void turnOn() {
		System.out.println("LG TV - �Ŀ� On");
	}

	@Override
	public void turnOff() {
		System.out.println("LG TV - �Ŀ� Off");
	}

	@Override
	public void soundUp() {
		System.out.println("LG TV - ���� Up");
	}

	@Override
	public void soundDown() {
		System.out.println("LG TV - ���� Down");
	}

}
