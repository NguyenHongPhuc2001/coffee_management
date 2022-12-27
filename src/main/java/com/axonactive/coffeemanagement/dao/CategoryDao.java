package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.CategoryRequest;
import com.axonactive.coffeemanagement.entity.Category;

import java.util.List;

public interface CategoryDao {
    Category findById(Long categoryId);
    List<Category> findAll();
    Category create(CategoryRequest categoryRequest);
    Category update(CategoryRequest categoryRequest, Long categoryId);
    void delete(Long categoryId);
    List<Category> findByName(String categoryName);
    List<Category> findByType(String categoryType);
}
