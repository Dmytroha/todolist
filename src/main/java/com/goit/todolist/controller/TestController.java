package com.goit.todolist.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @Value("${my.test.property}")
    private  String myTestProperty;
    @GetMapping("/test")
    public String test() {
       return "test--->"+myTestProperty;
    }


}
