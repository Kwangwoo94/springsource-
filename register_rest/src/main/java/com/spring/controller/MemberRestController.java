package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.ChangeVO;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class MemberRestController {
	
	@Autowired
	private MemberService service;
	
	@PutMapping("/changePwd2")
	public ResponseEntity<String> changePwd(ChangeVO vo,HttpSession session){
		log.info("rest ����"+vo);
		
		if(vo.newPasswordEqualsConfirmPassword()) {
			if(service.update(vo)) {
				session.invalidate();
				return new ResponseEntity<String>("success",HttpStatus.OK);
			}else { // ���� ��й�ȣ ����
				//rttr.addFlashAttribute("error", "���� ��й�ȣ�� Ȯ���� �ּ���");
				return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
			}
		}else { // �����й�ȣ�� Ȯ�������й�ȣ�� �ٸ����
		//	rttr.addFlashAttribute("error", "���� ��й�ȣ�� �ٸ��ϴ�.");
			return new ResponseEntity<String>("not-equal",HttpStatus.BAD_REQUEST);
		}
		
	}
}
