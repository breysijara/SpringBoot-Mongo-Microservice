package com.test.microservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "category_subcategory")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class CategorySubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean state;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;


}