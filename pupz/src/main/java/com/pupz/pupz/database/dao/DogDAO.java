package com.pupz.pupz.database.dao;

import com.pupz.pupz.database.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogDAO extends JpaRepository<Dog, Long> {
    // Correct method signature for finding by ID with Long type
    Optional<Dog> findById(Long id);
}