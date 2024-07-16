package com.example.Springboot.database.dao;
import com.example.Springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    // Method to find customers by their name (case-insensitive and partial match)
    List<Customer> findByCustomerNameContainingIgnoreCase(String customerName);

    List<Customer> findByEmployeeId(Integer employeeId);

    List<Customer> findBySalesRepEmployeeId(Integer id);
    // You can add more custom query methods as needed based on your application's requirements
}

