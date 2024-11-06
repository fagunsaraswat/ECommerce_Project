package com.example.ECommerceApplication.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "vendor_id")
    private Long vendorId;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToMany(mappedBy = "purchasedProducts")
    private List<UserEntity> users;
}
