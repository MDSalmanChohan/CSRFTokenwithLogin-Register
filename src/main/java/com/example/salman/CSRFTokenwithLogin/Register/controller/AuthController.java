package com.example.salman.CSRFTokenwithLogin.Register.controller;


import com.example.salman.CSRFTokenwithLogin.Register.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        userService.registerUser(username, password);
        model.addAttribute("message", "Registration successful! You can now log in.");
        return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
