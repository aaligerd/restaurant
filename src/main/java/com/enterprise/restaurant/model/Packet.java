package com.enterprise.restaurant.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Packet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packetno;
    private String packeditems;
    private String totalitems;
    private int packetprice;


    public Packet() {
    }

    public Packet(int packetno, String packeditems, String totalitems, int packetprice) {
        this.packetno = packetno;
        this.packeditems = packeditems;
        this.totalitems = totalitems;
        this.packetprice = packetprice;
    }

    public int getPacketno() {
        return packetno;
    }

    public void setPacketno(int packetno) {
        this.packetno = packetno;
    }

    public String getPackeditems() {
        return packeditems;
    }

    public void setPackeditems(String packeditems) {
        this.packeditems = packeditems;
    }

    public String getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(String totalitems) {
        this.totalitems = totalitems;
    }

    public int getPacketprice() {
        return packetprice;
    }

    public void setPacketprice(int packetprice) {
        this.packetprice = packetprice;
    }
}
