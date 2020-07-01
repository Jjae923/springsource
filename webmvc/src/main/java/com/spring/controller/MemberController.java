package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")		// http://localhost:8080/member
public class MemberController {
	
	
//	스프링에서 Request를 매핑시키는 방법
//	@RequestMapping(value="/login", method=RequestMethod.POST) // POST방식일 경우 반드시 명시할 것
//	@GetMapping("/login")		// GET방식
//	@PostMapping("/login")  	// POST방식
//	@PutMapping("/login")		// PUT방식      == @PatchMapping("/login")		
//	@DeleteMapping("/login")	// DELETE방식
	
	@GetMapping("/login")		
	public void login() {
		log.info("login 요청");
	}
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout 요청");
	}
	
	@RequestMapping("/register")
	public void register() {
		log.info("register 요청");
	}
}
