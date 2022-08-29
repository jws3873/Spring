package com.spring.mvc04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping("/join_ok")
	public String join_ok(Person person, Model model) {
		// form의 입력데이터가 많아지면 parameter값을 받아오는데 상당한 시간이 소요된다.
		// 매개변수를 DTO객체로지정하고 form 입력 name을 dto 멤버와 동일하게 하면 자동으로 dto객체에 들어간다
		
		
		 // 일반적으로 스프링 프레임워크 사용시 웹페이지에서 form을 POST방식으로 전송할때
		 //	form elements의 name 속성과 데이터 전송 객체(DTO: Data Transfer Object 또는 VO: Value Object)의
		 //	변수명을 일치시켜주면(모든 변수가 같을 필요는 없다) 자동으로 해당 객체로 변환되어 Controller로
		 //	전송되게 됩니다.
		 
		
		/*
		 * HttpServletRequest request 매개변수 불필요
		 * String user_name = request.getParameter("name").trim(); String user_id =
		 * request.getParameter("id").trim(); String user_pwd =
		 * request.getParameter("pwd").trim(); int user_age =
		 * Integer.parseInt(request.getParameter("age").trim()); String user_phone =
		 * request.getParameter("phone").trim(); String user_email =
		 * request.getParameter("email").trim(); String user_addr =
		 * request.getParameter("addr").trim();
		 */
		
		//model.addAttribute("userName", user_name);
		//model.addAttribute("userId", user_id);
		//model.addAttribute("userPwd", user_pwd);
		//model.addAttribute("userAge", user_age);
		//model.addAttribute("userPhone", user_phone);
		//model.addAttribute("userEmail", user_email);
		//model.addAttribute("userAddr", user_addr);
		
		model.addAttribute("DTO", person);
		
		return "JoinInfo";
	}
	
	
}
