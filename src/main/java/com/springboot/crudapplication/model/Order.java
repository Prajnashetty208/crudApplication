package com.springboot.crudapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "orderTable")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private Long orderId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;
}
