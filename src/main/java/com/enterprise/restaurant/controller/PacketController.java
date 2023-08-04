package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.Packet;
import com.enterprise.restaurant.model.PacketGraph1;
import com.enterprise.restaurant.model.PacketGraph2;
import com.enterprise.restaurant.service.PacketService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/packet")
public class PacketController {
    @Autowired
    private PacketService packetService;

    @GetMapping("/getall")
    public List<Packet> getAllPacket(){
        return packetService.getAllPacket();
    }


    @PostMapping("/create")
    public ResponseEntity<Packet> createPacket(@RequestBody Packet packet){
        Packet packet1= packetService.createPacket(packet);
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(packet1);
    }
    @GetMapping("/manager/packet/1")
    public List<PacketGraph1> getPacketGraph1(){
        return packetService.getPacketGraph1();
    }


    @GetMapping("/manager/packet/2")
    public List<PacketGraph2> getPacketGraph2(){
        return packetService.getPacketGraph2();
    }
}
