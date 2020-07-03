package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RedirectController {
	
	@GetMapping("/doA")		// http://localhost:8080/doA
	public String doA(RedirectAttributes rttr) {
		log.info("doA 요청");
		
		// RedirectAttributes : 일회성으로 값을 전달하기 위한 용도
		// parameter 형식으로 보내기
		// path +="?age=10"; 과 같은 개념
		rttr.addAttribute("age", 10);
		
		// sendRedirect 방식 (forward는 기본이라서 안붙여도 가는거)
		// redirect:를 붙이면 'url을 이걸로 다시 만들어줘'의 의미 
		return "redirect:/member/login";	// http://localhost:8080/member/login
	}
	
	@GetMapping("/doB")		// http://localhost:8080/doB
	public String doB(RedirectAttributes rttr) {
		log.info("doB 요청");
		rttr.addFlashAttribute("age", 10); // session 객체에 담아줌
		return "redirect:/";	// http://localhost:8080/
		
	}
	
}
