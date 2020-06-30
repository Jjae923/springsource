package com.spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonVO;
import com.spring.service.PersonService;

public class PersonClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		PersonService person = (PersonService) ctx.getBean("person");
		
//		person.insertPerson("jeong", "정재희");
//		System.out.println(person.selectPerson("jeong"));
		
		// 업데이트
		PersonVO vo = new PersonVO();
		vo.setId("heehee12");
		vo.setName("정째희");
		if(person.update(vo)) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}
		
		// 삭제
		person.delete("hong123");		
		List<PersonVO> list = person.getList();
		for(PersonVO vo1:list) {
			System.out.println(vo1);
		}
	}
}
