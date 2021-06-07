package com.spring.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

public class BoardClient {
	public static void main(String[] args) {
		//Service => DAO 
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BoardService service = (BoardService)ctx.getBean("service");
		
//		BoardVO vo = new BoardVO();
//		vo.setTitle("������ �����̳�");
//		vo.setContent("������ �����̳��� ���");
//		vo.setWriter("ȫ�浿");
//		
//		boolean insertFlag = service.insert(vo);
//		System.out.println(insertFlag?"����":"����");
		
		//update
		BoardVO vo2 = new BoardVO();
		vo2.setTitle("������ �����̳�2");
		vo2.setContent("������ �����̳��� ���2");
		vo2.setBno(2);
		System.out.println(service.update(vo2)?"����":"����");
		
		System.out.println("-----------------------------");
		
		//�ϳ� ��ȸ
		System.out.println(service.getRow(2));
		
		System.out.println("-----------------------------");
		
		//����
		System.out.println(service.delete(2)?"����":"����");
		
		System.out.println("-----------------------------");
		//��ü ��ȸ
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
	}

}
