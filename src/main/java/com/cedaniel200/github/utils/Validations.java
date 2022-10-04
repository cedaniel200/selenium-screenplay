package com.cedaniel200.github.utils;

public class Validations {
    private Validations() {
    }

    public static boolean isNotEmptyOrNull(String value) {
        return !isEmptyOrNull(value);
    }

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.isEmpty();
    }
}
