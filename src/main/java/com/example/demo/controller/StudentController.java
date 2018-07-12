package com.example.demo.controller;

import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.repositories.AppUserRepository;
import com.example.demo.repositories.CourseClassRepository;
import com.example.demo.repositories.MajorRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    AppUserRepository users;

    @Autowired
    StudentRepository students;

    @Autowired
    CourseClassRepository classes;

    @Autowired
    MajorRepository majors;

    @RequestMapping("/")
    public String studentHome() {
        return "students/student-home";
    }

    @GetMapping("/add") public String getStudent(Authentication authentication, Model model){
        Student student = students.findByUsername(authentication.getName());
        model.addAttribute("student", student);
        model.addAttribute("majors", majors.findAll());
        return "students/add";
    }@PostMapping("/add") public String saveStudent(@ModelAttribute("student") Student student){
        users.save(student);
        students.save(student);
        return "redirect:/students/";
    }

    @GetMapping("/enroll")
    public String enrollInClass(Model model, @ModelAttribute("user")Student student) {
        model.addAttribute("student", student);
        model.addAttribute("classes", classes.findAll());
        return "/students/enrollclass";
    }

    @PostMapping("/enroll")
    public String processEnrollment(@ModelAttribute("student") Student student){
        students.save(student);
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
