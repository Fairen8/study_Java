package com.example.Module_13.controllers;

import com.example.Module_13.models.Role;
import com.example.Module_13.models.User;
import com.example.Module_13.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(name = "error", defaultValue = "", required = false) String error, Model model) {
        if(error.equals("username")) {
            model.addAttribute("error", "Такой логин пользователя уже занят");
        }
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@RequestParam String username,
                          @RequestParam String email,
                          @RequestParam String password) {
        if(userRepository.findByUsername(username) != null) {
            return "redirect:/reg?error=username";
        }

        password = passwordEncoder.encode(password);
        User user = new User(username, password, email, true, Collections.singleton(Role.ADMIN));
        userRepository.save(user);
        return "redirect:/login";
    }
}
