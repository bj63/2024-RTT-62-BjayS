package com.example.Springboot.database.dao;


import com.example.Springboot.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {


    User findByEmailIgnoreCase(String email);

}