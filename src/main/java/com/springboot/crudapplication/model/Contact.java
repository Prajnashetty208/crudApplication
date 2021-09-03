package com.springboot.crudapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "orderTable")
public class Contact {

    @Id
    @Column(name="contact_d")
    private int contact_d;

    @Column(name="user_id")
    private String user_id;

    @Column(name="office_phone")
    private String office_phone;

    @Column(name="home_phone")
    private String home_phone;

}
