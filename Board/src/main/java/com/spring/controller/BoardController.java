package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("register form 요청");
	}
	
	@GetMapping("/list")
	public void listGet(Model model) {
		log.info("list 요청");
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list);
	}
}
