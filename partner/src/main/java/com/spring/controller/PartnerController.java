package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/partner/*")
public class PartnerController {
	
	@Autowired
	private PartnerService service;
	
	@GetMapping("/register")
	public void register() {
		log.info("register form 요청");
	}
	
	@PostMapping("/register")
	public String registerPost(PartnerVO vo) {
		log.info("register 요청");
		
		if(service.insertPartner(vo)) {
			return "redirect:list";
		}else {
			return "register";
		}
	}
	
	@GetMapping("/list")
	public void partnerList(Model model) {
		log.info("list 요청");
		model.addAttribute("list", service.getList());
	}
}
