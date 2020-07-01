package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.SampleMapper1;
import com.spring.mapper.SampleMapper2;

@Service("sample")
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper1 mapper1;
	@Autowired
	private SampleMapper2 mapper2;
	
	@Transactional(rollbackFor = Exception.class) // 에러가 나면 exception 클래스를 불러줘
	@Override
	public void addData(String data) {
		// tbl_sample1과 tbl_sample2에 데이터 삽입
		mapper1.insertCol1(data);
		mapper2.insertCol1(data);

	}
}
