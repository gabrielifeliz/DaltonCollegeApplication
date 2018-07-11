package com.example.demo.controller;

import com.example.demo.models.CourseClass;
import com.example.demo.repositories.CourseClassRepository;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    CourseClassRepository courseClassRepository;

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/viewclass")
    public String viewClassInCurrentSem(Model model){
        return "viewclass";
    }

    @RequestMapping("/getroster")
    public String getRosterOfStud(@ModelAttribute("courseClasses")CourseClass courseClass, Model model, Authentication auth){
        model.addAttribute("roster", teacherService.getRosterByClass(auth, 53489));
        return "";
    }
}
