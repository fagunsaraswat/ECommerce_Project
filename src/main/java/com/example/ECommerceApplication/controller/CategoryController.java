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
@Tag(name = "Category Management", description = "APIs for managing categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    @Operation(summary = "Create a new category", responses = {
            @ApiResponse(responseCode = "200", description = "Category created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid category data")
    })
    @PostMapping("/category/create")
    public String createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    @Operation(summary = "Update an existing category", responses = {
            @ApiResponse(responseCode = "200", description = "Category updated successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found"),
            @ApiResponse(responseCode = "400", description = "Invalid category data")
    })
    @PutMapping("/category/update/{categoryId}")
    public String updateCategory(@Parameter(description = "ID of the category to update") @PathVariable Long categoryId, @RequestBody CategoryEntity category) {
        return categoryService.updateCategory(categoryId, category);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    @Operation(summary = "Delete a category", responses = {
            @ApiResponse(responseCode = "200", description = "Category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @DeleteMapping("/category/delete/{categoryId}")
    public String deleteCategory(@Parameter(description = "ID of the category to delete") @PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @Operation(summary = "Get all categories", responses = {
            @ApiResponse(responseCode = "200", description = "List of categories retrieved successfully")
    })
    @GetMapping("/category/getAll")
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Operation(summary = "Get products by category name", responses = {
            @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping("/category/{categoryName}")
    public List<ProductEntity> getProductsByCategoryName(@Parameter(description = "Name of the category to find products") @PathVariable String categoryName) {
        return categoryService.getProductsByCategoryName(categoryName);
    }
}
