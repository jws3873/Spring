package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC6 {
	
	@ExceptionHandler(Exception.class)
	public String carcher(Exception ex, BindingResult result) {
		System.out.println("result = " + result);
		FieldError error = result.getFieldError();
		
		System.out.println("getCode() = "+ error.getCode());
		System.out.println("getField() = "+error.getField());
		System.out.println("getDefaultMessage() = "+ error.getDefaultMessage());
		ex.printStackTrace();
		return "yoilError";
	}
	
	
	
    @RequestMapping("/getYoilMVC6") // http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
    // public String main(@ModelAttribute("mydate") MyDate date, Model model) throws IOException { // 아래와 동일
    public String main(MyDate date, BindingResult result) throws IOException {
    	System.out.println("result = " + result);
    	// 1. 유효성 검사
    	if(!isValid(date)) {
    		return "yoilError";
    	}
    	
    	
        // 2. 처리
        // char yoil = getYoil(date);
        
        // 3. 계산한 결과를 model에 저장
        ModelAndView mv = new ModelAndView();
        
        // model.addAttribute("myDate", date);
        // model.addAttribute("yoil", yoil);

        return "yoil";

    }

	private boolean isValid(MyDate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(int year, int month, int day) {
		if(year==-1 || month==-1 || day==-1) 
    		return false;
		
		return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
	}
}