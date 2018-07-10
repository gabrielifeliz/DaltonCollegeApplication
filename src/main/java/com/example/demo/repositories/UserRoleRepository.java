package com.example.demo.models.authentication.repositories;

import com.example.demo.models.authentication.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByRole(String role);
}