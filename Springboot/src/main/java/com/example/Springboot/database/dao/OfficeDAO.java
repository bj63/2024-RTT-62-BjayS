package com.example.Springboot.database.dao;
import com.example.Springboot.database.entity.Office;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface OfficeDAO extends JpaRepository<Office, Long> {

    Office findById(Integer id);

    List<Office> findAll();}