package com.example.ECommerceApplication.controller;

import com.example.ECommerceApplication.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.ECommerceApplication.service.UserService;

@RestController
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Create a new user", responses = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid user data")
    })
    @PostMapping("/users")
    public String createUser(@Parameter(description = "User object to be created") @RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Get all users", responses = {
            @ApiResponse(responseCode = "200", description = "List of users retrieved successfully")
    })
    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get user by ID", responses = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/users/{userId}")
    public String getUserById(@Parameter(description = "ID of the user to retrieve") @PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @Operation(summary = "Update an existing user", responses = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Invalid user data")
    })
    @PutMapping("/users/{userId}")
    public String updateUser(@Parameter(description = "ID of the user to update") @PathVariable Long userId,
                             @Parameter(description = "Updated user object") @RequestBody UserEntity user) {
        return userService.updateUser(userId, user);
    }

    @Operation(summary = "Delete a user", responses = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@Parameter(description = "ID of the user to delete") @PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @Operation(summary = "Purchase a product", responses = {
            @ApiResponse(responseCode = "200", description = "Product purchased successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    })
    @PostMapping("/users/{userId}/{productId}")
    public String buyProduct(@Parameter(description = "ID of the user buying the product") @PathVariable Long userId,
                             @Parameter(description = "ID of the product to purchase") @PathVariable Long productId) {
        userService.buyProduct(userId, productId);
        return "Product Purchased Successfully";
    }

    @Operation(summary = "Get purchased products by user ID", responses = {
            @ApiResponse(responseCode = "200", description = "List of purchased products retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/users/{userId}/purchases")
    public List<ProductEntity> getPurchasedProducts(@Parameter(description = "ID of the user to retrieve purchases for") @PathVariable Long userId) {
        return userService.getPurchasedProducts(userId);
    }

    @Operation(summary = "Get product by product ID", responses = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/users/product/{productId}")
    public ProductEntity getProductById(@Parameter(description = "ID of the product to retrieve") @PathVariable Long productId) {
        return userService.getProductById(productId);
    }
}
