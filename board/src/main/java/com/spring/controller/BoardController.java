package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void List(Model model) {
		log.info("�Խ��� ��� �ҷ�����");
		
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
	}
	@GetMapping("/register")
	public void register() {
		log.info("���� �ۼ� �� ��û");
	}
	
	//�Խñ� ���
	@PostMapping("/register")
	public String insert(BoardVO vo) {
		log.info("���� �ۼ�"+vo);
		
		if(service.insert(vo)) {
			return "redirect:list"; //redirect:/board/list
		}
		else {
			return "redirect:register"; //redirect:/board/register
		}
	}
	//�Խñ� Ȯ�� 
	// /board/read?bno=22
	// /board/modify?bno=7
	@GetMapping({"/read","/modify"})
	public void read(int bno,Model model) {
		log.info("�Խù� Ȯ��"+bno);
		
		BoardVO vo= service.read(bno);
		
		model.addAttribute("vo", vo);
	}
	
	//�Խù� ����
	@PostMapping("/modify")
	public String modify(BoardVO vo) {
		log.info("�Խù� ����"+vo);
		
		service.update(vo);
		
		return "redirect:list";
	}
	
	
}
