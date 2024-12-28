package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.ProductDto;
import com.pos.pos_backend.exception.ResourceNotFoundException;
import com.pos.pos_backend.mapper.ProductMapper;
import com.pos.pos_backend.model.entity.Category;
import com.pos.pos_backend.model.entity.Product;
import com.pos.pos_backend.repository.CategoryRepository;
import com.pos.pos_backend.repository.ProductRepository;
import com.pos.pos_backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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
        product.setProductCode(generateUniqueProductCode());
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }
    public static Long generateUniqueProductCode() {
        // Format current date and time as "yyyyMMddHHmmss"
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        // Generate a random number between 0 and 999 (3 digits)
        int randomNum = ThreadLocalRandom.current().nextInt(100, 1000); // Ensures it's always 3 digits

        // Combine the last 4 digits of the timestamp and the random number (to make 7 digits total)
        String uniqueCodeString = timestamp.substring(timestamp.length() - 4) + randomNum;

        // Convert the string to a Long
        return Long.parseLong(uniqueCodeString);
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
        product.setPrepareTime(productDto.getPrepareTime());
        product.setProductOrigin(productDto.getProductOrigin());
        product.setSugar(productDto.getSugar());
        product.setMaxOrderQty(productDto.getMaxOrderQty());
        product.setMinOrderQty(productDto.getMinOrderQty());
        product.setCalories(productDto.getCalories());
        product.setImage(productDto.getImage());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStatus(productDto.getStatus());
        product.setPrice(productDto.getPrice());
        product.setBranchId(productDto.getBranchId());
        product.setCalories(productDto.getCalories());
        product.setCreatedBy(productDto.getCreatedBy());
        product.setCreatedDate(productDto.getCreatedDate());
        product.setUpdatedBy(productDto.getUpdatedBy());
        return ProductMapper.mapToProductDto(productRepository.save(product));
    }
}
