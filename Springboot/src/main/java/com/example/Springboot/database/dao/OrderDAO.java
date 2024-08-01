package com.example.Springboot.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Springboot.database.entity.Order;
import java.util.List;

    @Repository
    public interface OrderDAO extends JpaRepository<Order, Integer> {
    }


