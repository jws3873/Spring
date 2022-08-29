package com.khie.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// advice == > 스프링 aop에서 공통관심사항이 있는 코드들의 묶음.
/*@Autowired(중요!!)

Bean의 의존성 주입은 @AutoWired를 이용하여 할 수 있다.

가져와서 사용하고 싶을 때 Singleton으로 사용될 수 있게끔 있는 거 찾아서 호출만 해주는거임

----> private로 해당 클래스 선언만 하고 어노테이션으로 autowired해주면 알아서 찾아서 호출 해줌*/
@Component //@Component : 개발자가 직접 작성한 클래스를 bean으로 등록하게 위한 어노테이션이다.
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* doSomething())")
	public void myPointCut() { }
	
	@Before("myPointCut()")
	public void befor() {
		System.out.println("학교 수업 후 집에 와서 문을 열고 집에 들어갑니다.");
	}
	
	@After("myPointCut()")
	public void after() {
		System.out.println("아침에 일어나서 문을 열고 집을 나옵니다.");
	}
	
	@AfterReturning("myPointCut()")
	public void after_returning() {
		System.out.println("잠을 잡니다.");
	}
	
	@AfterThrowing("myPointCut()")
	public void after_throwing() {
		System.out.println("화재 발생: 119에 신고");
	}
}
