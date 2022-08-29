package com.spring.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 애노테이션을 붙여줘야지 컨트롤러로 사용가능하다.
@Controller
public class MyController {
	
	
	/*
	 * ModelAndView 객체란???
	 * - ModelAndView 객체는 컨트롤러에 의해서
	 * 	 비지니스 로직이 수행되고 나면 대체적으로
	 *   사용자에게 반환되어 브라우저에 보여질 정보들이 만들어진다.
	 *   이 때 만들어진 정보를 view page로 넘겨주게 되는데
	 *   응답을 할 view page정보와 함께 전달할 데이터를
	 *   한꺼번에 저장하여 넘겨 줄 때 사용하는 객체.
	 */
	
	
	//정보를 넘겨주는 방법 은 model과 ModelAndView
	@RequestMapping("/info")
	public ModelAndView abc() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("email", "hong@naver.com");
		mav.setViewName("member/email");
		
		return mav;
	}
}
