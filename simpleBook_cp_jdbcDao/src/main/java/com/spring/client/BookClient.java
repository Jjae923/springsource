package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

public class BookClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService book = (BookService)ctx.getBean("book");
		
		// 리스트 추가
		BookVO vo = new BookVO();
		vo.setCode("2299");
		vo.setTitle("자바12345");
		vo.setWriter("자바정");
		vo.setPrice(25000);
		int result = book.insertBook(vo);
		if(result>0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
		// 리스트 가져온 후 출력하기
		List<BookVO> list = book.getList();
		for(BookVO vo1:list) {
			System.out.println(vo1);
		}
	}
}
