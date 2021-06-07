package com.spring.mapper;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookMapper {
	public int insert(BookVO vo);
	public int update(BookVO Vo);
	public int delete(int code);
	public BookVO read(int code);
	public List<BookVO> list();
}
