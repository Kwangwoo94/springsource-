package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.mapper.MemberMapper;

@Service("service")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public MemberVO Login(String userid, String password) {
		return mapper.Login(userid, password);
	}

	@Override
	public boolean remove(String userid, String password) {
		return mapper.remove(userid, password)>0?true:false;
	}

	@Override
	public boolean update(String userid, String password, String changePassword) {
		return mapper.update(userid, password, changePassword)>0?true:false;
	}

	@Override
	public boolean insert(String userid, String password, String name, String gender, String email) {
		return mapper.insert(userid,password,name,gender,email)>0?true:false;
	}

}
