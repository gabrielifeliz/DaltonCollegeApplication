package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String studentHome() {
        return "student-home";
    }

    @RequestMapping("/admin")
    public String adminHome() {
        return "admin-home";
    }

    @RequestMapping("/instructor")
    public String instructorHome(){ return "instructor"; }

    @RequestMapping("/classlist")
    public String classList(){ return "listclass"; }

    @RequestMapping("/courselist")
    public String courseList(){ return "listcourses"; }

}
