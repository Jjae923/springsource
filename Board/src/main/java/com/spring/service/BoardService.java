package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	// 게시판 목록 보기
	public List<BoardVO> getList();
	public boolean insertBoard(BoardVO vo);
	public BoardVO readBoard(int bno);
	public boolean modifyBoard(BoardVO vo);
	public boolean deleteBoard(int bno);
}
