package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Category;
import com.axonactive.coffeemanagement.service.dto.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    List<CategoryDto> toDtos(List<Category> categoryList);
}
