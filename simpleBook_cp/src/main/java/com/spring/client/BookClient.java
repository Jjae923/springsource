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
		
		// 리스트 가져온 후 출력하기
		List<BookVO> list = book.getList();
		for(BookVO vo:list) {
			System.out.println(vo);
		}
	}
}
