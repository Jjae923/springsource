package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service("book")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper mapper;
	
	@Override
	public List<BookVO> getList() {
		return mapper.getList();
	}
	@Override
	public boolean insertBook(BookVO vo) {
		return mapper.insert(vo);
	}
	@Override
	public boolean updateBook(BookVO vo) {
		return mapper.update(vo);
	}
	@Override
	public boolean deleteBook(String code) {
		return mapper.delete(code);
	}
	@Override
	public BookVO getBook(String code) {
		return mapper.getRow(code);
	}
}
