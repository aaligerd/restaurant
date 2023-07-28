package com.enterprise.restaurant.service;

import com.enterprise.restaurant.dao.CustomerDao;
import com.enterprise.restaurant.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomer(){
        return customerDao.findAll();
    }

    public Customer createCustomer(Customer customer) {
        Customer c=customerDao.findByCphone(customer.getCphone());
        if(c==null)
        return  customerDao.save(customer);

        return c;
    }
}
