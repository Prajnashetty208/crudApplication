package com.springboot.crudapplication.service;

import com.springboot.crudapplication.model.Order;
import com.springboot.crudapplication.model.Personal;

import java.util.Set;

public interface PersonalDetailsService {
    Personal getDetails(String name, String lname);

}
