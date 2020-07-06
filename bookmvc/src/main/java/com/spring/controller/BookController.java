package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book/*")
public class BookController {
	
	@Autowired
	private BookService service;
	
	// 도서목록보기 클릭 시 동작하는 컨트롤러 생성
	@GetMapping("/select")
	public String selectAll(Model model) {
		log.info("도서 목록 요청");
		// 전체 도서목록을 가져온 후 모델에 담고
		List<BookVO> list = service.getList();
		model.addAttribute("list", list);
		// 페이지 이동
		return "/book/book_selectAll";
	}
	
}

