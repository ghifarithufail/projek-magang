/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.services;

import com.spboot.ecommerce.interfaces.OrderInterface;
import com.spboot.ecommerce.models.Order;
import com.spboot.ecommerce.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class OrderService implements OrderInterface {

    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void store(Order order) {
        this.orderRepository.save(order);
    }
    
    @Override
public Order getById(long id) {
  Optional < Order > optional = orderRepository.findById(id);

  if (!optional.isPresent()) {
    throw new RuntimeException(" Todo not found for id :: " + id);
  }

  Order order = optional.get();
  return order;
}

@Override
public void delete(long id) {
  this.orderRepository.deleteById(id);
}
}
