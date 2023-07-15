package com.enterprise.restaurant.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.enterprise.restaurant.dao.EmpDao;
import com.enterprise.restaurant.model.EmpCredential;
import com.enterprise.restaurant.model.Employee;
import com.enterprise.restaurant.security.BCryptHandler;
import com.enterprise.restaurant.security.JwtHandler;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    private static final String saltForPasswordEnc="thisisasalt12345";
    private static  final int costOfenc=10;
    @Autowired
    private EmpDao empdao;


    //use to save employee data
    public Employee addEmp(Employee employee){
        Employee e=empdao.save(employee);
        return e;
    }

    //use to find employee by id
    public Optional<Employee> findEmpById(int id){

        Optional<Employee> employe = empdao.findById(id);
        return  employe;

    }


    //use to get all epmloyee data
    public List<Employee> getAllEmp(){
        List<Employee> employees=  empdao.findAll();
        return  employees;
    }

    //use to get employee data by job role
    public List<Employee> findByRole(String role) {
        List<Employee> employee= empdao.findByEmpjobrole(role);
        return employee;
    }

    public Employee getEmpByEmail(String email){
        Employee e=empdao.findByEmpemail(email);
        return e;
    }


    //use to get data of a signle employee by email and password
    public Employee getEmpByEmail(EmpCredential empCredential, HttpServletResponse response){
        Employee e= empdao.findByEmpemail(empCredential.getEmail());
        //return null if the e is null;
        if(e==null){
            return null;
        }
        BCrypt.Result result= BCryptHandler.verificationResult(empCredential.getPassword().getBytes(),e.getEmpassword().getBytes());
        if(result.verified){
//           String payload="{\"email\":\""+e.getEmpemail()+"\"}";
            String payload_email=e.getEmpemail();
            int payload_id=e.getEmpid();
            String payload_jobrole=e.getEmpjobrole();
            String token = JwtHandler.genToken(payload_id,payload_email,payload_jobrole);
            Cookie cookie=new Cookie("mytoken",token);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setMaxAge(30);
            response.addCookie(cookie);
            return e;
        }
        else {
            return null;
        }
    }

    public Integer updatePasswordByEmail(String email,String password){
        String hashedpass= BCryptHandler.createHash(password);
        return empdao.findByEmpemailAndUpdateEmpassword(email,hashedpass);
    }
}
