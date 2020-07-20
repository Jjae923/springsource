package com.spring.service;

import java.util.List;

import com.spring.domain.AttachFileVO;

public interface AttachService {
	public boolean insertAtt(AttachFileVO vo);
	public boolean deleteAtt(String uuid);
	public List<AttachFileVO> selectAtt(int bno);
}
