package com.khie.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:car.xml");
		
		Car car = ctx.getBean("car",Car.class);
		
		car.driver();
		
		ctx.close();
		
	}
}
