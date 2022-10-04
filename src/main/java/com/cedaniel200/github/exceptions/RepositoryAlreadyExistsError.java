package com.cedaniel200.github.exceptions;

public class RepositoryAlreadyExistsError extends AssertionError {

    private static final String MESSAGE_FORMAT_REPOSITORY_ALREADY_EXISTS = "The repository named %s already exists";

    public RepositoryAlreadyExistsError(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryAlreadyExistsError(String message) {
        super(message);
    }

    public static String withMessageBy(String repositoryName) {
        return String.format(MESSAGE_FORMAT_REPOSITORY_ALREADY_EXISTS, repositoryName);
    }

}