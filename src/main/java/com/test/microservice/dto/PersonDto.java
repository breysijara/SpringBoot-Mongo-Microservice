package com.test.microservice.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class PersonDto {
    private Long id;
    private String name;
    private String gender;
    private String address;
}
