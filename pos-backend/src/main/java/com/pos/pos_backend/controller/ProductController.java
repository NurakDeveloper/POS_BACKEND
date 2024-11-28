package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.ProductDto;
import com.pos.pos_backend.Dto.procedure.ProductSold;
import com.pos.pos_backend.repository.CustomizeRepository;
import com.pos.pos_backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private CustomizeRepository customizeRepository;

    @PostMapping("create")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("list-product")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted with ID: " + id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProductById(id, productDto));
    }

    @GetMapping("list-product-sold")
    public ResponseEntity<List<ProductSold>> getAllProductSold(){
        return ResponseEntity.ok(customizeRepository.getAllProduct());
    }
}
