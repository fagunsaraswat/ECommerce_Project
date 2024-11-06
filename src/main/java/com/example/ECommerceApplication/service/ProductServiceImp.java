package com.example.ECommerceApplication.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ECommerceApplication.model.*;
import com.example.ECommerceApplication.repository.*;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public CategoryEntity getCategoryByProductName(String productName) {
        ProductEntity product = productRepository.findByProductName(productName);
        return (product!=null) ? product.getCategory() : null;
    }

    @Override
    public String createProduct(ProductEntity product) {
        productRepository.save(product);
        return "Product created successfully!";
    }

    @Override
    public String updateProduct(Long productId, ProductEntity product) {
        ProductEntity existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            BeanUtils.copyProperties(existingProduct, product);
            productRepository.save(existingProduct);
            return "Product updated successfully!";
        }
        return "Product not found!";
    }

    @Override
    public String deleteProduct(Long productId) {
        ProductEntity existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            productRepository.deleteById(productId);
            return "Product deleted successfully!";
        }
        return "Product not found!";
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
