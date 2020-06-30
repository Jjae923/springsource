package com.spring.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
	@Around(value="execution(* com.spring.factorial..*(..))") // ()안은 매개변수
	public Object measure(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.nanoTime();
		try {
			Object obj = pjp.proceed();
			return obj;
		} finally {
			long end = System.nanoTime();
			System.out.println("걸린 시간 : "+(end-start));
		}
	}
}
