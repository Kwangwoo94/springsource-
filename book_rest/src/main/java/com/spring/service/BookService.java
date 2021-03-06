package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	public int insert(BookVO vo);
	public int delete(int code);
	public int update(int price,int code);
	public List<BookVO> list();
	public List<BookVO> search(String criteria,String keyword);
	public BookVO getRow(int code);
}
