package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();
    ProductDto getProductById(Long productId);
    void deleteProductById(Long productId);
    ProductDto updateProductById(Long productId , ProductDto productDto);
}
