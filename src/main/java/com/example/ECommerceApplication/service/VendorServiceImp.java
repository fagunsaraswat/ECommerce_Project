package com.example.ECommerceApplication.service;
import com.example.ECommerceApplication.model.*;
import com.example.ECommerceApplication.repository.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class VendorServiceImp implements VendorService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @PreAuthorize("hasRole('VENDOR')")
    public List<ProductEntity> getProductsForVendor(Long vendorId) {
        return productRepository.findAllByVendorId(vendorId);
    }

    @PreAuthorize("hasRole('VENDOR')")
    public List<CategoryEntity> getCategoriesForVendor(Long vendorId) {
        return categoryRepository.findAllByVendorId(vendorId);
    }
}
