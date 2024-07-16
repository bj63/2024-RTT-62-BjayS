package com.example.Springboot.database.dao;


import com.example.Springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

        Employee findById(Integer id);


}


