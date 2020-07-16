package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PartnerVO;
import com.spring.mapper.PartnerMapper;

@Service	// @Component, @Repository, @Controller  => SpringFramework가 객체 생성해주도록 하는 Annotation
public class PartnerServiceImpl implements PartnerService {

	@Autowired		// 객체 주입 (@Inject 도 가능)
	private PartnerMapper mapper/* = new PartnerMapper */;	// service에서는 mapper를 호출할 거라서 필요 /* interface라서 new로 객체 생성안됨 */
	
	@Override
	public boolean insert(PartnerVO vo) {
		return mapper.create(vo)==1? true:false;
	}

	@Override
	public List<PartnerVO> list() {
		return mapper.read();
	}
}
