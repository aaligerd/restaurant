package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.Employee;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao extends JpaRepository<Employee,Integer> {

    List<Employee> findByEmpjobrole(String role);
}
