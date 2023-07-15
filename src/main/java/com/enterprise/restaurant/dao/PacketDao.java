package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.Packet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacketDao extends JpaRepository<Packet,Integer> {
}
