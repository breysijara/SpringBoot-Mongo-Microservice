package com.test.microservice.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class AlumnoDto {

    private Long id;
    private String codigo;
    private String name;
    private String apellido;
    private String edad;
    private Boolean state;

}
