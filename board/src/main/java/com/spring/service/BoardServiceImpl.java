package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public boolean insert(BoardVO vo) {
		return mapper.insert(vo)>0?true:false;
	}

	@Override
	public boolean delete(int bno) {
		return false;
	}

	@Override
	public boolean update(BoardVO vo) {
		return mapper.update(vo)>0?true:false;
	}

	@Override
	public List<BoardVO> list() {
		return mapper.list();
	}

	@Override
	public BoardVO read(int bno) {
		return mapper.read(bno);
	}

}
