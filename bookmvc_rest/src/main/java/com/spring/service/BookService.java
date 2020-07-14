package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	
	public BookVO getRow(String code);
	
	// 도서 목록 보기 => select
	public List<BookVO> getList();  
	
	// 도서 정보 입력 => insert(code, title, writer, price)
	public boolean insert(BookVO vo);
	
	// 도서 정보 삭제
	public boolean delete(String code);
	
	// 도서 정보 수정 
	public boolean modify(String code, int price);
	
	// 도서 정보 검색
	public List<BookVO> getSearchList(String criteria, String keyword);
}
