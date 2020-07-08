package com.spring.mapper;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> list();
	public int insert(BoardVO vo);
	public BoardVO read(int bno);
	public int modify(BoardVO vo);
	public int delete(int bno);
}
