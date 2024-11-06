package com.example.ECommerceApplication.CoreSetup.java;

/*
Enum representing different roles within the application
*/

import lombok.Data;

public enum RoleEnum {
    ADMIN,
    USER,
    VENDOR;

    private RoleEnum name;

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
