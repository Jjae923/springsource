package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;
import com.spring.service.MemberService;
import com.spring.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RequestMapping("/register/*")
@RequestMapping("/member/*")
public class MemberRestController {

	@Autowired
	private RegisterService service;

	// http://localhost:8080/register/step2 =>
	// http://localhost:8080/register/insert + post 
	@PostMapping("/insert")
	public ResponseEntity<String> registerPost(@RequestBody RegisterVO vo) {
		log.info("회원가입 정보 입력 : " + vo);
		return service.regist(vo)?
				new ResponseEntity<String>("success", HttpStatus.OK):
					new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
}
