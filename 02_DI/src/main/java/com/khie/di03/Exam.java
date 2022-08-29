package com.khie.di03;

public class Exam {

	private String msg;
	
	public Exam() { } // 기본생성자
	
	public Exam(String msg) {
		this.msg = msg;
	} // 인자생성자

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	// 비지니스로직
	public void output() {
		System.out.println("메세지 >>> " + msg);
	}
	
	
	
	
}
