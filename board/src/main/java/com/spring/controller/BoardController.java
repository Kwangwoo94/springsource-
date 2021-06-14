package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageVO;
import com.spring.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void List(Model model,Criteria cri) {
		log.info("�Խ��� ��� �ҷ�����");
		//����ڰ� ������ ������ �Խù�
		List<BoardVO> list = service.list(cri);
		
		//��ü�Խù���
		int total = service.total(cri);
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", new PageVO(cri,total));
	}
	@GetMapping("/register")
	public void register() {
		log.info("���� �ۼ� �� ��û");
	}
	
	//�Խñ� ���
	@PostMapping("/register")
	public String insert(BoardVO vo,RedirectAttributes rttr) {
		log.info("���� �ۼ�"+vo);
		
		if(service.insert(vo)) {
//			log.info("�Էµ� �� ��ȣ "+vo.getBno());
			rttr.addFlashAttribute("result",vo.getBno());
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
	public void read(int bno,@ModelAttribute("cri")Criteria cri,Model model) {
		log.info("�Խù� Ȯ��"+bno+" cri : "+cri);
		
		BoardVO vo= service.read(bno);
		
		model.addAttribute("vo", vo);
	}
	
	//�Խù� ����
	@PostMapping("/modify")
	public String modify(BoardVO vo,Criteria cri,RedirectAttributes rttr) {
		log.info("�Խù� ����"+vo+"������ ������"+cri);
		
		service.update(vo);
		rttr.addFlashAttribute("result", "����");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:list";
	}
	//�Խñ� ���� + post
	@PostMapping("/remove")
	public String remove(int bno,Criteria cri,RedirectAttributes rttr) {
		log.info("�Խù� ���� ��û"+bno);
		
		service.delete(bno);
		rttr.addFlashAttribute("result", "����");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}
}
