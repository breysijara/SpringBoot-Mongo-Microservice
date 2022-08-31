package com.test.microservice.service;

import com.test.microservice.domain.Category;
import com.test.microservice.domain.Person;
import com.test.microservice.dto.CategoryDto;
import com.test.microservice.dto.PersonDto;
import com.test.microservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    @Transactional
    public CategoryDto createCategory(CategoryDto CategoryDto) {

        log.info("Ingresó al método rear categoria");

        Category category = new Category();
        category.setName(CategoryDto.getName());
        category.setDescription(CategoryDto.getDescription());
        category.setState(true);

        this.categoryRepository.save(category);

        CategoryDto.setId(category.getId());

        return CategoryDto;
    }



}
