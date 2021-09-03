package com.springboot.crudapplication.service;

import com.springboot.crudapplication.exception.OrderNotFoundException;
import com.springboot.crudapplication.model.Order;
import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.repo.DetailsRepository;
import com.springboot.crudapplication.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
    @Autowired
    private DetailsRepository repo;

    @Override
    public Personal getDetails(String name, String lname) {
        return null;
    }
}
