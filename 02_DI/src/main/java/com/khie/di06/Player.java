package com.khie.di06;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본생성자
public class Player {
	private String name;
	private int age;
	private ArrayList<String> position;
	private double weight;
	private double height;
	
	public Player(String name, int age, ArrayList<String> position) {
		this.name = name;
		this.age = age;
		this.position = position;
	} // 인자생성자
}
