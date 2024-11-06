package com.example.ECommerceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.ECommerceApplication.model.*;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCategoryName(String name);
    List<CategoryEntity> findAllByVendorId(Long vendorId);
}

