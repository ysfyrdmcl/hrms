package com.bilgeadam.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;


@NoArgsConstructor
@Data
@SuperBuilder
@AllArgsConstructor
@Table(name = "employees")
@Entity
@EqualsAndHashCode(callSuper=false)
public class Employee extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Long id;
    private Long addressId;
    private Long departmentId;
    private Long professionId;
}
