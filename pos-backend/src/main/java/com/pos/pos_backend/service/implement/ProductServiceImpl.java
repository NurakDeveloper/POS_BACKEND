package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.ProductDto;
import com.pos.pos_backend.exception.ResourceNotFoundException;
import com.pos.pos_backend.mapper.ProductMapper;
import com.pos.pos_backend.model.Category;
import com.pos.pos_backend.model.Product;
import com.pos.pos_backend.repository.CategoryRepository;
import com.pos.pos_backend.repository.ProductRepository;
import com.pos.pos_backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found")); // Validate category exists
        Product product = ProductMapper.mapToProduct(productDto, category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDto updateProductById(Long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        product.setCategory(category);
        // Update other fields
        product.setProductName(productDto.getProductName());
        product.setCalories(productDto.getCalories());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return ProductMapper.mapToProductDto(productRepository.save(product));
    }
}
