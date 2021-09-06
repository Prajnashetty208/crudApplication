package com.springboot.crudapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contact_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @Column(name="contact_id")
    private int contact_id;

    @Column(name="phone")
    private String phone;

}