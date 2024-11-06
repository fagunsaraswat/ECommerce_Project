package com.example.ECommerceApplication.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECommerceApplication.model.*;

@Service
public interface ProductService {

    String createProduct(ProductEntity product);
    String updateProduct(Long productId, ProductEntity product);
    String deleteProduct(Long productId);
    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(Long productId);
    CategoryEntity getCategoryByProductName(String productName);

}
