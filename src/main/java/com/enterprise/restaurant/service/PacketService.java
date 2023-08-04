package com.enterprise.restaurant.service;

import com.enterprise.restaurant.dao.PacketDao;
import com.enterprise.restaurant.model.Packet;
import com.enterprise.restaurant.model.PacketGraph1;
import com.enterprise.restaurant.model.PacketGraph2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PacketService {
    @Autowired
    private PacketDao packetDao;

    public List<Packet> getAllPacket(){
        return this.packetDao.findAll();
    }

    public Packet createPacket(Packet packet) {
        return packetDao.save(packet);
    }

    public  List<PacketGraph1> getPacketGraph1(){
        return  packetDao.getPacketGraph_1_List();
    }

    public  List<PacketGraph2> getPacketGraph2(){
        List<PacketGraph2> p2=(List<PacketGraph2>) packetDao.getPacketGraph_2_List();

        return  p2;
    }
}
