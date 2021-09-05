package com.springboot.crudapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "status_details")
public class Status {
    @Id
    @Column(name="status_id")
    private String status_id;

    @Column(name="status")
    private String status;
}