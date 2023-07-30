package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.Packet;
import com.enterprise.restaurant.model.PacketGraph1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacketDao extends JpaRepository<Packet,Integer> {
    @Query(value = "SELECT  COUNT(*) no_order,packedtime pk_date\n" +
            "FROM packet\n" +
            "GROUP BY packedtime desc limit 30;",nativeQuery = true)
    List<PacketGraph1> getPacketGraph_1_List();
}
