package com.springboot.crudapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

//    @Column(name="status_id")
//    private String status_id;

    //@OneToOne(targetEntity=Status.class)
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "status_id", referencedColumnName = "status_id")
    private Status status;

}