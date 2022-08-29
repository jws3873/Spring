package com.spring.mvc02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/input")
	public String abc() {
		
		return "insertForm";
	}
	
	@RequestMapping("/inputOk")
	public String aaa(HttpServletRequest request, Model model) {

		String user_name = request.getParameter("name").trim();
		String user_id = request.getParameter("id").trim();
		
		model.addAttribute("userName", user_name);
		model.addAttribute("userId", user_id);
		
		return "loginResult";
		
	}
	
	@RequestMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	/*
	 * @RequestMapping("loginOk") public String loginOk(HttpServletRequest request,
	 * Model model) {
	 * 
	 * String user_id = request.getParameter("id").trim(); String user_pwd =
	 * request.getParameter("pwd").trim();
	 * 
	 * model.addAttribute("userId", user_id); model.addAttribute("userPwd",
	 * user_pwd);
	 * 
	 * return "loginResult2"; }
	 */
	
	@RequestMapping("/loginOk")
	// 입력 받은 정보를 처리하기 위해 매개변수를 주는 방법
	// 1. HttpServletRequest request 를 통해 요청받은 값을 처리
	// 2. @RequestParam("id") String user_id 통해 parameter 값을 받는다. 메서드 내부 변수처리 x
	public ModelAndView loginOk(@RequestParam("id") String user_id, @RequestParam("pwd") String user_pwd) {
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("userId", user_id);
		model.addObject("userPwd", user_pwd);
		model.setViewName("loginResult2");
		
		return model;
	}
	
	// 성적처리 이름 국어 영어 수학
}
