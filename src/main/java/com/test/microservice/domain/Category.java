package com.test.microservice.domain;

import lombok.*;

import javax.persistence.*;

@Table(name = "category")
@Entity
@NoArgsConstructor
@Setter
@Getter

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean state;

    public Category(Long id) {
        this.id = id;
    }
}
