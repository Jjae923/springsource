package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	
	@RequestMapping("/test")   //http://localhost:8080/test
	public void test() {
		log.info("test 요청....");
	}
	
	@RequestMapping("/login")   //http://localhost:8080/login
	public void test2() {
		log.info("test2 요청....");
	}
	
	@RequestMapping("/test3")   //http://localhost:8080/test3
	public String test3() {
		log.info("test3 요청....");
		return "sample/test3";			// /WEB-INF/views/sample/test3.jsp
	}
	
	@RequestMapping("/sample/test4")   //http://localhost:8080/sample/test4
	public void test4() {
		log.info("test4 요청....");
	}
}
