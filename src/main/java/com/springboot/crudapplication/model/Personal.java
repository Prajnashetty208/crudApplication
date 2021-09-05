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

    @Column(name="firstname")
    private String firstname;

    @Column(name="address")
    private String address;

    @Column(name="status_id")
    private int status_id;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name = "user_id", referencedColumnName = "user_id")
    private List<Contact> contacts;

}