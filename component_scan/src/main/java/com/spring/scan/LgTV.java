package com.spring.scan;

import org.springframework.stereotype.Component;


@Component("lg") //lg라는 id로 LgTV객체 생성
public class LgTV implements TV {

	@Override
	public void turnOn() {
		System.out.println("LG TV - 파워 On");
	}

	@Override
	public void turnOff() {
		System.out.println("LG TV - 파워 Off");
	}

	@Override
	public void soundUp() {
		System.out.println("LG TV - 사운드 Up");
	}

	@Override
	public void soundDown() {
		System.out.println("LG TV - 사운드 Down");
	}

}
