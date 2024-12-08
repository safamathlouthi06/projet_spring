package com.example.projet_spring.controller;

import com.example.projet_spring.model.User;
import com.example.projet_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Rendu vers register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login"; // Redirection vers login après inscription
    }
}
