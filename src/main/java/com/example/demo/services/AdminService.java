package com.example.demo.services;

import com.example.demo.models.Instructor;
import com.example.demo.models.Student;
import com.example.demo.models.authentication.AppUser;
import com.example.demo.repositories.InstructorRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    UserRoleRepository roles;

    @Autowired
    InstructorRepository teachers;

    @Autowired
    StudentRepository students;

    public Instructor studentToTeacher(Student student){
        AppUser user = student;
        AppUser morphedUser = new Instructor();

        morphedUser.setFullName(user.getFullName());
        morphedUser.setUsername(user.getUsername());
        morphedUser.setPassword("pass");
        morphedUser.addRole(roles.findByRole("TEACHER"));

        return (Instructor)morphedUser;
    }
}
