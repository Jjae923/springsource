package com.spring.service;

import java.util.List;

import com.spring.domain.PersonVO;

public interface PersonService {
	public void insertPerson(String id, String name);
	public String selectPerson(String id);
	public List<PersonVO> getList();
	public boolean update(PersonVO vo);
	public boolean delete(String id);
}
