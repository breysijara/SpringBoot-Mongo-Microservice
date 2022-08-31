package com.test.microservice.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class NotaDto {
    private Long id;
    private Integer nota;

    private Long Alumno_id;
    private Long Curso_id;
}
