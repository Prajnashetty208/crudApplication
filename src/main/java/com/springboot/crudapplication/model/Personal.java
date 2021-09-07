package com.springboot.crudapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "First name is mandatory")
    @NotEmpty(message = "First name cannot be empty")
    @NotNull(message = "First name cannot be null")
    private String firstname;

    @Column(name="address")
    @NotBlank(message = "Address is mandatory")
    @NotEmpty(message = "Status Id cannot be empty")
    @NotNull(message = "Status Id cannot be null")
    private String address;

    @Column(name="status_id")
    //@Length(max=5, min=1)
    private int status_id;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name = "user_id", referencedColumnName = "user_id")
    private List<Contact> contacts;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name = "user_id", referencedColumnName = "user_id")
    private List<Order> orders;

}