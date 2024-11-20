package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.ProductDto;
import com.pos.pos_backend.service.ProductService;
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
    private ProductService productService ;

    @PostMapping("create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto saveProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(saveProduct,HttpStatus.CREATED);
    }
    @GetMapping("list-product")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<ProductDto> getProductByID(@PathVariable("id") Long pId){
        return ResponseEntity.ok(productService.getProductById(pId));
    }
    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long pId){
        productService.deleteProductById(pId);
        return ResponseEntity.ok("" + pId);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long pId , @RequestBody ProductDto productDto){
        return  ResponseEntity.ok(productService.updateProductById(pId , productDto));
    }
}
