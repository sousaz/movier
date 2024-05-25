package com.desafio.backend.repositories;

import com.desafio.backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{
    Users findByUsername(String username);

    Users findById(UUID id);
}
