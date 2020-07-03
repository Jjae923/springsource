package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {

	@GetMapping("/step1")
	public void step1Get() {
		// step1 페이지 보여주기
		log.info("step1 페이지 보여주기");
	}
	
	@PostMapping("/step2")
	public void handleStep2() {
		log.info("step2 페이지 보여주기");
	}
}
