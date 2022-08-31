package com.test.microservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "Alumno")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String name;
    private String apellido;
    private String edad;
    private Boolean state;

    public Alumno(Long id) {
        this.id = id;
    }

}
