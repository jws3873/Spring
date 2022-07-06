package com.khie.di07;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:map.xml");
		
		MapTest test = ctx.getBean("test",MapTest.class);
		
		test.prn();
		
		ctx.close();
	}
}
