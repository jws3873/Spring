package com.khie.aop04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop04.xml");
		
		Staff staff = (Staff)ctx.getBean("staff");
		
		staff.getStaffinfo();
		
		System.out.println("=====================================================================");
		
		Student student = ctx.getBean("student",Student.class);
		
		student.getStudentInfo();
		
		ctx.close();

	}

}
