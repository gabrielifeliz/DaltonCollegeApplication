package com.example.demo.repositories;

import com.example.demo.models.authentication.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByRole(String role);
    Iterable<UserRole> findAllByRoleAndRole(String role, String anotherRole);
}