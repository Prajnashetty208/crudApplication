package com.springboot.crudapplication.repo;

import com.springboot.crudapplication.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface DetailsRepository extends JpaRepository<Personal, Integer> {

    Personal findByFirstnameAndAddress(String firstname, String address);

    @Query( value = "SELECT * FROM personal_details p join order_table o" +
            " on o.user_id = p.user_id" +
            " WHERE o.order_id = :id",
            nativeQuery = true)
    Personal findByOrderId(@Param("id")long id);

}


