package com.example.ECommerceApplication.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.ECommerceApplication.model.*;

/**
 * Service interface for managing {@link CategoryEntity} entities.
 * Provides methods for CRUD operations on categories.
 */
@Service
public interface CategoryService {

    /**
     * Retrieves products by their category name.
     *
     * @param categoryName the name of the category to search for
     * @return a list of {@link ProductEntity} instances belonging to the specified category
     */
    List<ProductEntity> getProductsByCategoryName(String categoryName);

    /**
     * Creates a new category.
     *
     * @param category the {@link CategoryEntity} to create
     * @return a message indicating the result of the operation
     */
    String createCategory(CategoryEntity category);

    /**
     * Retrieves all categories.
     *
     * @return a list of all {@link CategoryEntity} instances
     */
    List<CategoryEntity> getAllCategories();

    /**
     * Updates an existing category.
     *
     * @param categoryId the ID of the category to update
     * @param category the {@link CategoryEntity} with updated information
     * @return a message indicating the result of the operation
     */
    String updateCategory(Long categoryId, CategoryEntity category);

    /**
     * Deletes a category by its ID.
     *
     * @param categoryId the ID of the category to delete
     * @return a message indicating the result of the operation
     */
    String deleteCategory(Long categoryId);
}
