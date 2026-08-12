package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.Entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @EntityGraph(attributePaths = "Roles")
    Optional<User> findByUserName(String userName);
}
