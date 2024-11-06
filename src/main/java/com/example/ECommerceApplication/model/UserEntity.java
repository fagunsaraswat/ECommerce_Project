package com.example.ECommerceApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * UserEntity represents a user in the application, including their personal details,
 * role, and the products they have purchased.
 *
 * @author Fagun Saraswat
 * @version 1.0
 */
@Entity
@Data
@Table
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "deleted")
    private boolean deleted = false;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    // The date and time when the user was last updated. Defaults to current timestamp.
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedDate;

    // The role of the user (e.g., ADMIN, USER).
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    // A collection of roles assigned to the user.
    @ElementCollection(targetClass = RoleEnum.class)
    private List<RoleEnum> roles;

    // A list of products purchased by the user.
    @ManyToMany
    @JoinTable(
            name = "user_product",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> purchasedProducts;

    @Column(name = "enabled")
    private boolean isEnabled;

    /**
     * Marks the user as deleted.
     */
    public void setDeleted() {
        deleted = true;
    }
}
