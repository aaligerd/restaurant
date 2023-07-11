package com.enterprise.restaurant.service;

import com.enterprise.restaurant.dao.EmpDao;
import com.enterprise.restaurant.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpDao empdao;

    public Employee addEmp(Employee employee){
        Employee e=empdao.save(employee);
        return e;
    }


    public Optional<Employee> findEmpById(int id){

        Optional<Employee> employe = empdao.findById(id);
        return  employe;

    }


    public List<Employee> getAllEmp(){
        List<Employee> employees=  empdao.findAll();
        return  employees;
    }

    public List<Employee> findByRole(String role) {
        List<Employee> employee= empdao.findByEmpjobrole(role);
        return employee;
    }
}
