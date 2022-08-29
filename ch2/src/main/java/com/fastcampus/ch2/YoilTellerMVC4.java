package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTellerMVC4 {
	
	@ExceptionHandler(Exception.class)
	public String carcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	
	
    @RequestMapping("/getYoilMVC4") // http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
    // public String main(@ModelAttribute("mydate") MyDate date, Model model) throws IOException { // 아래와 동일
    public String main(@ModelAttribute MyDate date, Model model) throws IOException {
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