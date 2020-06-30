package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("rec")
public class RecCalcurator implements Calcurator {

	@Override
	public long factorial(long num) {
		// 재귀로 구하는 factorial
		if(num==0) {
			return 1;
		}else {
			return num * factorial(num-1);  // 메소드 안에서 자기를 호출함
		}
	}
}
