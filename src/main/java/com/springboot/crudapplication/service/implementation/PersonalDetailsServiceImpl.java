package com.springboot.crudapplication.service.implementation;

import com.springboot.crudapplication.exception.PersonalDetailsNotFoundException;
import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.repo.DetailsRepository;
import com.springboot.crudapplication.service.PersonalDetailsService;
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
        Personal p = repo.findByFirstnameAndAddress(name,addr);
        System.out.println(p);
        return p;
    }
}
