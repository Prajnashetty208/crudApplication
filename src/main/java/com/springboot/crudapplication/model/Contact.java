package com.springboot.crudapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orderTable")
public class Contact {
    @Id
    @Column(name="contact_id")
    private int contact_id;

//    @Column(name="user_id")
//    private String user_id;

    @Column(name="phone")
    private String phone;

    @ManyToOne()
    @JoinColumn( name="user_id", referencedColumnName = "user_id")
    private Personal personal;

}