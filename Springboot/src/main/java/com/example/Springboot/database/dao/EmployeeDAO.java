package com.example.Springboot.database.dao;


import com.example.Springboot.database.entity.Employee;
import jakarta.validation.constraints.Future;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

        Employee findById(Integer id);
        List<Employee> findAll(); // Adjust this query as per your actual data model

        Employee findByEmailIgnoreCase(String email);

}


