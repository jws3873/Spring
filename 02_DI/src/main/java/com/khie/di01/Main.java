package com.khie.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// AbstractApplicationContext 객체가 DI 작업을 해주는 스프링 컨테이너
		// xml 파일을 이용하여 메모리로 해당 xml 파일이 로딩 됨.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:getsum.xml");
		
		MyGetSum mysum =  (MyGetSum)ctx.getBean("mySum");
		
		mysum.sum();
		
		// 사용한 자원은 반납을 해야 함.
		ctx.close();
	}

}
