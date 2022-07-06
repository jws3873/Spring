package com.khie.aop;

public class MyClass {

	void aaa() {
		//System.out.println("이전에 실행되는 공통메서드 !!!"); // 이전공통기능 before
		System.out.println("aaa() 메서드 호출~~~");  // 핵심기능
		//System.out.println("이후에 실행되는 공통메서드 !!!"); // 이후 공통기능 after
	}
	
	void bbb() {
		//System.out.println("이전에 실행되는 공통메서드 !!!");  // 이전공통기능
		System.out.println("bbb() 메서드 호출");  // 핵심기능
		//System.out.println("이후에 실행되는 공통메서드 !!!");  // 이후 공통기능
	}
	
	void ccc() {
		//System.out.println("이전에 실행되는 공통메서드 !!!");  // 이전공통기능
		System.out.println("ccc() 메서드 호출");  // 핵심기능
		//System.out.println("이후에 실행되는 공통메서드 !!!");  // 이후 공통기능
	}
}
