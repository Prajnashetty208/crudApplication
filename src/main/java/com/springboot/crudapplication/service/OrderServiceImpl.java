package com.springboot.crudapplication.service;

import com.springboot.crudapplication.exception.OrderNotFoundException;
import com.springboot.crudapplication.model.Order;
import com.springboot.crudapplication.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private Repository repo;

    @Override
    public Order save(Order obj) {
        return this.repo.save(obj);
    }

    @Override
    public Set<Order> findAll() {
        return new HashSet<>(this.repo.findAll());
    }

    @Override
    public Order findById(Long id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    @Override
    public void deleteOrder(Long id) {
        this.repo.deleteById(id);
    }

}
