package com.test.microservice.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class CategoryDto  {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Size(min = 1, max = 250)
    private String description;

    private List<Long> subcategories;



}