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
		
		BoardVO vo = new BoardVO();
		vo.setTitle("������ �����̳�4");
		vo.setContent("������ �����̳��� ���4");
		vo.setWriter("ȫ�浿4");
		
		boolean insertFlag = service.insert(vo);
		System.out.println(insertFlag?"����":"����");
		
		//update
//		BoardVO vo2 = new BoardVO();
//		vo2.setTitle("������ �����̳�3");
//		vo2.setContent("������ �����̳��� ���3");
//		vo2.setBno(6);
//		System.out.println(service.update(vo2)?"����":"����");
//		
//		System.out.println("-----------------------------");
//		
//		//�ϳ� ��ȸ
//		System.out.println(service.getRow(4));
//		
//		System.out.println("-----------------------------");
//		
//		//����
//		System.out.println(service.delete(4)?"����":"����");
//		
//		System.out.println("-----------------------------");
		//��ü ��ȸ
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
	}

}
