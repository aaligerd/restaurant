package com.enterprise.restaurant.service;

import com.enterprise.restaurant.dao.OrderDao;
import com.enterprise.restaurant.model.Order;
import com.enterprise.restaurant.model.OrderPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getAllOrder(){
        return orderDao.findAll();
    }
    public Order saveOrder(Order order){
        return orderDao.save(order);
    }

    public Integer updateOrderStatus(int id, int statusId) {
        return orderDao.changeOrderStatusById(id,statusId);
    }

    public List<Order> getOrderById(OrderPriority orderPriority){
        return  orderDao.findOrderByOrderPriority(orderPriority);
    }
}
