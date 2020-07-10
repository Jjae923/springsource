package com.spring.mapper;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerMapper {
	public int register(PartnerVO vo);
	public List<PartnerVO> read();

}
