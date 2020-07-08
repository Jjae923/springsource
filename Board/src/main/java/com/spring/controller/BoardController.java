package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 글 작성하기
	@PostMapping("/register")
	public String registerPost(BoardVO vo, RedirectAttributes rttr) {
		log.info("글 작성 요청"+vo);
		
		if(service.insertBoard(vo)) {
			rttr.addFlashAttribute("result", vo.getBno());
			return "redirect:list";
		}
		return "register";
	}
	
	// 글 목록보기
	@GetMapping("/list")
	public void listGet(Model model) {
		log.info("list 요청");
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list);
	}
	
	// 게시글 읽기
	@GetMapping(value= {"/read","/modify"})
	public void read(int bno, Model model) {
		log.info(bno+"번째 게시글을 읽어보쟈");
		
		BoardVO vo = service.readBoard(bno);
		model.addAttribute("vo", vo);
	}
	
	// 게시글 수정하기
	@PostMapping("/modify")
	public String modifyPost(BoardVO vo, RedirectAttributes rttr) {
		log.info("수정 요청");
		
		if(service.modifyBoard(vo)) {
			// rttr.addFlashAttribute("", "");  // addFlashAttribute : session에 담아서 EL로 꺼내 쓸 수 있음
			rttr.addAttribute("bno", vo.getBno());   // addAttribute : parameter로 넘어가는 방식
			return "redirect:read"; 	//  read?bno=3
		}else {
			rttr.addAttribute("bno", vo.getBno());
			return "redirect:modify";
		}
	}
	
	// 게시글 삭제하기
	@PostMapping("/remove")
	public String delete(int bno, RedirectAttributes rttr) {
		log.info("삭제 요청");
		
		if(service.deleteBoard(bno)) {
			rttr.addFlashAttribute("result", "success");
			return "redirect:list";
		}else {
			rttr.addAttribute("bno", bno);
			return "redirect:modify";
		}
	}
	
}
