package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("log")
public class LogAdvice {
	
//	@Before(value="execution(* com.spring.domain.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[공동로그] 비즈니스 로직 수행 전 호출");	
//	}
	
//	@After(value="execution(* com.spring.domain.Product.getInfo())")
//	public void afterLog() {
//		System.out.println("[공동로그] 비즈니스 로직 수행 후 호출");
//	}
	@Around(value="execution(* com.spring.domain.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[공동로그] 비즈니스 로직 수행 전 호출");
		
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[공동로그] 비즈니스 로직 수행 후 호출");
	}
}
