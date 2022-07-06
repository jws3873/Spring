package com.kh.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aoptest.xml");
		
		Staff staff = (Staff)ctx.getBean("staff");
		
		staff.getStaffinfo();
		
		System.out.println("=====================================================================");
		
		Student student = ctx.getBean("student",Student.class);
		
		student.getStudentInfo();
		
		ctx.close();

	}

}
