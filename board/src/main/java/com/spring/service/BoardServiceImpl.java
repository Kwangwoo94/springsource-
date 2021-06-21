package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.mapper.BoardAttachMapper;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper attachMapper;
	
	
	@Transactional
	@Override
	public boolean insert(BoardVO vo) {
		//새글 등록
		boolean result = mapper.insert(vo)>0?true:false;
		//첨부파일 등록
		if(vo.getAttachList()==null||vo.getAttachList().size()<=0) {
			return result;
		}
		
		vo.getAttachList().forEach(attach ->{
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		});
		
		return result;
	}
	
	@Transactional
	@Override
	public boolean delete(int bno) {
		//첨부파일 삭제
		attachMapper.delete(bno);
		//게시글 삭제
		return mapper.delete(bno)>0?true:false;
	}

	@Override
	public boolean update(BoardVO vo) {
		return mapper.update(vo)>0?true:false;
	}

	@Override
	public List<BoardVO> list(Criteria cri) {
		return mapper.list(cri);
	}

	@Override
	public BoardVO read(int bno) {
		return mapper.read(bno);
	}

	@Override
	public int total(Criteria cri) {
		return mapper.totalCnt(cri);
	}

	@Override
	public List<AttachFileDTO> getAttachList(int bno) {
		return attachMapper.findByBno(bno);
	}

}
