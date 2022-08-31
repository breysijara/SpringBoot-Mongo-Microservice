package com.test.microservice.repository;

import com.test.microservice.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {


   }
