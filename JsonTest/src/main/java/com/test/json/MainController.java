package com.test.json;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    // home.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
        
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void init(@RequestBody HashMap<String, Object> map) {
            System.out.println(map);
            // {name=kim, age=30} 출력
    }
}