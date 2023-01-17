/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.interfaces;

import com.spboot.ecommerce.models.Item;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ItemInterface {
    List<Item> getAll();
    void store(Item item);
    Item getById(long id);
    void delete(long id);
}
