package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	public List<BookVO> getList();
	public boolean insertBook(BookVO vo);
	public boolean updateBook(BookVO vo);
	public boolean deleteBook(String code);
	public BookVO getBook(String code);
}
