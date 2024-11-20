package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.ProductDto;
import com.pos.pos_backend.mapper.ProductMapper;
import com.pos.pos_backend.model.Product;
import com.pos.pos_backend.repository.ProductRepository;
import com.pos.pos_backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductImpl implements ProductService {

    private ProductRepository productRepository ;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product saveProductToDataStore = productRepository.save(product);
        return ProductMapper.mapToProductDto(saveProductToDataStore);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> getAllProducts = productRepository.findAll();
        return getAllProducts.stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDto updateProductById(Long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setProductName(productDto.getProductName());
        product.setCalories(productDto.getCalories());
        product.setBranchId(productDto.getBranchId());
        product.setCategoryId(productDto.getCategoryId());
        product.setDescription(productDto.getDescription());
        product.setPrepareTime(productDto.getPrepareTime());
        product.setPrice(productDto.getPrice());
        product.setStatus(productDto.getStatus());
        product.setCreatedDate(productDto.getCreatedDate());
        product.setUpdatedDate(productDto.getUpdatedDate());
        product.setImage(productDto.getImage());
        product.setProductCode(productDto.getProductCode());
        product.setProductOrigin(productDto.getProductOrigin());
        product.setMaxOrderQty(productDto.getMaxOrderQty());
        product.setMinOrderQty(productDto.getMinOrderQty());
        product.setSugar(productDto.getSugar());
        return ProductMapper.mapToProductDto(productRepository.save(product));
    }
}
