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
    @Column(name="statusid")
    private String statusid;

    @Column(name="status")
    private String status;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name = "statusid", referencedColumnName = "statusid")
    private List<Personal> personal;

}