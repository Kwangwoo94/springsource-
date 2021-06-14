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
		log.info("rest 수정"+vo);
		
		if(vo.newPasswordEqualsConfirmPassword()) {
			if(service.update(vo)) {
				session.invalidate();
				return new ResponseEntity<String>("success",HttpStatus.OK);
			}else { // 현재 비밀번호 오류
				//rttr.addFlashAttribute("error", "현재 비밀번호를 확인해 주세요");
				return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
			}
		}else { // 변경비밀번호와 확정변경비밀번호가 다른경우
		//	rttr.addFlashAttribute("error", "변경 비밀번호가 다릅니다.");
			return new ResponseEntity<String>("not-equal",HttpStatus.BAD_REQUEST);
		}
		
	}
}
