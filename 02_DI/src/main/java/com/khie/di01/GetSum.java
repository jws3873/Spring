package com.khie.di01;

public class GetSum {
	private int su1;
	private int su2;
	
	public int getSu1() {
		return su1;
	}
	
	public void setSu1(int su1) {
		this.su1 = su1;
	}
	
	public int getSu2() {
		return su2;
	}
	
	public void setSu2(int su2) {
		this.su2 = su2;
	}
	
	// 핵심적인 기능(비지니스 로직)
	public void hap(int su1, int su2) {
		System.out.println("더하기 >>> "+(su1+su2));
	}
	
}
