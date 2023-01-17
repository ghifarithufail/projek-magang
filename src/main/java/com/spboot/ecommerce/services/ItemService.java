/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.services;

import com.spboot.ecommerce.interfaces.ItemInterface;
import com.spboot.ecommerce.models.Item;
import com.spboot.ecommerce.repositories.ItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class ItemService implements ItemInterface {

    @Autowired
    private ItemRepository itemRepository;
    
    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public void store(Item item) {
        this.itemRepository.save(item);
    }
    
    @Override
    public Item getById(long id) {
        Optional< Item> optional = itemRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RuntimeException(" Item not found for id :: " + id);
        }

        Item item = optional.get();
        return item;
    }

    @Override
    public void delete(long id) {
        this.itemRepository.deleteById(id);
}
}
