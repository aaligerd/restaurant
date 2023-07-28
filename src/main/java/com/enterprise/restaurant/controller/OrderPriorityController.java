package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.OrderPriority;
import com.enterprise.restaurant.service.OrderPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderpriority")
@CrossOrigin("*")
public class OrderPriorityController {

    @Autowired
    OrderPriorityService orderPriorityService;


    @GetMapping("status/{status}")
    public OrderPriority getOrderPriorityByStatusName(@PathVariable("status") String status){
        return orderPriorityService.getOrderPriorityByStatus(status);
    }
}
