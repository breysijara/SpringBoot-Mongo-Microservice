package com.test.microservice.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class TelephoneDto {
    private Long id;
    private String operator;
    private String number;

    private PersonDto person;
}
