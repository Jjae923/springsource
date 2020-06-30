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
		vo.setTitle("스프링 게시판");
		vo.setContent("JDBCTemplate 사용~~");
		vo.setWriter("떵웅");
		int result = service.insertBoard(vo);
		if(result>0) {
			System.out.println("입력성공");
		}else {
			System.out.println("입력실패");
		}
		
		// 게시글 수정
//		BoardVO vo = new BoardVO();
//		vo.setBno(3);
//		vo.setTitle("스프링 게시판 수정");
//		vo.setContent("게시판 내용 수정");
//		int result = service.updateBoard(vo);
//		if(result>0) {
//			System.out.println("수정성공");
//		}else {
//			System.out.println("수정실패");
//		}
		
		// 게시글 삭제
//		BoardVO vo = new BoardVO();
//		vo.setBno(4);
//		int result = service.deleteBoard(vo);
//		if(result>0) {
//			System.out.println("삭제성공");
//		}else {
//			System.out.println("삭제실패");
//		}
		
		// 게시글 전체 리스트 가져오기
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
		
		// 게시글 하나 가져오기
//		BoardVO vo = service.getBoard(23);
//		System.out.println(vo);
	}
}
