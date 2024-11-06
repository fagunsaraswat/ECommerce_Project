package com.example.ECommerceApplication.service;
import com.example.ECommerceApplication.model.*;
import com.example.ECommerceApplication.repository.*;
import java.util.List;

/**
 * Service interface for managing vendor-related operations.
 * Provides methods to retrieve products and categories for a specific vendor.
 */
public interface VendorService {

    /**
     * Retrieves products for a specific vendor.
     *
     * @param vendorId the ID of the vendor
     * @return a list of {@link ProductEntity} instances associated with the vendor
     */
    List<ProductEntity> getProductsForVendor(Long vendorId);

    /**
     * Retrieves categories for a specific vendor.
     *
     * @param vendorId the ID of the vendor
     * @return a list of {@link CategoryEntity} instances associated with the vendor
     */
    List<CategoryEntity> getCategoriesForVendor(Long vendorId);
}

