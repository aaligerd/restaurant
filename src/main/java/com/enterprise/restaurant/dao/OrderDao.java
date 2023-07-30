package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.Order;
import com.enterprise.restaurant.model.OrderPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE orders SET order_priority = ?2 WHERE orderno = ?1",nativeQuery = true)
    Integer changeOrderStatusById(int id, int statusId);

    List<Order> findOrderByOrderPriority(OrderPriority orderPriority);

    @Transactional
    @Modifying
    @Query(value = "UPDATE orders SET order_priority = 3,emp_madeby=?2,order_priority=?3 WHERE orderno = ?1",nativeQuery = true)
    void updateMakerById(int orderId, int makerId,int statusId);

    @Query(value = "SELECT * FROM orders WHERE emp_madeby=?1 and order_priority=3",nativeQuery = true)
    List<Order> findOrderByEmpId(int empid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE orders SET order_priority = 2,emp_madeby=-1 WHERE orderno = ?1",nativeQuery = true)
    void updateOrderForChef(int statusId);


}
