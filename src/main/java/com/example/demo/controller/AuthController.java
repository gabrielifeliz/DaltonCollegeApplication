package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @RequestMapping("/student")
    public String studentHome() {
        return "student-home";
    }

    @RequestMapping("/admin")
    public String adminHome() {
        return "admin-home";
    }
}
