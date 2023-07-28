package com.enterprise.restaurant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_priority_tbl")
public class OrderPriority {
    @Id
    @Column(name = "order_priority_id")
    private int orderPriorityId;

    @Column(name = "order_status_name")
    private String orderStatusName;

    @Column(name="order_priority")
    private int orderPriority;

    public OrderPriority() {
    }

    public OrderPriority(int orderPriorityId, String orderStatusName, int orderPriority) {
        this.orderPriorityId = orderPriorityId;
        this.orderStatusName = orderStatusName;
        this.orderPriority = orderPriority;
    }

    public int getOrderPriorityId() {
        return orderPriorityId;
    }

    public void setOrderPriorityId(int orderPriorityId) {
        this.orderPriorityId = orderPriorityId;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public int getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(int orderPriority) {
        this.orderPriority = orderPriority;
    }
}
