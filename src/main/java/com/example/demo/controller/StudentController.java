package com.example.demo.controller;

import com.example.demo.models.Course;
import com.example.demo.repositories.CourseClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    CourseClassRepository classes;

    @RequestMapping("/")
    public String studentHome() {
        return "student-home";
    }

    @GetMapping("/enroll")
    public String enrollInClass() {
        return "enrollclass";
    }

    @PostMapping("/enroll")
    public String processEnrollment(@ModelAttribute("course") Course course, Model model){

        model.addAttribute("classes", classes.findAllByCourse(course));
        return "redirect:/";
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
