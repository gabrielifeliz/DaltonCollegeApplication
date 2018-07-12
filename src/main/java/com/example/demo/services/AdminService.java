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

    public Instructor studentToTeacher(Student student, Instructor teacher){
        AppUser user = student;
        AppUser morphedUser = teacher;

        morphedUser.setId(user.getId());
        morphedUser.setFullName(user.getFullName());
        morphedUser.setUsername(user.getUsername());
        morphedUser.setPassword(user.getPassword());
        morphedUser.addRole(roles.findByRole("TEACHER"));

        students.delete((Student)user);
        teachers.save((Instructor)morphedUser);

        return (Instructor) morphedUser;
    }
}
