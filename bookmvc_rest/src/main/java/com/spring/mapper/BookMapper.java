package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BookVO;

public interface BookMapper {
	public BookVO get(String code);
	public List<BookVO> select();
	public int insert(BookVO vo); 
	public int delete(String code);
	public int modify(@Param("code") String code, @Param("price") int price); // 2개의 값을 넘길 땐 반드시 param
	public List<BookVO> search(@Param("criteria") String criteria, @Param("keyword") String keyword);
}
