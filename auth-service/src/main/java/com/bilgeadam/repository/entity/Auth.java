package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="tblauth")
public class Auth {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
     String username;
     String password;
    @Enumerated(EnumType.STRING)
    Roles role;

}
