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
		
		//�Է�
		BookVO vo2 = new BookVO();
		vo2.setCode(1008);
		vo2.setTitle("�̰��� ������2");
		vo2.setWriter("������");
		vo2.setPrice(38000);
		System.out.println(service.insert(vo2)?"����":"����");
		
		System.out.println("----------------------------");
		//����
		BookVO vo = new BookVO();
		vo.setCode(1000);
		vo.setTitle("�̰��� �ڹٴ�2");
		vo.setWriter("�ſ�Ǵ�");
		vo.setPrice(35000);
		System.out.println(service.update(vo)?"����":"����");
		
		System.out.println("----------------------------");
		
		//����
		System.out.println(service.delete(1004)?"����":"����");
		System.out.println("----------------------------");
		
		//�������� �ϳ� ��������
		System.out.println(service.read(1000));
		System.out.println("----------------------------");
		//��ü ����Ʈ
		List<BookVO> list = service.list();
		
		for(BookVO vo1:list) {
			System.out.println(vo1);
		}
	}

}
