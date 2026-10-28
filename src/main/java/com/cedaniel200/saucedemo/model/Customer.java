package com.cedaniel200.saucedemo.model;

public record Customer(String firstName, String lastName, String postalCode) {

    public static Customer withData(String firstName, String lastName, String postalCode) {
        return new Customer(firstName, lastName, postalCode);
    }
}
