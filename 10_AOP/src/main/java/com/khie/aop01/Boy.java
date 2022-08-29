package com.khie.aop01;


/*
 * 남자(청소년)
 * - 학교 수업 후 집에 와서 문을 열고 집에 들어갑니다.  ==> 공통 관심사항(이전)
 * - 컴퓨터로 게임을 합니다.					 ==> 핵심기능
 * - 잠을 잡니다.							 ==> 공통 관심사항 (이후)
 * - 화재 발생 : 119에 신고					 ==> 공통 관심 사항 (이후 - 예외)
 * - 아침에 일어나서 문을 열고 집을 나옵니다.		 ==> 공통 관심 사항 (이후)
 */
public class Boy implements Person{

	@Override
	public void doSomrthing() { // 핵심기능
		System.out.println("컴퓨터로 게임을 합니다.");
	}

}
