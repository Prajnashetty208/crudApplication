package com.springboot.crudapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "status_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @Id
    @Column(name="status_id")
    private String status_id;

    @Column(name="status")
    private String status;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name = "status_id", referencedColumnName = "status_id")
    private List<Personal> personal;

}