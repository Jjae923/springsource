package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper mapper;
	
	@Override
	public List<BookVO> getList() {
		return mapper.select();
	}

	@Override
	public boolean insert(BookVO vo) {
		return false;
	}

	@Override
	public boolean modify(String code, int price) {
		return false;
	}

	@Override
	public boolean delete(String code) {
		return false;
	}

	@Override
	public List<BookVO> getSearchList(String criteria, String keyword) {
		return null;
	}

}
