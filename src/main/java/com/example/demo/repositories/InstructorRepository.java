package com.example.demo.repositories;

import com.example.demo.models.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findByUsername(String username);
}