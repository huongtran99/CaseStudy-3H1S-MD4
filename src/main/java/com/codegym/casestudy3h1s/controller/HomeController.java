package com.codegym.casestudy3h1s.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String index() {
        return "product/index";
    }
}
