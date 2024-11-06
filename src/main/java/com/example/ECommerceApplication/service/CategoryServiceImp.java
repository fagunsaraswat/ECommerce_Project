package com.example.ECommerceApplication.service;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ECommerceApplication.model.*;
import com.example.ECommerceApplication.repository.*;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<ProductEntity> getProductsByCategoryName(String categoryName) {
        CategoryEntity category = categoryRepository.findByCategoryName(categoryName);
        if (category != null) {
            return productRepository.findByCategory(category);
        }
        return List.of();
    }

    @Override
    public String createCategory(CategoryEntity category) {
        categoryRepository.save(category);
        return "Category created succesfully!";
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public String updateCategory(Long categoryId, CategoryEntity category) {
        CategoryEntity existingCategory = categoryRepository.findById(categoryId).orElse(null);
        if(existingCategory!=null){
            BeanUtils.copyProperties(category, existingCategory);
            categoryRepository.save(existingCategory);
            return "Category Updated Succesfully!";
        }
        return "No such Category found!";
    }

    @Override
    public String deleteCategory(Long categoryId) {
        CategoryEntity existingCategory = categoryRepository.findById(categoryId).orElse(null);
        if(existingCategory!=null){
            categoryRepository.deleteById(categoryId);
            return "Category Deleted Succesfully!";
        }
        return "No such Category found!";
    }
}
