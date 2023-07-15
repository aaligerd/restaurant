package com.enterprise.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String cname;
    private String cphone;



    public Customer() {
    }

    public Customer(int cid, String cname, String cphone) {
        this.cid = cid;
        this.cname = cname;
        this.cphone = cphone;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }
}
