package com.bilgeadam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SummaryInfoResponseDto {
    private String firstName;
    private String lastName;
    private String profilePhoto;
    private Long departmentId;
    private Long professionId;
    private String emailAddress;
    private String phoneNumber;
}
