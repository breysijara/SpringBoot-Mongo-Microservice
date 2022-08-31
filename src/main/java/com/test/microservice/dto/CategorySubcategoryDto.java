package com.test.microservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class CategorySubcategoryDto {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Size(min = 1, max = 250)
    private String description;

    private Double precio;
    private CategoryDto category;




}