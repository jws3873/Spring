package com.khie.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/*
 *  - 스프링은 객체를 생성하고 각각의 객체를 연결해 주는 조립기 역할을 함.
 *  - 여기에 있는 GenericXmlApplicationContext 객체가 조립 기능을 구현한 클래스임.
 *  - 조립기에서 생성할 객체가 무엇이고 각 객체를 어떻게 연결하는지에 대한 정보는 xml 파일에
 *    설정이 되어 있음.
 *  - GenericXmlApplicationContext 객체는 이 xml 파일에 정의된 설정 정보를 읽어와서
 *    객체를 생성하고, 각각의 객체를 연결한 뒤에 내부적으로 보관을 함.
 *  - xml을 이용한 스프링 설정을 하다 보면 컨테이너가 생성할 객체를 지정하기 위해 <bean> 태그를
 *    사용하게 됨.
 *  - 스프링 컨테이너가 생성해서 보관하는 객체를 스프링 빈(spring bean) 객체라고 부르며,
 *    일반적으로 자바 객체와 동일함.
 *  - 스프링 컨테이너는 생성한 빈 객체를 <이름, 빈객체> 이렇게 쌍으로 보관을 함.
 *  - 스프링 컨테이너가 보관하고 있는 객체를 이용하고 싶은 경우 빈 객체와 연결되어 있는 이름을
 *    이용해서 객체를 참조하게 됨.
 */

/*
 *  스프링 컨테이너의 종류
 *  - BeanFactory : 단순히 스프링 컨테이너에서 객체를 생성하고 DI만 처리해 주는 기능만을
 *  				제공해 주는 객체. 하지만 스프링을 사용하는 이유는 단순히 DI만 사용하기
 *  				위함이 아닌 스프링을 사용하는 다양한 부가 기능(트랜잭션처리, 자바코드
 *  				기반의 스프링 설정, 애노테이션을 이용헌 빈 설정, 스프링을 이용한 웹 개발
 *  				등등) 때문인에 이러한 부가 기능을 사용하기 위해서는 ApplicationContext
 *  				객체를 주로 사용하게 됨.
 *  - AbstractApplicationContext : 컨테이너 종료(close) 와 같은 기능을 제공해 주는 객체.
 *  - GenericXmlApplicationContext : AbstractApplicationContext 객체를 상속을 받아서
 *  								만들어진 클래스로써 xml 파일에서 스프링 빈 설정 정보를
 *  								읽어오는 역할을 함. GemericXmlAppliocationContext
 *  								객체를 생성할 때 파라미터 값으로 "classpath:mydao.xml"
 *  								을 전달했는데 이는 클래스패스에 위치한 xml 파일을 설정 파일로
 *  								사용한다는 의미힘.
 *  - GemericXmlAppliocationContext 객체는 전달받은 xml 파일에서 설정 정보를 읽어와서 스프링 빈
 *    객체를 생성하고 프로퍼티 값을 설정해 줌. 이렇게 생성된 빈 객체는 getBean() 이라는 메서드를 사용해서
 *    구현을 할 수 있음. getBean() 메서드의 첫번째 파라미터는 구현하고자 하는 스프링 빈 객체의 고유한
 *    id 이름이며, 두번째 파라미터는 그 객체의 클래스 타입을 의미함.
 */


import com.khie.di01.MyGetSum;

public class Main {
	public static void main(String[] args) {
		
		//GenericXmlApplicationContext : XML로부터 객체 설정 정보를 가져온다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:mydao.xml");
		
		ServiceImpl 
		service = (ServiceImpl)ctx.getBean("service",ServiceImpl.class); //,ServiceImpl.class -> ServiceImpl클래스 타입이다 라는 선언 (ServiceImpl)생략가능
		
		service.biz();
		
		ctx.close();
	}
}
