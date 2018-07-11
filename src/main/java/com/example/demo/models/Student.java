package com.example.demo.models;

import com.example.demo.models.authentication.AppUser;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student extends AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentNum;

    private int entryYear;

    @ManyToMany
    private Set<CourseClass> classes;

    @ManyToMany
    private Set<Major> majors;

    public long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(long studentNum) {
        this.studentNum = studentNum;
    }

    public int getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(int entryYear) {
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
