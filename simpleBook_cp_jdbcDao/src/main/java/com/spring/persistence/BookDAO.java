package com.spring.persistence;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.domain.BookVO;

@Repository       // 객체 생성
public class BookDAO extends JdbcDaoSupport {
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	private final String BOOK_INSERT = "insert into bookTBL(code, title, writer, price) values(?,?,?,?)";
	private final String BOOK_LIST = "select * from bookTBL";
	
	public int insertBook(BookVO vo) {

		return getJdbcTemplate().update(BOOK_INSERT, vo.getCode(), vo.getTitle(), vo.getWriter(), vo.getPrice());
	}
	
	// 도서목록 가져오기
	public List<BookVO> getList() {
		
		BookVO vo = new BookVO();
		
		return getJdbcTemplate().query(BOOK_LIST, new BookRowMapper());
	}
}
