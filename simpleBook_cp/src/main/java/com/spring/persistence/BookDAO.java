package com.spring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.BookVO;

@Repository       // 객체 생성
public class BookDAO {
//	// 드라이버 로드
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	// getConnection()
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
	
	// 도서목록 가져오기
	public List<BookVO> getList() {
		List<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "select * from bookTBL"; 
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					BookVO vo = new BookVO();
					vo.setCode(rs.getString("code"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setPrice(rs.getInt("price"));
					list.add(vo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
