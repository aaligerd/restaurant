package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.Packet;
import com.enterprise.restaurant.model.PacketGraph1;
import com.enterprise.restaurant.model.PacketGraph2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacketDao extends JpaRepository<Packet,Integer> {
    @Query(value = "SELECT  COUNT(*) noOrder,date_format(packedtime,\"%Y\") as pkYear,date_format(packedtime,\"%M\") as pkMonth,date_format(packedtime,\"%d\") as pkDate \n" +
            "FROM packet\n" +
            "GROUP BY packedtime limit 30;",nativeQuery = true)
    List<PacketGraph1> getPacketGraph_1_List();


    @Query(value = "SELECT  sum(packetprice) price,date_format(packedtime,\"%Y\") as pkYear,date_format(packedtime,\"%M\") as pkMonth,date_format(packedtime,\"%d\") as pkDate\n" +
            "FROM packet\n" +
            "GROUP BY packedtime limit 30;",nativeQuery = true)
    List<PacketGraph2> getPacketGraph_2_List();
}
