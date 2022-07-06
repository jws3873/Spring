package com.khie.aop02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop02.xml");
		
		Person boy = (Person)ctx.getBean("boy");
		
		boy.doSomething();
		
		
		System.out.println("=====================================================================");
		
		Person girl = ctx.getBean("girl",Person.class);
		
		girl.doSomething();
		
		ctx.close();

	}

}
