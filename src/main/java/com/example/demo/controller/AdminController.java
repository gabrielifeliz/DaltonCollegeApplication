package com.example.demo.controller;

import com.example.demo.models.Instructor;
import com.example.demo.models.Student;
import com.example.demo.repositories.CourseClassRepository;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.InstructorRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    InstructorRepository teachers;
    @Autowired
    CourseClassRepository courseClassRepository;

    @Autowired
    StudentRepository students;

    @Autowired
    AdminService adminService;

    @Autowired
    DepartmentRepository dpmnts;

    @RequestMapping("/")
    public String adminHome() {
        return "admin/admin-home";
    }

    @RequestMapping("/students") public String allStudents(Model model){
        model.addAttribute("students", students.findAll());
        return "admin/liststudents";
    }

    @RequestMapping("/upgrade/{id}") public String upgradeToTeacher(@PathVariable("id") long id, Model model){
//        Instructor newTeacher = adminService.studentToTeacher(students.findById(id).get(), new Instructor());
        Student student = students.findById(id).get();
        model.addAttribute("newTeacher", adminService.studentToTeacher(student));
        model.addAttribute("dpmnts", dpmnts.findAll());
        students.delete(student);
        return "admin/addteacher";
    }
    @PostMapping("/saveTeacher") public String saveTeacher(@ModelAttribute Instructor instructor){
        teachers.save(instructor);
        return "redirect:/admin/students";
    }
}
