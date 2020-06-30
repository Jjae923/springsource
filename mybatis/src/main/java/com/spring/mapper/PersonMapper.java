package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.PersonVO;

public interface PersonMapper {

	// ① annotation 방식
//	@Insert("insert into person(id, name) values(#{id},#{name})")
//	public int insertPerson(@Param("id") String id, @Param("name") String name);
	
	// ② XML 방식
	public int insertPerson(@Param("id") String id, @Param("name") String name);
	public String selectPerson(String id);
	public List<PersonVO> selectPersons();
	public int updatePerson(PersonVO vo);
	public int deletePerson(String id);
}
