package com.test.microservice.service;


import com.test.microservice.dto.CategoryDto;
public interface CategoryService {

    CategoryDto createCategory(CategoryDto category);
}
