package com.example.springboot3jwtauthenticationserver.repositories;

import com.example.springboot3jwtauthenticationserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find specific resource by email
     */
    @Query(value = "SELECT * FROM users as user WHERE user.email=?1 LIMIT 1", nativeQuery = true)
    Optional<User> findOneByEmail(String email);

    /**
     * Find specific resource by unique email
     */
    @Query(value = "SELECT * FROM users as user WHERE user.id!=?1 AND user.email=?2 LIMIT 1", nativeQuery = true)
    Optional<User> findUniqueEmail(Long id, String email);
}
