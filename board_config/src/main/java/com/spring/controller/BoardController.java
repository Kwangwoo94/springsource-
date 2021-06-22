package com.spring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AttachFileDTO;
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
	public void list(Model model,Criteria cri) {
		log.info("��ü ����Ʈ ��û ");
		
		//����ڰ� ������ ������ �Խù�
		List<BoardVO> list=service.list(cri);
		//��ü �Խù� �� 
		int total = service.total(cri);
				
		model.addAttribute("list", list);
		model.addAttribute("pageVO", new PageVO(cri, total));
	}	
	
	@GetMapping("/register")
	public void register() {
		log.info("���� ��� �� ��û");
	}
	
	//�Խñ� ���
	@PostMapping("/register")
	public String registerPost(BoardVO vo,RedirectAttributes rttr) {
		log.info("���� ��� ��û "+vo);
		
		//÷�� ���� Ȯ��
		if(vo.getAttachList()!=null) {
			vo.getAttachList().forEach(attach -> log.info(""+attach));
		}	
		
		
		if(service.insert(vo)) {
			//log.info("�Էµ� �� ��ȣ "+vo.getBno());
			rttr.addFlashAttribute("result", vo.getBno());
			return "redirect:list";    //   redirect:/board/list
		}else {
			return "redirect:register"; //  redirect:/board/register
		}
	}
	
	
	//   /board/read?bno=22  
    //   /board/modify?bno=7
	
	
	@GetMapping({"/read","/modify"})
	public void read(int bno,@ModelAttribute("cri") Criteria cri,Model model) {
		log.info("�� �ϳ� �������� "+bno+" cri : "+cri);  
		
		BoardVO vo=service.read(bno);
		model.addAttribute("vo", vo);	//	/board/read  or  /board/modify 
	}
	
	// modify+post ������ �� list
	@PostMapping("/modify")
	public String modify(BoardVO vo,Criteria cri,RedirectAttributes rttr) {
		log.info("���� ��û "+vo+" ������ ������ "+cri);
		
		//÷�� ���� Ȯ��
		if(vo.getAttachList()!=null) {
			vo.getAttachList().forEach(attach -> log.info(""+attach));
		}	
		
		service.update(vo);		
		
		
		rttr.addFlashAttribute("result","����");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		
		return "redirect:list";
	}
	
	//�Խñ� ���� + post
	@PostMapping("/remove")
	public String remove(int bno,Criteria cri,RedirectAttributes rttr) {
		log.info("�Խñ� ���� "+bno);
		
		
		//����(����)�� ����� ÷������ ����
		//�� bno�� �ش��ϴ� ÷������ ��� �˾Ƴ���
		List<AttachFileDTO> attachList=service.getAttachList(bno);
		
		//�Խñ� ���� + ÷������ ����
		if(service.delete(bno)) {
			//�� ���� ���� ����
			deleteFiles(attachList);
			rttr.addFlashAttribute("result","����");
		}	
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}
	
	
	//÷�ι� ��������
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileDTO>> getAttachList(int bno){
		log.info("÷�ι� �������� "+bno);
		
		return new ResponseEntity<List<AttachFileDTO>>(service.getAttachList(bno),HttpStatus.OK);
	}
	
	
	private void deleteFiles(List<AttachFileDTO> attachList) {
		log.info("÷������ ���� "+attachList);
		
		if(attachList==null || attachList.size()<=0) {
			return;
		}
		
		for(AttachFileDTO dto:attachList) {
			Path path = Paths.get("e:\\upload\\", dto.getUploadPath()+"\\"+dto.getUuid()+"_"+dto.getFileName());
			
			try {
				Files.deleteIfExists(path);
				
				if(Files.probeContentType(path).startsWith("image")) {
					Path thumbnail = Paths.get("e:\\upload\\", 
							dto.getUploadPath()+"\\s_"+dto.getUuid()+"_"+dto.getFileName());
					Files.delete(thumbnail);
				}
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
	}
}