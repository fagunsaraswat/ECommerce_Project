package com.example.ECommerceApplication.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * BaseEntity serves as a base class for all entities, providing common fields
 * for created and updated timestamps.
 *
 * @author Fagun Saraswat
 * @version 1.0
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    /**
     * This method is called before the entity is persisted to the database.
     * It sets the createdDate and updatedDate to the current date and time.
     */
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    /**
     * This method is called before the entity is updated in the database.
     * It sets the updatedDate to the current date and time.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}

