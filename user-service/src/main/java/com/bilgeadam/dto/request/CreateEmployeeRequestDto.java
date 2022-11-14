package com.bilgeadam.dto.request;

import com.bilgeadam.repository.enums.Gender;
import com.bilgeadam.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateEmployeeRequestDto {
    @NotNull
    @NotBlank
    @NotEmpty
//    @Pattern(regexp = "[a-zA-Z]")
    private String firstName;
    private String middleName;
    @NotNull
    @NotBlank
    @NotEmpty
    private String lastName;
    private State state ;
    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String emailAddress;
    private Long identityNumber;
    private String profilePhoto;
    private Date birthDay;
    private Date startDate;
    private Date quitDate;
    private String phoneNumber;
    private Long addressId;
    private Long departmentId;
    private Long professionId;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
