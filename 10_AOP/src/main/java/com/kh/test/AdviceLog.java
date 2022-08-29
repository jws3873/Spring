package com.kh.test;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceLog {
	
	
public Object profile(ProceedingJoinPoint jp) throws Throwable {
		
		// getSignature() : 호출되는 메서드에 대한 정보를 알려주는 메서드.
		String signStr = jp.getSignature().toString();
		
		System.out.println(signStr+"is Start !!!");
		
		long startTime = System.currentTimeMillis();
		
		Object obj = jp.proceed(); // 핵심기능을 실행시키는 메서드;
		
		System.out.println(signStr+"is end !!!");
		
		System.out.println("경과시간 >> "+(System.currentTimeMillis()-startTime)+"ms");
		
		return obj;
	}
}
