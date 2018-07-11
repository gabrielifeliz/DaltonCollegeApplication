package com.example.demo.repositories;

import com.example.demo.models.Major;
import org.springframework.data.repository.CrudRepository;

public interface MajorRepository extends CrudRepository<Major, Long> {
}