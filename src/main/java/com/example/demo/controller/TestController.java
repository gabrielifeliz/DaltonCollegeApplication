package com.example.demo.controller;

import com.example.demo.models.Major;
import com.example.demo.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class TestController {


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

}
