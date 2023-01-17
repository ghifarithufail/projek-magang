/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.services;

import com.spboot.ecommerce.interfaces.TodoInterface;
import com.spboot.ecommerce.models.Todo;
import com.spboot.ecommerce.repositories.TodoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class TodoService implements TodoInterface {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
    
    @Override
    public List<Todo> findByUserId(long user_id) {
        return todoRepository.findByUserId(user_id);
    }

    @Override
    public void store(Todo todo) {
        this.todoRepository.save(todo);
    }

    @Override
    public Todo getById(long id) {
        Optional< Todo> optional = todoRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RuntimeException(" Todo not found for id :: " + id);
        }

        Todo todo = optional.get();
        return todo;
    }

    @Override
    public void delete(long id) {
        this.todoRepository.deleteById(id);
    }
}
