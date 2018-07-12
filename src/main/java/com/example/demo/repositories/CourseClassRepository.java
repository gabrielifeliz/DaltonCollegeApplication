package com.example.demo.repositories;

import com.example.demo.models.Course;
import com.example.demo.models.CourseClass;
import org.springframework.data.repository.CrudRepository;

public interface CourseClassRepository extends CrudRepository<CourseClass, Long> {
    Course findAllByCourse(Course course);
}
