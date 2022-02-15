package com.example.shopjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/")
    public ModelAndView getHomePage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("home");
        return view;
    }
}
