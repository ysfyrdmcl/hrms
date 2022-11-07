package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

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
    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String emailAddress;

}
