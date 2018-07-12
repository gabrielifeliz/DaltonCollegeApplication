package com.example.demo.models;

import com.example.demo.models.authentication.AppUser;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Entity
public class Student extends AppUser {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentNum;

    private Year entryYear;

    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @ManyToMany
    private Set<CourseClass> classes;

    @ManyToMany
    private Set<Major> majors;

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public Year getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(Year entryYear) {
        this.entryYear = entryYear;
    }

    public Set<CourseClass> getClasses() {
        return classes;
    }

    public void setClasses(Set<CourseClass> classes) {
        this.classes = classes;
    }

    public Set<Major> getMajors() {
        return majors;
    }

    public void setMajors(Set<Major> majors) {
        this.majors = majors;
    }
}
