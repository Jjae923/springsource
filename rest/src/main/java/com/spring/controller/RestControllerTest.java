package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	   // return 값을 마음대로 전송할 수 있음
public class RestControllerTest {
	@GetMapping(value="/hello", produces="text/plain;charset=utf-8")   // produces : 서버가 생산해내는 데이터 타입 지정
	public String sayHello() {
		return "Hello";
	}
}
