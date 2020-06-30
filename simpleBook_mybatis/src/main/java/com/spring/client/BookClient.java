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
		
		// 입력
		BookVO vo = new BookVO();
		vo.setCode("2277");
		vo.setTitle("mybatis 마스터22");
		vo.setWriter("쉬웡");
		vo.setPrice(30000);
		boolean result = book.insertBook(vo);
		if(result) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
		// 업데이트
		BookVO vo1 = new BookVO();
		vo1.setCode("2222");
		vo1.setPrice(50000);
		if(book.updateBook(vo1)) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}
		
		// 리스트 가져온 후 출력하기
		List<BookVO> list = book.getList();
		for(BookVO vo2:list) {
			System.out.println(vo2);
		}
	}
}
