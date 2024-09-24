package com.Capstone.database.dao;
import com.Capstone.database.entity.DogProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogProfileDAO extends JpaRepository<DogProfile, Long> {

    DogProfile findById(Integer id);

    // Custom query method to find DogProfiles by a specific attribute (e.g., name)
    List<DogProfile> findByNameIgnoreCase(String name);
}

