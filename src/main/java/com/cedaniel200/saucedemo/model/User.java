package com.cedaniel200.saucedemo.model;

public record User(String username, String password) {

    public static User withCredentials(String username, String password) {
        return new User(username, password);
    }
}
