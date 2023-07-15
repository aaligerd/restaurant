package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.Packet;
import com.enterprise.restaurant.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/packet")
public class PacketController {
    @Autowired
    private PacketService packetService;

    @GetMapping("/getall")
    public List<Packet> getAllPacket(){
        return packetService.getAllPacket();
    }
}
