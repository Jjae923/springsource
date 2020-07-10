package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardService {
	// 게시판 목록 보기
	public List<BoardVO> getList(Criteria cri);	
	int totalRows(Criteria cri);			// interface는 default가 public
	public boolean insertBoard(BoardVO vo);
	public BoardVO readBoard(int bno);
	public boolean modifyBoard(BoardVO vo);
	public boolean deleteBoard(int bno);
}
