package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.spring.domain.PersonVO;

public interface PersonMapper {
	
	// preparedstatement - values(?,?) xml 없이 쓰는 방식
	//@Insert("insert into person(id,name) values(#{id},#{name})")
	//public int insertPerson(@Param("id")String id,@Param("name")String name);
	
	
	//xml을 사용하는 방식 
	//1)xml의 id와 인터페이스의 메소드명 일치 시킬것! 
	//2)2개 이상 넘길시 @Param사용
	public int insertPerson(@Param("id")String id,@Param("name")String name);
	public int deletePerson(String id);
	public int updatePerson(@Param("id")String id,@Param("name")String name);
	public List<PersonVO> selectAll();
	public String selectPerson(String id);
}
