package com.bilgeadam.repository.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "managers")
@Entity
@EqualsAndHashCode(callSuper=false)
public class Manager extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    Long id;
    private Long addressId;



}
