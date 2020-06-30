package com.spring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;

//@Component   // 스프링 컨테이너가 객체 생성하여 보관 중
@Repository
public class BoardDAO {
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	public static Connection getConnection() {
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String user = "javadb";
//		String password = "12345";
//		try {
//			return DriverManager.getConnection(url, user, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Autowired
	private DataSource ds;
	
	// 게시글 등록
	public int insertArticle(BoardVO vo) {
		int result = 0;
		String sql = "insert into spring_board(bno,title, content, writer) values(seq_board.nextVal,?,?,?)";
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				con.setAutoCommit(false);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getWriter());
				
				result = pstmt.executeUpdate();
				if(result > 0) { 	
					con.commit();
				}
				
		} catch (Exception e) {
			// con.rollback();      // rollback 조절 가능
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시글 가져오기
	public List<BoardVO> getList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "select * from spring_board";
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setRegdate(rs.getDate(5));
				vo.setUpdatedate(rs.getDate(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
