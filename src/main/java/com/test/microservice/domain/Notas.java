package com.test.microservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Notas")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nota;

    @JoinColumn(name = "id_alumno", referencedColumnName = "id")
    @ManyToOne
    private Alumno alumno;


    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne
    private Curso curso;

}
