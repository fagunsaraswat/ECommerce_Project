package com.example.ECommerceApplication.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.ECommerceApplication.model.ProductEntity;
import com.example.ECommerceApplication.model.UserEntity;

/**
 * Service interface for managing {@link UserEntity} entities.
 * Provides methods for CRUD operations and user-related functionalities.
 */
@Service
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user the {@link UserEntity} to create
     * @return a message indicating the result of the operation
     */
    String createUser(UserEntity user);

    /**
     * Retrieves all users.
     *
     * @return a list of all {@link UserEntity} instances
     */
    List<UserEntity> getAllUsers();

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete
     * @return a message indicating the result of the operation
     */
    String deleteUser(Long id);

    /**
     * Updates an existing user.
     *
     * @param id the ID of the user to update
     * @param user the {@link UserEntity} with updated information
     * @return a message indicating the result of the operation
     */
    String updateUser(Long id, UserEntity user);

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return a message containing user information
     */
    String getUserById(Long id);

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID of the product to retrieve
     * @return the {@link ProductEntity} with the specified ID
     */
    ProductEntity getProductById(Long productId);

    /**
     * Allows a user to purchase a product.
     *
     * @param userId the ID of the user making the purchase
     * @param productId the ID of the product being purchased
     */
    void buyProduct(Long userId, Long productId);

    /**
     * Retrieves a list of products purchased by a user.
     *
     * @param userId the ID of the user
     * @return a list of {@link ProductEntity} instances that the user has purchased
     */
    List<ProductEntity> getPurchasedProducts(Long userId);
}
