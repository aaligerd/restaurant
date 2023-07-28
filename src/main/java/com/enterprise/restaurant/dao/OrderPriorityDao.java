package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.OrderPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPriorityDao extends JpaRepository<OrderPriority,Integer> {
    OrderPriority findByOrderStatusName(String orderStatus);
    OrderPriority findByOrderPriorityId(int id);
}
