package com.example.ECommerceApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * CategoryEntity represents a category of products in the application.
 * It contains fields for category details and the products associated with it.
 *
 * @author Fagun Saraswat
 * @version 1.0
 */
@Data
@Entity
public class CategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_description")
    private String categoryDescription;

    @Column(name = "vendor_id")
    private Long vendorId;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;
}
