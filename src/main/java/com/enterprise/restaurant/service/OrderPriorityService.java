package com.enterprise.restaurant.service;

import com.enterprise.restaurant.dao.OrderPriorityDao;
import com.enterprise.restaurant.model.OrderPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderPriorityService {
    @Autowired
    private OrderPriorityDao orderPriorityDao;

    public OrderPriority getOrderPriorityByStatus(String os){
       return orderPriorityDao.findByOrderStatusName(os);
    }

    public OrderPriority getOrderPriorityById(int id){
        return orderPriorityDao.findByOrderPriorityId(id);
    }
}
