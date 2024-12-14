package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.CategoryDto;
import com.pos.pos_backend.mapper.CategoryMapper;
import com.pos.pos_backend.model.entity.Category;
import com.pos.pos_backend.repository.CategoryRepository;
import com.pos.pos_backend.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw new IllegalArgumentException("Category already exists with name: " + categoryDto.getName());
        }
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryMapper::mapToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Category not found with ID: " + id));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Category not found with ID: " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Category not found with ID: " + id));
        existingCategory.setName(categoryDto.getName());
        existingCategory.setDescription(categoryDto.getDescription());
        existingCategory.setImage(categoryDto.getImage());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }
}
