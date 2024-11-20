package com.pos.pos_backend.mapper;

import com.pos.pos_backend.Dto.ProductDto;
import com.pos.pos_backend.model.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getCreatedBy(),
                product.getUpdatedBy(),
                product.getCategoryId(),
                product.getBranchId(),
                product.getProductCode(),
                product.getProductName(),
                product.getPrice(),
                product.getPrepareTime(),
                product.getDescription(),
                product.getCalories(),
                product.getStatus(),
                product.getProductOrigin(),
                product.getSugar(),
                product.getImage(),
                product.getMaxOrderQty(),
                product.getMinOrderQty(),
                product.getCreatedDate(),
                product.getUpdatedDate()

        );
    }
    public static Product mapToProduct(ProductDto product){
        return new Product(
                product.getId(),
                product.getCreatedBy(),
                product.getUpdatedBy(),
                product.getCategoryId(),
                product.getBranchId(),
                product.getProductCode(),
                product.getProductName(),
                product.getPrice(),
                product.getPrepareTime(),
                product.getDescription(),
                product.getCalories(),
                product.getStatus(),
                product.getProductOrigin(),
                product.getSugar(),
                product.getImage(),
                product.getMaxOrderQty(),
                product.getMinOrderQty(),
                product.getCreatedDate(),
                product.getUpdatedDate()
        );
    }
}
