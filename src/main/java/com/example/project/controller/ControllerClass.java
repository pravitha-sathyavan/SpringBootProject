package com.example.project.controller;

import com.example.project.ProjectApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//The below two annotations can be replaced with @RestController
@Controller
@ResponseBody
public class ControllerClass {

    @Value("${spring.application.name:defaultName}")
    private String name;

    @Value("${welcome.text:defaultName}")
    private String lang;

    private static final Logger logger = LoggerFactory.getLogger(ProjectApplication.class);

//    @GetMapping("/home")
//    public ModelAndView loadHome() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("View.html");
//        return modelAndView;
//    }

    @GetMapping("/home2")
    public String loadHome2() {
        return "View.html";
    }

    @GetMapping("/appName")
    public String getApplicationName() {
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        return name;
    }

}
