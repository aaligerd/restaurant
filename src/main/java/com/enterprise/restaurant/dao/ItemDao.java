package com.enterprise.restaurant.dao;

import com.enterprise.restaurant.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDao extends JpaRepository<Item,Integer> {

    List<Item> findByItemcategory(String category);
}
