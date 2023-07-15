package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.Employee;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmpDao extends JpaRepository<Employee,Integer> {

    List<Employee> findByEmpjobrole(String role);
    Employee findByEmpemail(String eamil);


    @Transactional
    @Modifying
    @Query(value = "update employee set empassword=?2 where empemail=?1", nativeQuery = true)
    Integer findByEmpemailAndUpdateEmpassword(String email,String password);
}
