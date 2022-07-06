package com.khie.di04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeronInfo {

	private Person person;
	
	public void getPersonInfo() {
		if(person != null) {
			System.out.println("이름 >>> "+person.getName());
			System.out.println("성별 >>> "+person.getGender());
			System.out.println("나이 >>> "+person.getAge());
			System.out.println("주민번호 >>> "+person.getJuminNo());
		}
	}
}
