package com.khie.di09;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:baseball3.xml");
		
		// config클래스 내부 @bean으로 정의된 객체생성 매서드
		Player player1 = ctx.getBean("player1",Player.class);
		System.out.println("선수 이름 >>> "+player1.getName());
		System.out.println("선수 나이 >>> "+player1.getAge());
		System.out.println("선수 포지션 >>> "+player1.getPosition());
		System.out.println("선수 체중 >>> "+player1.getWeight());
		System.out.println("선수 신장 >>> "+player1.getHeight());
		
		System.out.println("=======================================");
		
		// config클래스 내부 @bean으로 정의된 객체생성 매서드
		Player player2 = ctx.getBean("player2",Player.class);
		System.out.println("선수 이름 >>> "+player2.getName());
		System.out.println("선수 나이 >>> "+player2.getAge());
		System.out.println("선수 포지션 >>> "+player2.getPosition());
		System.out.println("선수 체중 >>> "+player2.getWeight());
		System.out.println("선수 신장 >>> "+player2.getHeight());
		
		System.out.println("=======================================");
		//xml내부 bean의로 정의된 객체
		Player player3 = ctx.getBean("player3",Player.class);
		System.out.println("선수 이름 >>> "+player3.getName());
		System.out.println("선수 나이 >>> "+player3.getAge());
		System.out.println("선수 포지션 >>> "+player3.getPosition());
		System.out.println("선수 체중 >>> "+player3.getWeight());
		System.out.println("선수 신장 >>> "+player3.getHeight());
		
		ctx.close();

	}

}
