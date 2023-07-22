package com.example.Module_11.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/uslugi")
    public String uslugi() {
        return "uslugi";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/сontacts")
    public String сontacts() {
        return "сontacts";
    }
}
