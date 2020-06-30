package com.spring.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.domain.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> { // Generic : 타입 형변환을 줄이기 위해

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException { // 하나의 행에 대한 처리만 해주면 됨
		BoardVO vo = new BoardVO();
		vo.setBno(rs.getInt("bno"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setRegdate(rs.getDate("regdate"));
		vo.setUpdatedate(rs.getDate("updatedate"));		
		return vo;
	} 
}
