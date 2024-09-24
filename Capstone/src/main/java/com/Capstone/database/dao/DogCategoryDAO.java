package com.Capstone.database.dao;

import com.Capstone.database.entity.DogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogCategoryDAO extends JpaRepository<DogCategory, Long> {

    DogCategory findById(Integer id);

    // Custom query method to find DogCategory by name
    DogCategory findByNameIgnoreCase(String name);
}