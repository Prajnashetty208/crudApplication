package com.springboot.crudapplication.control;

import com.springboot.crudapplication.model.Order;
import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.service.OrderService;

import com.springboot.crudapplication.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/order/")
public class Controller {

    @Autowired
    public OrderService service;

    @Autowired
    public PersonalDetailsService persService;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Order> saveOrder(@RequestBody Order request){
        return new ResponseEntity<Order>(service.save(request), HttpStatus.OK);
    }

    @GetMapping(value = "/getOrder",produces = "application/json")
    public ResponseEntity<Set<Order>> getOrder(){
        return  new ResponseEntity<Set<Order>>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getOrderId/{id}",produces = "application/json")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id){
        return  new ResponseEntity<Order>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteOrderId/{id}",produces = "application/json")
    public void deleteOrder(@PathVariable("id") long id){
        this.service.deleteOrder(id);
    }


}
