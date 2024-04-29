package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocaleController {

    @GetMapping("/lang")
    public String loadlanguageVariable() {
        return "locale";
    }

    @GetMapping("/home3")
    public String loadHome() {
        return "View";
    }
}
