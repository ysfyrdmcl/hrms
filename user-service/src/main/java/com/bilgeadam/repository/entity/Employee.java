package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;


@NoArgsConstructor
@Data
@SuperBuilder
@AllArgsConstructor
@Table(name = "employees")
@Entity
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Long id;
    private Long addressId;
    private Long departmentId;
    private Long professionId;
//    @Builder
//    public Employee(String firstName)
//    {
//        super(firstName);
//
//    }
}
