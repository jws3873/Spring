package com.spring.mvc03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/student")
	public String scoreForm() {
		return "student/scoreForm";
	}
	
	/*
	 * @RequestMapping("/studentOk") public ModelAndView reseult(HttpServletRequest
	 * request) {
	 * 
	 * String student_name = request.getParameter("name").trim();
	 * 
	 * int kor = Integer.parseInt(request.getParameter("kor").trim());
	 * 
	 * int eng = Integer.parseInt(request.getParameter("eng").trim());
	 * 
	 * int math = Integer.parseInt(request.getParameter("math").trim());
	 * 
	 * ModelAndView model = new ModelAndView();
	 * 
	 * model.addObject("studentName", student_name); model.addObject("kor", kor);
	 * model.addObject("eng", eng); model.addObject("math", math);
	 * model.setViewName("student/result");
	 * 
	 * return model; }
	 */
	
	@RequestMapping("/studentOk")
	public ModelAndView reseult(
			@RequestParam("name") String student_name, HttpServletRequest request,
			@RequestParam("kor") int kor, @RequestParam("eng") int eng, @RequestParam("kor") int math) {
		//*** @RequestParam을 통해 폼 페이지에서 파라미터 값을 가져 올 경우 정수형의 타입을 지정해주면 Integer.parseInt() 메서드로 형변환 필요가 없다.
		ModelAndView model = new ModelAndView();
		System.out.println("@RequestParam 애노테이션으로 형변환 >>> "+((Object)kor).getClass().getSimpleName());
		
		model.addObject("studentName", student_name);
		model.addObject("kor", kor);
		model.addObject("eng", eng);
		model.addObject("math", math);
		int total = kor+eng+math;
		String avg = String.format("%.2f", total/3.0);
		model.addObject("total", total);
		model.addObject("avg", avg);
		model.setViewName("student/result");
		
		return model;
	}
}
