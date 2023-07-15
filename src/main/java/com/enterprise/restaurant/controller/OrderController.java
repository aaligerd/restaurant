package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.Customer;
import com.enterprise.restaurant.model.Employee;
import com.enterprise.restaurant.model.Order;
import com.enterprise.restaurant.model.Packet;
import com.enterprise.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getall")
    public List<Order> getAllOrder(){
        return  orderService.getAllOrder();
    }


}
