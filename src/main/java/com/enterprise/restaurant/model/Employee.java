package com.enterprise.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;


import java.sql.Date;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;
    @Column(name = "empname")
    private String empname;

    @Column(name = "empemail")
    private String empemail;

    @Column(name = "empassword")
    private String empassword;


    @Column(name = "empdob")
    private String empdob;
    @Column(name = "empstartdate")
    private  String empstartdate;
    @Column(name = "emplastdate")
    private  String emplastdate;
    @Column(name = "empaadhaarno")
    private long empaadhaarno;
    @Column(name = "empjobrole")
    private String empjobrole;

    public Employee() {
    }

    public Employee(int empid, String empname, String empdob, String empstartdate, String emplastdate, long empaadhaarno, String empjobrole) {
        this.empid = empid;
        this.empname = empname;
        this.empdob = empdob;
        this.empstartdate = empstartdate;
        this.emplastdate = emplastdate;
        this.empaadhaarno = empaadhaarno;
        this.empjobrole = empjobrole;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpdob() {
        return empdob;
    }

    public void setEmpdob(String empdob) {
        this.empdob = empdob;
    }

    public String getEmpstartdate() {
        return empstartdate;
    }

    public void setEmpstartdate(String empstartdate) {
        this.empstartdate = empstartdate;
    }

    public String getEmplastdate() {
        return emplastdate;
    }

    public void setEmplastdate(String emplastdate) {
        this.emplastdate = emplastdate;
    }

    public long getEmpaadhaarno() {
        return empaadhaarno;
    }

    public void setEmpaadhaarno(long empaadhaarno) {
        this.empaadhaarno = empaadhaarno;
    }

    public String getEmpjobrole() {
        return empjobrole;
    }

    public void setEmpjobrole(String empjobrole) {
        this.empjobrole = empjobrole;
    }
}
