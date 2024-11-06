package com.example.ECommerceApplication.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.ECommerceApplication.model.*;
import com.example.ECommerceApplication.repository.*;
import com.example.ECommerceApplication.service.*;


import java.util.List;

@RestController
@Tag(name = "Product Management", description = "APIs for managing products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    @Operation(summary = "Add a new product", responses = {
            @ApiResponse(responseCode = "200", description = "Product added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid product data")
    })
    @PostMapping("/products/add")
    public String addProduct(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    @Operation(summary = "View a product by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/products/view/{id}")
    public ProductEntity viewProduct(@Parameter(description = "ID of the product to retrieve") @PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    @Operation(summary = "Create a new product", responses = {
            @ApiResponse(responseCode = "200", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid product data")
    })
    @PostMapping("/products/create")
    public String createProduct(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    @Operation(summary = "Update an existing product", responses = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "400", description = "Invalid product data")
    })
    @PutMapping("/products/update/{productId}")
    public String updateProduct(@Parameter(description = "ID of the product to update") @PathVariable Long productId, @RequestBody ProductEntity product) {
        return productService.updateProduct(productId, product);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    @Operation(summary = "Delete a product", responses = {
            @ApiResponse(responseCode = "200", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/products/delete/{productId}")
    public String deleteProduct(@Parameter(description = "ID of the product to delete") @PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }

    @Operation(summary = "Get all products", responses = {
            @ApiResponse(responseCode = "200", description = "List of products retrieved successfully")
    })
    @GetMapping("/products/getAll")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Get category by product name", responses = {
            @ApiResponse(responseCode = "200", description = "Category retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping("/products/category/{productName}")
    public String getCategory(@Parameter(description = "Name of the product to find the category") @PathVariable String productName) {
        CategoryEntity category = productService.getCategoryByProductName(productName);
        return category.getCategoryName();
    }

    @Operation(summary = "Get product by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/products/{productId}")
    public ProductEntity getProductById(@Parameter(description = "ID of the product to retrieve") @PathVariable Long productId) {
        return productService.getProductById(productId);
    }
}

