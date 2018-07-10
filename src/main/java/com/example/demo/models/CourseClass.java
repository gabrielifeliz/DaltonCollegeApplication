package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class CourseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String crn;

    private int courseNum;

    private String subjectCode;

    @ManyToOne
    private Instructor instructor;

    @ManyToOne
    private Classroom classroom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom ;
    }
}
