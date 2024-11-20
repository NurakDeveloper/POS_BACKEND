package com.pos.pos_backend.mapper;

import com.pos.pos_backend.Dto.ProductDto;
import com.pos.pos_backend.model.Category;
import com.pos.pos_backend.model.Product;

public class ProductMapper {

    /**
     * Maps a Product entity to a ProductDto object.
     *
     * @param product the Product entity to be mapped.
     * @return the corresponding ProductDto object.
     */
    public static ProductDto mapToProductDto(Product product) {
        if (product == null) {
            return null; // Handle null Product gracefully
        }

        return new ProductDto(
                product.getId(),
                product.getCategory() != null ? product.getCategory().getId() : null, // Handle null Category
                product.getCreatedBy(),
                product.getUpdatedBy(),
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
                product.getBranchId(),
                product.getCreatedDate(),
                product.getUpdatedDate()
        );
    }

    /**
     * Maps a ProductDto object to a Product entity.
     *
     * @param productDto the ProductDto to be mapped.
     * @param category   the Category entity to associate with the Product.
     * @return the corresponding Product entity.
     */
    public static Product mapToProduct(ProductDto productDto, Category category) {
        if (productDto == null) {
            return null; // Handle null ProductDto gracefully
        }

        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null when mapping ProductDto to Product.");
        }

        Product product = new Product();

        // Set the category object
        product.setCategory(category);

        // Map fields from ProductDto to Product
        product.setId(productDto.getId());
        product.setCreatedBy(productDto.getCreatedBy());
        product.setUpdatedBy(productDto.getUpdatedBy());
        product.setBranchId(productDto.getBranchId());

        // Map productCode if it's part of the models (uncomment if needed)
        // product.setProductCode(productDto.getProductCode());

        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setPrepareTime(productDto.getPrepareTime());
        product.setDescription(productDto.getDescription());
        product.setCalories(productDto.getCalories());
        product.setStatus(productDto.getStatus());
        product.setProductOrigin(productDto.getProductOrigin());
        product.setSugar(productDto.getSugar());
        product.setImage(productDto.getImage());
        product.setMaxOrderQty(productDto.getMaxOrderQty());
        product.setMinOrderQty(productDto.getMinOrderQty());
        product.setCreatedDate(productDto.getCreatedDate());
        product.setUpdatedDate(productDto.getUpdatedDate());

        return product;
    }
}
