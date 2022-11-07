package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;


@NoArgsConstructor
@Data
@SuperBuilder
@AllArgsConstructor
@Table(name = "employees")
@Entity
public class Employee extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Long id;
    private Long addressId;
    private Long departmentId;
//    @Builder
//    public Employee(String firstName)
//    {
//        super(firstName);
//
//    }
}
