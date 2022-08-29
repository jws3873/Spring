package com.test.json;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Person implements Serializable {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		Person person = new Person("Libi", 26);
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Serialization.txt"))){
			out.writeObject(person);
		} catch (Exception e) {
		}
		
		Person person2 = null;
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Serialization.txt"))){
			person2 = (Person) in.readObject();
		} catch (Exception e) {
		}
		
		System.out.println(person.toString());

	}
}