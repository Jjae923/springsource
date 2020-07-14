package com.spring.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {
	
	@GetMapping("/select")
	public String selectAll() {
		log.info("도서 목록 폼 요청");
		
		// 페이지 이동
		return "/book_selectAll";
	}

	@GetMapping("/info")
	public String info() {
		log.info("도서 정보");
		return "book_info";
	}
	
	@GetMapping("/insert")
	public String insert() {
		log.info("도서 정보 입력");
		return "book_insert";
	}
}
