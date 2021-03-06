package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.SampleService;

public class SampleClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		SampleService service = (SampleService) ctx.getBean("sample");
		
		String data = "Starry\r\n"+"Starry night\r\n"+"Paint your paletter blue and grey"+"Look out on a summer'day";
		
		service.addData(data);
	}
}
