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
	
	@Autowired
	private BookService service;
	
	@GetMapping(value= {"/insert","/delete", "/modify"})
	public String handleGet() {
		log.info("부적절한 요청");
		return "redirect:/";
	}
	
	// 도서목록보기 클릭 시 동작하는 컨트롤러 생성
	@GetMapping("/select")
	public String selectAll(Model model) {
		log.info("도서 목록 요청");
		// 전체 도서목록을 가져온 후 모델에 담고
		List<BookVO> list = service.getList();
		model.addAttribute("list", list);
		// 페이지 이동
		return "/book_selectAll";
	}
	
	// 도서 목록 추가
	// book_insert에서 도서정보 가져오기
	// DB작업하고
	// 입력 성공 시 도서 목록 보여주기
	// 입력 실패 시 index
	@PostMapping("/insert")
	public String insertPost(BookVO vo, RedirectAttributes rttr) {
		log.info("도서 정보 입력 : " + vo);
		try {
			if(service.insert(vo)) {
				return "redirect:select";
			}else {
				rttr.addFlashAttribute("tab", "insert"); // session 에 값을 심음(Flash는 주소줄 표기X) / jsp에서 $로 가져올 수 있음
				return "redirect:/";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("tab", "insert");
			return "redirect:/";
		}
	}
	
	// 도서 목록 삭제
	@PostMapping("/delete")
	public String deletePost(String code, RedirectAttributes rttr) {
		log.info("도서 목록 삭제 : " + code);
		if(service.delete(code)) {
			return "redirect:select";
		}else {
			rttr.addFlashAttribute("tab", "delete");
			return "redirect:/";
		}
	}
	
	// 도서 목록 수정
	@PostMapping("/modify")
	public String modifyPost(String code, int price, RedirectAttributes rttr) {
		log.info("도서 목록 수정");
		if(service.modify(code, price)) {
			return "redirect:select";
		}else {
			rttr.addFlashAttribute("tab", "modify");
			return "redirect:/";
		}
	}
	
	// 도서 목록 검색
	// 성공 후 book_searchAll
	// 실패는 index
	@PostMapping("/search")
	public String searchPost(String criteria, String keyword, Model model, RedirectAttributes rttr) {
		log.info("검색 요청 "+criteria+" 검색어 : "+keyword);
		
		List<BookVO> list = service.getSearchList(criteria, keyword);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			return "book_searchAll";
		}else {
			rttr.addFlashAttribute("mag", "검색결과없음");
			rttr.addFlashAttribute("tab", "search");
			return "redirect:/";
		}
	}
	
	@GetMapping("/search")
	public String searchGet(RedirectAttributes rttr) {
		log.info("검색 폼 요청");
		rttr.addFlashAttribute("tab", "search");
		return "redirect:/";
	}
	
}
