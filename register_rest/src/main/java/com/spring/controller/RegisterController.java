package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.RegisterVO;
import com.spring.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService service;
	
	@GetMapping("/step2")
	public void step1Get() {
		// step1 페이지 보여주기
		log.info("step1 페이지 보여주기");
	}
	
//	
//	@PostMapping("/step2")
//	public String handleStep2(boolean agree, RedirectAttributes rttr) {		// value 값을 true로 줬기 때문에 boolean이 가능
//		log.info("step2 페이지 보여주기");
//		// agree 체크 여부에 따라서 체크가 안된 경우
//		// step1 페이지를 다시 보여주기
//		if(!agree) {
//			rttr.addFlashAttribute("msg", "false");
//			return "redirect:step1";
//		}
//		return "/register/step2";
//	}
//	
//	@PostMapping("/step3")
//	public String step3(@ModelAttribute("vo") RegisterVO regist) {
//		//step2.jsp에서 사용자의 입력값 가져오기
//		log.info("step2 폼 내용 가져오기");
//		log.info(""+regist);
//		
//		if(regist.inPasswordEqualToConfirmPassword()) {
//			// step3.jsp 보여주기			
//			if(service.regist(regist)) {
//				log.info("회원가입 성공");
//				return "/register/step3";
//			}else {
//				return "/register/step2";
//			}
//		}else {
//			// 회원가입 페이지로 돌려보내기
//			return "/register/step2";
//		}
//	}
//	
//	@GetMapping(value= {"/step2", "/step3"})
//	public String handleStep2_3() {
//		// 사용자가 step2, step3를 get 방식으로 요청하는
//		// 경우에 step1으로 되돌려보내기
//		return "redirect:step1";
//	}
//	
//	@PostMapping("/checkId")  // join.js에서 remote로 설정해줌
//	@ResponseBody  // @ResponseBody : 컨트롤러에서 리턴하는 값은 jsp가 아니라 data값임을 의미하는 annotation
//	public String checkID(String userid) {
//		log.info("중복 아이디 검사 : "+userid);
//		if(service.dupId(userid)) {
//			return "true";	// 결과값의 의미로 리턴
//		}else {
//			return "false";
//		}
//	}
}






































