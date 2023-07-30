package com.enterprise.restaurant.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PacketGraph1 {
    private int no_order;
    private String pk_date;

    public int getNo_order() {
        return no_order;
    }

    public void setNo_order(int no_order) {
        this.no_order = no_order;
    }

    public String getPk_date() {
        return pk_date;
    }

    public void setPk_date(String pk_date) {
        this.pk_date = pk_date;
    }

    public PacketGraph1(int no_order, String pk_date) {
        this.no_order = no_order;
        this.pk_date = pk_date;
    }
}
