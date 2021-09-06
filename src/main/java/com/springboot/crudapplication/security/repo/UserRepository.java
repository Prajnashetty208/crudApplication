package com.springboot.crudapplication.security.repo;

import com.springboot.crudapplication.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByName(String name);
}
