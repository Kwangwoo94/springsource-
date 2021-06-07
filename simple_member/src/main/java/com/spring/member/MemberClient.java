package com.spring.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

public class MemberClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		MemberService service = (MemberService)ctx.getBean("service");
		
		//ȸ������
		//System.out.println(service.insert("joy","1234","ȫ�浿","����","hong123@naver.com")?"ȸ������ ����":"ȸ������ ����");
		//System.out.println("--------------------");
		//�α���
		System.out.println(service.Login("joy", "1234"));
		System.out.println("--------------------");
		
		//��й�ȣ ����
		System.out.println(service.update("joy","1234","4321")?"��й�ȣ ���� ����":"��й�ȣ ���� ����");
		System.out.println("--------------------");
		
		//ȸ��Ż��
		System.out.println(service.remove("joy","4321")?"Ż�� ����":"Ż�� ����");
		
	}

}
