package com.spring.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

public class MemberClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		MemberService service = (MemberService)ctx.getBean("service");
		
		//회원가입
		//System.out.println(service.insert("joy","1234","홍길동","남성","hong123@naver.com")?"회원가입 성공":"회원가입 실패");
		//System.out.println("--------------------");
		//로그인
		System.out.println(service.Login("joy", "1234"));
		System.out.println("--------------------");
		
		//비밀번호 변경
		System.out.println(service.update("joy","1234","4321")?"비밀번호 변경 성공":"비밀번호 변경 실패");
		System.out.println("--------------------");
		
		//회원탈퇴
		System.out.println(service.remove("joy","4321")?"탈퇴 성공":"탈퇴 실패");
		
	}

}
