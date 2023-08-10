package com.example.Spring.controllers;

import com.example.Spring.models.Link;
import com.example.Spring.repo.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private LinkRepository linkRepository;
    private String full_link = "";
    private String abbreviated_link = "";

    @GetMapping("/")
    public String index(@RequestParam(name = "error", defaultValue = "", required = false) String error, Model model) {
        model.addAttribute("links", linkRepository.findAll());

        if (error.equals("abbreviated")) {
            model.addAttribute("error", "Такое сокращение уже используется!");
            model.addAttribute("full_link", full_link);
            model.addAttribute("abbreviated_link", abbreviated_link);
        } else if (error.equals("full_link")) {
            model.addAttribute("error", "Некорректная ссылка");
            model.addAttribute("full_link", full_link);
            model.addAttribute("abbreviated_link", abbreviated_link);
        } else if (error.equals("abbreviated_link")) {
            model.addAttribute("error", "Некорректное сокращение");
            model.addAttribute("full_link", full_link);
            model.addAttribute("abbreviated_link", abbreviated_link);
        } else if (error.equals("null"))
            model.addAttribute("error", "Готово");

        model.addAttribute("full_link", full_link);
        model.addAttribute("abbreviated_link", abbreviated_link);
        return "index";
    }

    @PostMapping("/link/add")
    public String addLink(@RequestParam String full, @RequestParam String abbreviated) {

        if (linkRepository.findByAbbreviated(abbreviated) != null) {
            full_link = full;
            abbreviated_link = abbreviated;
            return "redirect:/?error=abbreviated";
        } else if (full.length() < 5) {
            full_link = full;
            abbreviated_link = abbreviated;
            return "redirect:/?error=full_link";
        } else if (abbreviated.equals("")) {
            full_link = full;
            abbreviated_link = abbreviated;
            return "redirect:/?error=abbreviated_link";
        } else {
            full_link = "";
            abbreviated_link = "";
            Link link = new Link(full, abbreviated);
            linkRepository.save(link);

            return "redirect:/?error=null";
        }
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
