package com.restapi.spring_crud.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "employees")
public class User {

    @Id @GeneratedValue
    private long id;

    @Column (name = "firstname")
    private String firstName;

    @Column (name = "lastname")
    private String lastName;

    @Column (name = "email")
    private String email;



}
