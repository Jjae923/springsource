package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

public class BoardClient {
	public static void main(String[] args) {
		// 컨테이너 구동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		// Look Up
		BoardService service = (BoardService)ctx.getBean("board"); // client랑 service 연결
		// BoardService servict = new BoardServiceImpl(); 하기 위해 
		
		// 게시글 등록
		BoardVO vo = new BoardVO();
		vo.setTitle("mybatis");
		vo.setContent("게시판을 늘려늘려");
		vo.setWriter("정째희");
		int result = service.insertBoard(vo);
		if(result>0) {
			System.out.println("입력성공");
		}else {
			System.out.println("입력실패");
		}

		// 게시글 가져오기
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
	}
}
