package com.example.demo.controller;

import com.example.demo.models.CourseClass;
import com.example.demo.repositories.CourseClassRepository;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    CourseClassRepository classes;

    @Autowired
    CourseRepository courses;

    @RequestMapping("/") public String allClasses(Model model){
        model.addAttribute("classes", classes.findAll());
        return "classes/listclass";
    }

    @RequestMapping("/add") public String getAClass(Model model){
        model.addAttribute("aClass", new CourseClass());
        model.addAttribute("courses", courses.findAll());
        return "classes/add";
    }
}
