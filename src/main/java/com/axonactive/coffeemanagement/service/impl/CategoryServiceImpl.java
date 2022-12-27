package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.CategoryRequest;
import com.axonactive.coffeemanagement.dao.CategoryDao;
import com.axonactive.coffeemanagement.service.CategoryService;
import com.axonactive.coffeemanagement.service.dto.CategoryDto;
import com.axonactive.coffeemanagement.service.mapper.CategoryMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CategoryServiceImpl implements CategoryService {

    @Inject
    private CategoryDao categoryDao;

    @Inject
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDto findById(Long categoryId) {
        return categoryMapper.toDto(categoryDao.findById(categoryId));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtos(categoryDao.findAll());
    }

    @Override
    public CategoryDto create(CategoryRequest categoryRequest) {
        return categoryMapper.toDto(categoryDao.create(categoryRequest));
    }

    @Override
    public CategoryDto update(CategoryRequest categoryRequest, Long categoryId) {
        return categoryMapper.toDto(categoryDao.update(categoryRequest,categoryId));
    }

    @Override
    public void delete(Long categoryId) {
        categoryDao.delete(categoryId);
    }

    @Override
    public List<CategoryDto> findByName(String categoryName) {
        return categoryMapper.toDtos(categoryDao.findByName(categoryName));
    }

    @Override
    public List<CategoryDto> findByType(String categoryType) {
        return categoryMapper.toDtos(categoryDao.findByType(categoryType));
    }
}
