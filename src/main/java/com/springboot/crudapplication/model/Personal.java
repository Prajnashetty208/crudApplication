package com.springboot.crudapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "personal_details")
public class Personal {
    @Id
    @Column(name="user_id")
    private int user_id;
    @Column(name="firstName")
    private String firstName;

    @Column(name="address")
    private String address;
    @Column(name="status")
    private String status;

}
