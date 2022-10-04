package com.cedaniel200.github.model;

public enum GitIgnore {

    NONE("None"),
    JAVA("Java"),
    ANDROID("Android"),
    C("C"),
    C_PLUS_PLUS("C++");

    private final String nameGitIgnore;

    GitIgnore(final String nameGitIgnore) {
        this.nameGitIgnore = nameGitIgnore;
    }

    @Override
    public String toString() {
        return nameGitIgnore;
    }
}