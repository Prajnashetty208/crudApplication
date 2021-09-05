package com.springboot.crudapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "personal_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personal {
    @Id
    @Column(name="user_id")
    private int user_id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="address")
    private String address;

    //@OneToOne(targetEntity=Status.class)
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "status_id", referencedColumnName = "status_id")
    private Status status;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name = "user_id", referencedColumnName = "user_id")
    private List<Contact> contacts;

}