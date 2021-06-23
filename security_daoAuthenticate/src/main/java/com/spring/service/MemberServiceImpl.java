package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.MemberMapper;
import com.spring.security.SpUser;
import com.spring.security.SpUserAuthority;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public boolean register(SpUser user) {
		
		//ȸ������ ��� �� ��й�ȣ ��ȣȭ
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//ȸ������ ���
		boolean result = mapper.register(user)==1;
		
		//ȸ������ ���
		SpUserAuthority auth = new SpUserAuthority();
		auth.setUserid(user.getUserid());
		auth.setAuthority("ROLE_USER");
		
		mapper.registerAuth(auth);
		
		return result;
	}

//	@Override
//	public boolean registerAuth(SpUserAuthority auth) {
//		return mapper.registerAuth(auth)==1;
//	}

}
