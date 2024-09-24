package com.pupz.pupz.database.dao;

import com.pupz.pupz.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailsDAO extends JpaRepository<OrderDetail, Long> {

    @Query(value = "select * from orderdetails where order_id = :orderId and dog_id = :dogId", nativeQuery = true)
    OrderDetail isDogInCart(Integer orderId, Integer dogId);
}
