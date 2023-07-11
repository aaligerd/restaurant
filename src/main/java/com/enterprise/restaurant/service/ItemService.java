package com.enterprise.restaurant.service;

import com.enterprise.restaurant.dao.ItemDao;
import com.enterprise.restaurant.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    public List<Item> getMenu(){
        List<Item> items= itemDao.findAll();
        return items;
    }

    public List<Item> getItemByCategory(String category){
        List<Item> items=itemDao.findByItemcategory(category);
        return  items;
    }
}
