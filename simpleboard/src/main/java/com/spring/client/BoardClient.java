package com.spring.client;

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
		vo.setTitle("스프링 게시판");
		vo.setContent("스프링 게시판 연습");
		vo.setWriter("홍길동");
		int result = service.insertBoard(vo);
		if(result>0) {
			System.out.println("입력성공");
		}else {
			System.out.println("입력실패");
		}
	}
}
