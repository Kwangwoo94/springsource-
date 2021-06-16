package com.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UploadAjaxController {
	
	
	//uploadFormAjax
	@GetMapping("/uploadFormAjax")
	public void uploadFormAjaxGet() {
		log.info("uploadFormAjax ��û");
	}
	
	@PostMapping("/uploadAjax")
	public void uploadFormPost(MultipartFile[] uploadFile) {
		log.info("���� ���ε� ��û");
		
		for(MultipartFile f:uploadFile) {
			log.info("upload File Name : "+f.getOriginalFilename());
			log.info("upload File Size : "+f.getSize());
		
			//���� ������ ���۵� ���� �����ϱ�
			try {
				f.transferTo(new File("c:\\upload",f.getOriginalFilename()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
