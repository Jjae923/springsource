package com.spring.stu;

public class StudentInfo {
	private Student student;
	
	public StudentInfo() { // 초기화 안했음
		System.out.println("StudentInfo 객체 생성");
	}
	public StudentInfo(Student student) { // 초기화
		this.student = student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo() {
		if(student!=null) {
			System.out.println("이름 : "+student.getName());
			System.out.println("나이 : "+student.getAge());
			System.out.println("반 : "+student.getClassNum());
		}
	}
}
