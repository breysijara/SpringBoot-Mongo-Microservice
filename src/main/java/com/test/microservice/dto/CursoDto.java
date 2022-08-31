package com.test.microservice.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class CursoDto {
    private Long id;
    private String descripcion;
    private Boolean state;
}
