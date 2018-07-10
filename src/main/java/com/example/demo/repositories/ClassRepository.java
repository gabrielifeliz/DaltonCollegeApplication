package com.example.demo.repositories;

import com.example.demo.models.CourseClass;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<CourseClass, Long> {
}
