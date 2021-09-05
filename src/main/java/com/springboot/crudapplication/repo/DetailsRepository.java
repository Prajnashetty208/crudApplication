package com.springboot.crudapplication.repo;

import com.springboot.crudapplication.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface DetailsRepository extends JpaRepository<Personal, Integer> {

    Personal findByFirstNameAndAddress(String firstName, String address);

}


