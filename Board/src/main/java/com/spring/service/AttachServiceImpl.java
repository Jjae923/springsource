package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.AttachFileVO;
import com.spring.mapper.AttachMapper;

@Service
public class AttachServiceImpl implements AttachService {

	@Autowired
	private AttachMapper attach;

	@Override
	public boolean insertAtt(AttachFileVO vo) {
		return attach.insert(vo)==1? true:false;
	}

	@Override
	public boolean deleteAtt(String uuid) {
		return attach.delete(uuid)==1? true:false;
	}

	@Override
	public List<AttachFileVO> selectAtt(int bno) {
		return attach.select(bno);
	}
}
