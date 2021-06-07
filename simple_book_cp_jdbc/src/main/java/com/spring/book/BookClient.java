package com.spring.book;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;
import com.spring.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) {
//		BookService service = new BookServiceImpl();
//		BookVO vo = service.getRow(1000);
//		System.out.println(vo);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService service = (BookService)ctx.getBean("service");
		
		//입력
		BookVO vo2 = new BookVO();
		vo2.setCode(1007);
		vo2.setTitle("이것은 스프링3");
		vo2.setWriter("권은비");
		vo2.setPrice(38000);
		System.out.println(service.insert(vo2)?"성공":"실패");
		
		System.out.println("----------------------------");
		//수정
		BookVO vo = new BookVO();
		vo.setCode(1000);
		vo.setTitle("이것이 자바다2");
		vo.setWriter("신용권하");
		vo.setPrice(36000);
		System.out.println(service.update(vo)?"성공":"실패");
		
		System.out.println("----------------------------");
		
		//삭제
		System.out.println(service.delete(1005)?"성공":"실패");
		System.out.println("----------------------------");
		
		//도서정보 하나 가져오기
		System.out.println(service.getRow(1000));
		System.out.println("----------------------------");
		//전체 리스트
		List<BookVO> list = service.getList();
		
		for(BookVO vo1:list) {
			System.out.println(vo1);
		}
	}

}
