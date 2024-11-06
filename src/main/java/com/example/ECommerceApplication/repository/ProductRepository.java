package com.example.ECommerceApplication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ECommerceApplication.model.*;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByProductName(String productName);
    List<ProductEntity> findByCategory(CategoryEntity category);
    List<ProductEntity> findAllByVendorId(Long vendorId);
}
