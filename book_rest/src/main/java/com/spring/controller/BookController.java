package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class BookController {
	
	@Autowired
	private BookService service;
	
	//��ü ���� ��� ��������
	@GetMapping("/list")
	public void getList(Model model) {
		log.info("���� ��� ��������");
		
		List<BookVO> list=service.list();
		
		//list��ü�� ��� �� list.jsp���� ����?
		//request.setAttribute()+forward ����
		model.addAttribute("list", list);
	}
	//���� ���� �Է��ϱ� - ������ list �����ֱ�
	//					���н� index �����ֱ�
	@PostMapping("/insert")
	public String insertPost(BookVO vo,RedirectAttributes rttr) {
		log.info("���� ���� �Է��ϱ�"+vo);
		
		if(service.insert(vo)>0) {
			return "redirect:/list";
		}else {
			rttr.addFlashAttribute("tab", "insert");
			return "redirect:/";
		}
	}
	@PostMapping("/delete")
	public String deletePost(int code,RedirectAttributes rttr) {
		log.info("���� ���� ����"+code);
		
		if(service.delete(code)>0) {
			return "redirect:/list";
		}else {
			rttr.addFlashAttribute("tab", "delete");
			return "redirect:/";
		}
		
	}
	@PostMapping("/update")
	public String updatePost(int code,int price,RedirectAttributes rttr) {
		log.info("�������� ����"+code+", "+price);
		
		if(service.update(price, code)>0) {
			return "redirect:/list";
		}else {
			rttr.addFlashAttribute("tab", "modify");
			return "redirect:/";
		}
	}
	
	//search+post => search.jsp �����ֱ�
	@PostMapping("/search")
	public void getSearchList(String criteria,String keyword,Model model) {
		log.info("���� ���� �˻�");
		
		List<BookVO> list = service.search(criteria, keyword);
		
		model.addAttribute("list", list);
	}
}
