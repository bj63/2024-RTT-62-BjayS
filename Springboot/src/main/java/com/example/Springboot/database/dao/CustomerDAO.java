package com.example.Springboot.database.dao;
import com.example.Springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.Springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    List<Customer> findBySalesRepEmployeeId(Integer id);
    @Query ("select c from Customer c where c.customerName like concat('%', :search, '%') ")
    List<Customer> findByNameOrId(String search);}
