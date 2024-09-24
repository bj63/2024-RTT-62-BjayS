package com.pupz.pupz.database.dao;
import com.pupz.pupz.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderDAO extends JpaRepository<Order, Long> {

    // Query to get order details including dog information
    @Query(value = "SELECT o.id AS order_id, " +
            "o.order_date, " +
            "od.quantity_ordered AS quantity, " +
            "d.dog_name AS dog_name, " +
            "d.id AS dog_id, " +
            "d.buy_price AS price, " +
            "(od.quantity_ordered * d.buy_price) AS total " +
            "FROM orderdetails od " +
            "JOIN dogs d ON od.dog_id = d.id " +
            "JOIN orders o ON o.id = od.order_id " +
            "WHERE o.id = :orderId", nativeQuery = true)
    List<Map<String,Object>> getOrderDetails(Integer orderId);

    // Query to get orders for a given user

    // Query to get the total order amount for a given order
    @Query(value = "SELECT SUM(od.quantity_ordered * d.buy_price) AS orderTotal " +
            "FROM orderdetails od " +
            "JOIN dogs d ON od.dog_id = d.id " +
            "JOIN orders o ON o.id = od.order_id " +
            "WHERE o.id = :orderId", nativeQuery = true)
    Double getOrderTotal(Integer orderId);

    // Query to find an order in CART status for a given user
    @Query(value = "SELECT * FROM orders " +
            "WHERE user_id = :userId AND status = 'CART'", nativeQuery = true)
    Order findOrderInCartStatus(Integer userId);

}