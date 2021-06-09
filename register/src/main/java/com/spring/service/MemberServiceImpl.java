package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.LoginVO;
import com.spring.domain.MemberVO;
import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public boolean insert(MemberVO vo) {
		return mapper.insert(vo)>0?true:false;
	}

	@Override
	public MemberVO dupId(String userid) {
		return mapper.dupId(userid);
	}

	@Override
	public LoginVO login(String userid, String password) {
		return mapper.login(userid, password);
	}

	@Override
	public boolean leave(String userid, String password) {
		return mapper.leave(userid, password)>0?true:false;
	}

	@Override
	public boolean update(String userid, String password, String newpassword) {
		return mapper.update(userid, password, newpassword)>0?true:false;
	}

}
