package com.spring.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.MemberVO;

public interface MemberMapper {
	public MemberVO Login(@Param("userid")String userid,@Param("password")String password);
	public int remove(@Param("userid")String userid,@Param("password")String password);
	public int update(@Param("userid")String userid,@Param("password")String password,@Param("changePassword")String changePassword);
	public int insert(@Param("userid")String userid,@Param("password")String password,@Param("name")String name,@Param("gender")String gender,@Param("email")String email);
}
