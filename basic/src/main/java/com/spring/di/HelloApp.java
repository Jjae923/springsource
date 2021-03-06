package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		//MessageBean msg = new MessageBean();
		
		// 스프링 컨테이너 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		// Look Up : 스프링 컨테이너로부터 필요한 객체를 요청
		MessageBean msg = (MessageBean)ctx.getBean("msg2");
		
		msg.sayHello();
	}
}
