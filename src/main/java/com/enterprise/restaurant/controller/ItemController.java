package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.Item;
import com.enterprise.restaurant.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/menu")
    public List<Item> getMenu(){
        return itemService.getMenu();
    }

    @GetMapping("/menu/category/{category}")
    public List<Item> getMenuByCategory(@PathVariable("category") String category){
        return itemService.getItemByCategory(category);
    }

}
