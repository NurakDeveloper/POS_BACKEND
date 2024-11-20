package com.pos.pos_backend.mapper;

import com.pos.pos_backend.Dto.CategoryDto;
import com.pos.pos_backend.model.Category;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getImage()
        );
    }

    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getDescription(),
                categoryDto.getImage()
        );
    }
}