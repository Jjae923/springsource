package com.spring.factorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactorialMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Calcurator cal = (Calcurator) ctx.getBean("forc");
		System.out.println("=================");
		System.out.println("10! = "+cal.factorial(10));
		System.out.println("=================");
		
		cal = (Calcurator) ctx.getBean("rec");
		System.out.println("=================");
		System.out.println("10! = "+cal.factorial(10));
		System.out.println("=================");
	}
}
