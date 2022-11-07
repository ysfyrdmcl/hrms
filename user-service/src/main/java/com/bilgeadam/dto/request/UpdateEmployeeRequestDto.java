package com.bilgeadam.dto.request;

import com.bilgeadam.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateEmployeeRequestDto {
    private String emailAddress;
    private String phoneNumber;
    private String profilePhoto;
    private State state;
}
