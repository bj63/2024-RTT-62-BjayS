package com.Capstone.database.dao;
import com.Capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findById(Integer id);

    // Custom query method to find User by email (assuming you have an email field)
    User findByEmailIgnoreCase(String email);
}
