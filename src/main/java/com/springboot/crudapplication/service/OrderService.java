package com.springboot.crudapplication.service;

import com.springboot.crudapplication.model.Order;

import java.util.Set;

public interface OrderService {
    Order save(Order obj);
    Set<Order> findAll();
    Order findById(Long id);
    void deleteOrder(Long id);
    String findUser(Long id);
}
