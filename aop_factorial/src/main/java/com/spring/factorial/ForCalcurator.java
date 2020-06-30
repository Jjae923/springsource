package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("forc")
public class ForCalcurator implements Calcurator {

	@Override
	public long factorial(long num) {
		// for문으로 구하는 factorial
		long result = 1;
		for(int i=1; i<num; i++) {
			result*=i;	//5! = 5*4*3*2*1
		}
		return result;
	}
}
