package com.spring.service;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerService {
	public boolean insert(PartnerVO vo);
	public List<PartnerVO> list();
}
