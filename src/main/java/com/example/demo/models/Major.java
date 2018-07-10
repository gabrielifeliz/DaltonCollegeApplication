package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String majorName;

    @ManyToOne
    private Department department;

    @ManyToMany
    public Set<Student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
