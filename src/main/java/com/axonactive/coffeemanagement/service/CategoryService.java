package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.CategoryRequest;
import com.axonactive.coffeemanagement.service.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto findById(Long categoryId);
    List<CategoryDto> findAll();
    CategoryDto create(CategoryRequest categoryRequest);
    CategoryDto update(CategoryRequest categoryRequest, Long categoryId);
    void delete(Long categoryId);
    List<CategoryDto> findByName(String categoryName);
    List<CategoryDto> findByType(String categoryType);
}
