package com.spring.service;

import com.spring.domain.MemberVO;

public interface MemberService {
	public MemberVO Login(String userid,String password);
	public boolean remove(String userid,String password);
	public boolean update(String userid,String password,String changePassword);
	public boolean insert(String userid, String password,String name, String gender, String email);
}
