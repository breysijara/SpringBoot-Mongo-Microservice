package com.test.microservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Telephone")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operator;
    private String number;

    @JoinColumn(name = "id_person", referencedColumnName = "id")
    @ManyToOne
    private Person person;
}
