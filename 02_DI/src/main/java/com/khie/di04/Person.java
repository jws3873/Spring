package com.khie.di04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String name; 
	private String gender;
	private int age;
	private String juminNo;
}
