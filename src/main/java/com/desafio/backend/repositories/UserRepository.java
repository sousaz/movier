package com.desafio.backend.repositories;

import com.desafio.backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    Users findByUsername(String username);

}
