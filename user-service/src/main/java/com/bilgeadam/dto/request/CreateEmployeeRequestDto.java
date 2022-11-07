package com.bilgeadam.dto.request;

import com.bilgeadam.repository.enums.State;
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
    private State state = State.ACTIVE;
    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String emailAddress;

}
