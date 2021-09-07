package com.springboot.crudapplication.service;

import com.springboot.crudapplication.model.Personal;

import java.util.Set;

public interface PersonalDetailsService {
    Personal save(Personal obj);
    Set<Personal> findAll();
    Personal findById(int id);
    void deletePersonal(int id);
    Personal getDetails(String name, String addr);
    Personal findByOrderId(long id);

}
