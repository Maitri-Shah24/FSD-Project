package com.example.twitterbackend.repository;

import com.example.twitterbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>
{
    public User findByEmail(String email);
    @Query("SELECT DISTINCT u FROM User u WHERE u.fullName LIKE %:query% OR u.email LIKE %:query%")
    public List<User> searchuser(@Param("query")String query);
}
