package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.NumVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/calc")
public class CalcController {
	
	@GetMapping("/calc")
	public void calcForm() {
		log.info("신나는 사칙연산~~");
	}
	
	@PostMapping("/calc")
	public String calcPost(int num1, String op, int num2, Model model) {
		log.info("결과값은!!!!!!");
		
//		if(op.equals("+")) {
//			log.info("num1 + num2 = "+(num1+num2));
//		}else if(op.equals("-")) {
//			log.info("num1 - num2 = "+(num1-num2));
//		}else if(op.equals("/")) {
//			log.info("num1 / num2 = "+(num1/num2));
//		}else if(op.equals("*")) {
//			log.info("num1 * num2 = "+(num1*num2));
//		}
		
		// 쌤은 switch로
		log.info("num1 "+num1);
		log.info("num2 "+num2);
		log.info("op "+op);
		
		int result=0;
		switch (op) {
		case "+":
			result = num1+num2;
			break;
		case "-":
			result = num1-num2;
			break;
		case "*":
			result = num1*num2;
			break;
		case "/":
			result = num1/num2;
			break;		
		}
		log.info("result = "+result);
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("op", op);
		model.addAttribute("result", result);
		return "calc/calcresult";
	}
	
	// 쌤은 switch로
//	@PostMapping("/calc")
//	public String calcPost(@ModelAttribute("vo") NumVO vo, Model model) { // 다음 페이지까지 값 유지하려면 VO 사용
//		log.info("calc 요청");
//		
//		int num1 = vo.getNum1();
//		int num2 = vo.getNum2();
//		String op = vo.getOp();
//		
//		log.info("num1 "+num1);
//		log.info("num2 "+num2);
//		log.info("op "+op);
//		
//		int result=0;
//		switch (op) {
//		case "+":
//			result = num1+num2;
//			break;
//		case "-":
//			result = num1-num2;
//			break;
//		case "*":
//			result = num1*num2;
//			break;
//		case "/":
//			result = num1/num2;
//			break;		
//		}
//		log.info("result = "+result);
//		
//		// request.setAttribute 같은 역할
//		model.addAttribute("result", result);
//		
//		return "calc/calcresult";
//	}
}





























