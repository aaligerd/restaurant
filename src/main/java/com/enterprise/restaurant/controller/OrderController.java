package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.*;
import com.enterprise.restaurant.service.OrderPriorityService;
import com.enterprise.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderPriorityService orderPriorityService;

    @GetMapping("/getall")
    public List<Order> getAllOrder(){
        return  orderService.getAllOrder();
    }

    @GetMapping("/getbyemp/{empid}")
    public List<Order> getAllOrderByEmpId(@PathVariable("empid") int empid){
        System.out.println(empid);
        return orderService.getOrderByEmpId(empid);
    }

    @PostMapping("/update/status/{id}/{status}")
    public ResponseEntity<String> changeOrderStatus(@PathVariable("id") int id,@PathVariable("status") int statusId  ){
        int num=orderService.updateOrderStatus(id,statusId);
        if(num==1){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Update Done");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Retry");

    }

    @PutMapping("/update/status/{status}")
    public String changeOrderStatusForChef(@PathVariable("status") int statusId  ){
        orderService.updateOrderStatusForChef(statusId);
        return "Done";

    }

    @PostMapping("/create")
    public String getSingleOrder(@RequestBody Order order){
//        System.out.println(order);
        Order o=orderService.saveOrder(order);
        if(o==null)return "Something wrong";
        return "accepted";
    }

    @GetMapping("/getbypriority/{priority}")
    public List<Order> getOrderByPriority(@PathVariable("priority") int id){
        OrderPriority op= orderPriorityService.getOrderPriorityById(id);
        return orderService.getOrderById(op);
    }

    @PutMapping("/update/maker/{orderid}/{makerid}/{statusid}")
    public String updateMaker(@PathVariable("orderid") int orderId,@PathVariable("makerid") int makerId,@PathVariable("statusid") int statusId){
        orderService.upddateMaker(orderId,makerId,statusId);
        return "updated";
    }






}
