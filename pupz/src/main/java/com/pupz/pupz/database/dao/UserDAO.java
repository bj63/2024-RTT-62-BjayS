package com.pupz.pupz.database.dao;

import com.pupz.pupz.database.entity.Dog;
import com.pupz.pupz.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UserDAO extends JpaRepository<User, Long> {
    User findByEmailIgnoreCase(String email);
// Custom query method using @Query
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
    }

