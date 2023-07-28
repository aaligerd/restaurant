package com.enterprise.restaurant.model;

import com.enterprise.restaurant.service.EmpService;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderno;

    @OneToOne
    @JoinColumn(name = "packetno")
    private Packet packet;

    @OneToOne
    @JoinColumn(name = "empid")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "cid")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_priority")
    private OrderPriority orderPriority;


    public Order(int orderno, Packet packet, Employee employee, Customer customer, OrderPriority orderPriority) {
        this.orderno = orderno;
        this.packet = packet;
        this.employee = employee;
        this.customer = customer;
        this.orderPriority = orderPriority;
    }

    public Order() {
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderPriority getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(OrderPriority orderPriority) {
        this.orderPriority = orderPriority;
    }
}
