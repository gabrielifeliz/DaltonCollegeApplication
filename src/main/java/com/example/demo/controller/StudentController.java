package com.example.demo.controller;

import com.example.demo.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    ClassRepository classes;

    @RequestMapping("/")
    public String studentHome() {
        return "student-home";
    }

    @RequestMapping("/enroll")
    public String enrollInClass() {
        return "enrollclass";
    }

    @RequestMapping("/drop/{id}")
    public String dropClass() {
        //classes.deleteBy();
        return "redirect:/";
    }

    @RequestMapping("transcript/unofficial")
    public String unofficialTranscript() {
        return "unofficialtranscript";
    }

    @RequestMapping("transcript/official")
    public String officialTranscript() {
        return "officialtranscript";
    }

    @RequestMapping("/allcourses")
    public String showAllCourses() {
        return "listcourses";
    }

    @RequestMapping("allclasses")
    public String classInCurrentSemester() {
        return "listclasses";
    }

}
