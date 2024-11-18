package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.ProductDto;
import com.pos.pos_backend.model.Product;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();
    ProductDto getProductById(Long productId);
    void deleteProductById(Long productId);
    ProductDto updateProductById(Long productId , ProductDto productDto);
}
