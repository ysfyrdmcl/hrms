package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.Gender;
import com.bilgeadam.repository.enums.State;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public abstract class Person {
    private Long identityNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String profilePhoto;
    private Date birthDay;
    private Date startDate;
    private Date quitDate;
    private String emailAddress;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private State state = State.ACTIVE;


}
