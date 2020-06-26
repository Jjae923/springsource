package com.spring.stu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
//		자바방식 ① 인자를 받는 생성자를 이용하여 초기화하며 객체 생성
//		StudentInfo info = new StudentInfo(new Student("hong","15","3"));
//		info.getStudentInfo();
		
//		자바방식 ② 객체 생성 후 set메소드를 통해 초기화
//		Student stu = new Student();
//		stu.setAge("15");
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		StudentInfo info = (StudentInfo)ctx.getBean("info");
		info.getStudentInfo();
	}
}
