package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.Employee;
import com.enterprise.restaurant.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/epmloyee")
public class EmpController {
    @Autowired
    private EmpService empService;


    //use to retrive all emp data
    @GetMapping("/getemp")
    public List<Employee> getAllEmployee(){
        return empService.getAllEmp();
    }

    //use to add employee data
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return empService.addEmp(employee);
    }


    //use to retrive employee data by empid
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmpById(@PathVariable("id") int id){
        return empService.findEmpById(id);
    }

    //use to retrive employee data by empjobrole
    @GetMapping("/get/role/{role}")
    public List<Employee> getEmpByRole(@PathVariable("role") String role){
        return empService.findByRole(role);
    }
}
