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

    @ManyToOne
    private Instructor instructor;

    @ManyToOne
    private Classroom classroom;

    @ManyToOne
    private Course course;

    @ManyToMany
    private Set<Student> students;

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
        return course.getCourseNum();
    }

    public String getSubjectCode() {
        return course.getSubjectCode();
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
