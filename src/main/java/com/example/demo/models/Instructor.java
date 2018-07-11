package com.example.demo.models;

import com.example.demo.models.authentication.AppUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instructor extends AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int employeeNum;

    private String department;

    private int officeNum;

    @OneToMany
    private Set<CourseClass> classes;

    public Instructor(){
        classes = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }

    public Set<CourseClass> getClasses() {
        return classes;
    }

    public void setClasses(Set<CourseClass> classes) {
        this.classes = classes;
    }
}
