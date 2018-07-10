package com.example.demo.repositories;

import com.example.demo.models.authentication.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByUsername(String username);
    boolean existsByUsername(String username);
}