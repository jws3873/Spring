package com.test.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class Info_Serialize implements Serializable{
	//==== 전역변수 선언 실시 ====
	private String name = "";
	private int age = 0;
	//==== 클래스 생성자 초기화 실시 ====
	public Info_Serialize(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//==== toString 반환값 재정의 실시 (json형태 포맷) ====
	@Override
	public String toString() {
		return String.format("{\"name\"=\"%s\",\"age\"=%d}", name, age);
	}
}//Serializable 클래스 종료

public class MainActivity5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[json형식으로 직렬화 (serialize) 바이트값 포맷, 역직렬화(deserialize) 원본 데이터 확인 실시]");
		
		/*[설 명]
		 * 1. 직렬화 - 외부 시스템과 데이터를 주고 받을 수 있도록 byte 형태로 데이터를 전송하는 것입니다 
		 * 2. 역직렬화 - byte 형태 데이터를 다시 원본 데이터로 변환하는 것입니다
		 * 3. 사용이유 - 복잡한 데이터 구조 형태라도 직렬화 조건만 지키면 간편하게 byte 형태 데이터를 주고 받을 수 있습니다
		 * 4. 조건 - 직렬화, 역직렬화를 담당하는 클래스는 반드시 Serializable 인터페이스를 상속받아야합니다
		 * 5. Info_Serialize 클래스 - 직렬화, 역직렬화를 담당하는 객체입니다
		 * 6. InputStream은 데이터 읽기, OuputStream은 데이터 쓰기를 담당합니다
		 * 7. toString - 데이터 반환 형태를 정의한 것으로 사용자가 다른 포맷 방식으로 변경할 수 있습니다
		 * 8. 자바에서 쌍따옴표를 사용하기 위해서는 [역슬래쉬 쌍따옴표 \"] 를 해주면됩니다
		 */
		
		//==== 직렬화 수행 실시 ====
		Info_Serialize info_Serialize = new Info_Serialize("twok",28);
		byte serialize_arr[] = null; //직렬화 바이트값을 담을 배열 선언
		try {
			ByteArrayOutputStream s_bs = new ByteArrayOutputStream();
			ObjectOutputStream s_os = new ObjectOutputStream(s_bs);
			s_os.writeObject(info_Serialize); //데이터 쓰기
			
			serialize_arr = s_bs.toByteArray(); //바이트값을 배열에 담습니다
			System.out.println("직렬화 [전] 데이터 : "+info_Serialize.toString());
			System.out.println("직렬화 [후] 데이터 : "+Arrays.toString(serialize_arr));
			System.out.println("");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//==== 역직렬화 수행 실시 ====
		byte deserialize_arr[] = null; //역직렬화를 수행하기위해 담을 배열 선언
		deserialize_arr = Arrays.copyOf(serialize_arr, serialize_arr.length); //바이트값 복사 실시
		try {
			System.out.println("역직렬화 [전] 데이터 : "+Arrays.toString(deserialize_arr));
			ByteArrayInputStream d_bs = new ByteArrayInputStream(deserialize_arr);
			ObjectInputStream d_os = new ObjectInputStream(d_bs);
			
			Object deserialize_object = d_os.readObject(); //데이터 읽기
			Info_Serialize info_Deserialize = (Info_Serialize) deserialize_object;
			System.out.println("역직렬화 [후] 데이터 : "+info_Deserialize);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}//메인 종료

}//클래스 종료
