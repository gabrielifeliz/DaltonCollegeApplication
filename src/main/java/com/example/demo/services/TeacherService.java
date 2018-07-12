package com.example.demo.services;

import com.example.demo.models.CourseClass;
import com.example.demo.models.Instructor;
import com.example.demo.models.Student;
import com.example.demo.repositories.CourseClassRepository;
import com.example.demo.repositories.InstructorRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private Instructor thisTeacher;

    @Autowired
    StudentRepository students;

    @Autowired
    InstructorRepository teachers;

    @Autowired
    CourseClassRepository classes;

    public Iterable<Student> getRosterByClass (Authentication auth, int crn){
        for (CourseClass aClass : getClasses(auth)){
            if (aClass.getCourseNum() == crn){
                return aClass.getStudents();
            }
        }
        return null;
    }

    public Iterable<CourseClass> getClasses (Authentication auth){
        thisTeacher = teachers.findByUsername(auth.getName());
        return thisTeacher.getClasses();
    }

    public CourseClass getClass(Authentication auth, int crn){
        for (CourseClass aClass : getClasses(auth)){
            if (aClass.getCourseNum() == crn){
                return aClass;
            }
        }
        return null;
    }

    public Student assgnGrade(Student stud,String grade){

        stud.setGrade(grade);
        return stud;



}
