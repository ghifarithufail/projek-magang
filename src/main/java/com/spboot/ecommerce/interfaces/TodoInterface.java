/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.interfaces;

import com.spboot.ecommerce.models.Todo;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface TodoInterface {
    List<Todo> getAll();
    void store(Todo todo);
    Todo getById(long id);
    void delete(long id);
    List<Todo> findByUserId(long user_id);
}
