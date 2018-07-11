package com.example.demo.controller;

import com.example.demo.models.Major;
import com.example.demo.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class TestController {
    @RequestMapping(value={"", "/"})
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

    @RequestMapping("/addstudent")
    public String addStudent() {
        return "students/add";
    }

    @RequestMapping("/addinstructor")
    public String addInstructor() {
        return "instructors/add";
    }

    @RequestMapping("/studentlist")
    public String studentList() {
        return "students/list";
    }


    @Autowired
    MajorRepository majors;

    @PostConstruct() public void majors() {
        Major major = new Major();
        major.setMajorName("Computer Engineering");
        majors.save(major);

        major = new Major();
        major.setMajorName("Computer Science");
        majors.save(major);

        major = new Major();
        major.setMajorName("Computer Design");
        majors.save(major);


    }

}
