package com.spring.mapper;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookMapper {
	public List<BookVO> getList();
	public boolean insert(BookVO vo);
	public boolean update(BookVO vo);
	public boolean delete(String code);
	public BookVO getRow(String code);
}
