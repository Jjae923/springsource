package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PartnerController {
	
	@Autowired	 // 객체 주입
	private PartnerService service /* = new PartnerServiceImpl() */;	// controller에서 service 호출해야 함 /* PartnerServiceImpl 위의 @Service가 new해줬음 */
	
	@GetMapping("/partner/register")
	public void registerGet() {
		log.info("partner 정보 입력 폼 요청");
	}
	
	@PostMapping("/partner/register")
	public void registerPost(PartnerVO vo) {
		log.info("partner 정보 입력" + vo);
		service.insert(vo);
	}
}
