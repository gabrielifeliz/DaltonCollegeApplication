package com.example.demo.controller;

import com.example.demo.models.Department;
import com.example.demo.models.Major;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class TestController {
    @Autowired
    DepartmentRepository dpmnts;

    @Autowired
    MajorRepository majors;

    @PostConstruct() public void majors() {
        Major major = new Major();
        major.setMajorName("Computer Engineering");
        majors.save(major);

        major = new Major();
        major.setMajorName("Computer Science");
        majors.save(major);

        major = new Major();
        major.setMajorName("Computer Design");
        majors.save(major);
    }
    @PostConstruct() public void departments(){
        Department dpmnt = new Department();
        dpmnt.setDepartmentName("Humanities");
        dpmnts.save(dpmnt);

        dpmnt = new Department();
        dpmnt.setDepartmentName("Science");
        dpmnts.save(dpmnt);
    }

}
