package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;

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
	
	@GetMapping("/login")	 // http://localhost:8080/member/login (Get) / GetPost방식으로 요청이 들어올 때 맵핑 
	public void login() {
		log.info("login form 요청");
	}
	
//	@PostMapping("/login")   // http://localhost:8080/member/login (Post)/ Post방식으로 요청이 들어올 때 맵핑
//	public void loginPost(HttpServletRequest req) {
//		log.info("login 요청");
//		
//		// 사용자가 보낸 값 가져오기①
//		log.info("userid : "+req.getParameter("userid"));
//		log.info("password : "+req.getParameter("password"));
//	}
	
//	@PostMapping("/login")   // http://localhost:8080/member/login (Post)/ Post방식으로 요청이 들어올 때 맵핑
//	public void loginPost(String userid, String password) { // 이렇게도 가능하지만 가져올 데이터가 많을 경우 좋지 않음
//		log.info("login 요청");
//		
//		// 사용자가 보낸 값 가져오기②
//		log.info("userid : "+userid);
//		log.info("password : "+password);
//	}
	
//	@PostMapping("/login")   // http://localhost:8080/member/login (Post)/ Post방식으로 요청이 들어올 때 맵핑
//	public void loginPost(@RequestParam("userid") String id, String password) { // 가져올 이름과 넣어줄 이름이 다를 경우 / req에서 가져오는 것을 명확하게 하기 위해서도 사용
//		log.info("login 요청");
//		
//		// 사용자가 보낸 값 가져오기②
//		log.info("userid : "+id);
//		log.info("password : "+password);
//	}
	
	@PostMapping("/login")   // http://localhost:8080/member/login (Post)/ Post방식으로 요청이 들어올 때 맵핑
	public String loginPost(LoginVO login) { // 데이터가 많을 경우 매우 유용
		log.info("login 요청");
		
		// 사용자가 보낸 값 가져오기③
		log.info("userid : "+login.getUserid());
		log.info("password : "+login.getPassword());
		
		
		// logout.jsp 보여주기
		return "member/logout";
	}
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout 요청");
	}
	
	@RequestMapping("/register")
	public void register() {
		log.info("register form 요청");
	}
	
	@PostMapping("/register")
	public void registerPost(RegisterVO vo) {
		log.info("register 요청");
		
		// 사용자로부터 정보 가져오기
		log.info("userid : "+vo.getUserid());
		log.info("password : "+vo.getPassword());
		log.info("comfirm_password : "+vo.getComfirm_password());
		log.info("mobile : "+vo.getMobile());
	}
	
	//update.jsp 보여주는 컨트롤러 생성하기
	@GetMapping("/update")
	public void update() {
		log.info("update form 요청");
		
	}
	
//	@PostMapping("/update")
//	public void updatePost(String userid, String password, Model model) {
//		log.info("update 요청");
//		model.addAttribute("userid", userid);
//		model.addAttribute("password", password);
//	}
	
	@PostMapping("/update")
	public void updatePost(@ModelAttribute("userid") String userid, String password) {
		log.info("update 요청");
	}
	
	// @ModelAttribute : 도메인 객체의 이름 지정
	//					 Model의 역할을 함 (request.setAttribute와 같은 역할)
}

























