package com.example.Module_11.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/about-us")
    public String about(@RequestParam(name = "userName", required = false, defaultValue = "World") String userName, Model model) {
        model.addAttribute("name", userName);
        return "about";
    }
}
