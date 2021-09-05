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
@Table(name = "orderTable")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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