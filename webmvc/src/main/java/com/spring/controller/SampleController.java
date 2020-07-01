package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j          // log 처리
@Controller     // annotation 붙이기
@RequestMapping("/sample")   // http://localhost:8080/sample
public class SampleController {
	// 컨트롤러 안에 작성한 메소드와 @RequestMapping 을 연결하면
	// 사용자의 URL 요구에 응답하는 처리를 만들어 낼 수 있음
	@RequestMapping("/basic")   // http://localhost:8080/sample/basic
	public void basic() {
		log.info("basic 요청.....");
		//		/sample/basic.jsp
	}
	
	@RequestMapping("/test")    // http://localhost:8080/sample/test
	public void test() {
		log.info("test 요청...");
	}
	
	@RequestMapping("/login")    // 주소와 관련   ▶   http://localhost:8080/sample/login
	public String login() {
		log.info("login 요청...");
		return "signin";	// 응답페이지 jsp와 관련  ▶  /WEB-INF/views/signin.jsp
	}
}
