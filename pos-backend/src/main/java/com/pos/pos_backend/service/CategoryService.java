package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    void deleteCategoryById(Long id);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
}