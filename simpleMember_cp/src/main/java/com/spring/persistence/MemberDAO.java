package com.spring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.MemberVO;

@Repository
public class MemberDAO {
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (Exception e) {
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
//	

	@Autowired
	private DataSource ds;
	
	public List<MemberVO> getList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = "select * from member";
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					MemberVO vo = new MemberVO();
					vo.setUserid(rs.getString("userid"));
					vo.setPassword(rs.getString("password"));
					vo.setName(rs.getString("name"));
					vo.setGender(rs.getString("gender"));
					vo.setEmail(rs.getString("email"));
					list.add(vo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
