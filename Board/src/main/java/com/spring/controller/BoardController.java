package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageVO;
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
	public void listGet(Model model,@ModelAttribute("cri") Criteria cri) {
		log.info("list 요청");
		// 현재 페이지에 보여줄 게시물
		model.addAttribute("list", service.getList(cri));
		// 하단의 페이지 나누기와 관련된 정보
		model.addAttribute("pageVO", new PageVO(cri, service.totalRows(cri)));
	}
	
	// 게시글 읽기
	@GetMapping(value= {"/read","/modify"})
	public void read(int bno,@ModelAttribute("cri") Criteria cri, Model model) {
		log.info(bno+"번째 게시글을 읽어보쟈"+"..."+cri);
		
		BoardVO vo = service.readBoard(bno);
		model.addAttribute("vo", vo);
		// http://localhost:8080/board/read
		// http://localhost:8080/board/modify
	}
	
	// 게시글 수정하기
	@PostMapping("/modify")
	public String modifyPost(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		log.info("수정 요청" + cri);
		
		if(service.modifyBoard(vo)) {
			// rttr.addFlashAttribute("", "");  // addFlashAttribute : session에 담아서 EL로 꺼내 쓸 수 있음
			rttr.addAttribute("bno", vo.getBno());   // addAttribute : parameter로 넘어가는 방식
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			return "redirect:read"; 	//  read?bno=3
		}else {
			rttr.addAttribute("bno", vo.getBno());
			return "redirect:modify";
		}
	}
	
	// 게시글 삭제하기
	@PostMapping("/remove")
	public String delete(int bno, Criteria cri, RedirectAttributes rttr) {
		log.info("삭제 요청"+bno);
		
		if(service.deleteBoard(bno)) {
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			rttr.addFlashAttribute("result", "success");
			return "redirect:list";
		}else {
			rttr.addAttribute("bno", bno);
			return "redirect:modify";
		}
	}
	
	
	
	
}
