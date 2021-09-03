package com.springboot.crudapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "status_details")
public class Status {

    @Id
    @Column(name="dateVal")
    private String status;

}
