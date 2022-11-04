package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.Gender;
import com.bilgeadam.repository.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employees")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "profile_photo")
    private byte[] profilePhoto;
    @Column(name = "identity_number")
    private Long identityNumber;
    @Column(name = "birth_day")
    private Long birthDay;
    @Column(name = "start_date")
    private Long startDate;
    @Column(name = "release_date")
    private Long releaseDate;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "department_id")
    private Long departmentId;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
