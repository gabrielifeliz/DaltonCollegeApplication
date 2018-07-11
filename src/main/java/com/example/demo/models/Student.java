package com.example.demo.models;

import com.example.demo.models.authentication.AppUser;

import javax.persistence.*;
import java.time.Year;
import java.time.YearMonth;
import java.util.Set;

@Entity
public class Student extends AppUser {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentNum;

    private String studentName;

    private Year entryYear;

    @ManyToMany
    private Set<CourseClass> classes;

    @ManyToMany
    private Set<Major> majors;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

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
