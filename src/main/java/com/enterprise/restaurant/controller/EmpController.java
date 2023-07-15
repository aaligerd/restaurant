package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.EmailDetails;
import com.enterprise.restaurant.model.EmpCredential;
import com.enterprise.restaurant.model.Employee;
import com.enterprise.restaurant.security.JwtHandler;
import com.enterprise.restaurant.service.EmailServiceImpl;
import com.enterprise.restaurant.service.EmpService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/epmloyee")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmailServiceImpl emailService;


    //use to retrive all emp data
    @GetMapping("/getemp")
    public List<Employee> getAllEmployee(@CookieValue("mytoken") String token){

        String s = JwtHandler.verifyToken(token);
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


    //use to employe login
    @PostMapping("/login")
    public ResponseEntity<Employee> empLogIn(@RequestBody EmpCredential empCredential, HttpServletResponse response){
        Employee e= empService.getEmpByEmail(empCredential,response);

        if(e==null){
            Cookie cookie1=new Cookie("mytoken",null);
            Cookie cookie2=new Cookie("status","false");
            cookie1.setMaxAge(0);
            response.addCookie(cookie1);
            response.addCookie(cookie2);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Employee());
        }
        Cookie cookie2=new Cookie("status","true");
        response.addCookie(cookie2);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }

    @PostMapping("/forgetpass/sendopt/{email}/{otp}")
    public String sendOtp(@PathVariable("email") String email,@PathVariable("otp") Integer otp){

        EmailDetails emailDetails=new EmailDetails();
        emailDetails.setRecipient(email);
        emailDetails.setSubject("OTP for Password change");
        String mailBody="Use that OTP to change your password in Restaurant App \n OTP:"+otp;
        emailDetails.setMsgBody(mailBody);
        return emailService.sendSimpleMail(emailDetails);

    }

     @PostMapping("/password/newpassword")
     public ResponseEntity<Integer> setPassword(@RequestParam("email") String email,@RequestParam("password") String password){
        Employee e=empService.getEmpByEmail(email);
        if(e!=null){
            int res= empService.updatePasswordByEmail(email,password);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);

     }


}
