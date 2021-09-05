package com.springboot.crudapplication.service;

import com.springboot.crudapplication.exception.OrderNotFoundException;
import com.springboot.crudapplication.exception.PersonalDetailsNotFoundException;
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
    public Personal save(Personal obj) {
        return this.repo.save(obj);
    }

    @Override
    public Set<Personal> findAll() {
        return new HashSet<>(this.repo.findAll());
    }

    @Override
    public Personal findById(int id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new PersonalDetailsNotFoundException("Details not found"));
    }

    @Override
    public void deletePersonal(int id) {
        this.repo.deleteById(id);
    }

    @Override
    public Personal getDetails(String name, String addr) {
        Personal p = repo.findByFirstNameAndAddress(name,addr);
        System.out.println(p);
        return p;
    }
}
