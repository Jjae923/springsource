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
	public List<BoardVO> getList() {
		return mapper.list();
	}

	@Override
	public boolean insertBoard(BoardVO vo) {
		return mapper.insert(vo)==1? true:false;
	}

	@Override
	public BoardVO readBoard(int bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modifyBoard(BoardVO vo) {
		return mapper.modify(vo)==1? true:false;
	}

	@Override
	public boolean deleteBoard(int bno) {
		return mapper.delete(bno)==1? true:false;
	}
}
