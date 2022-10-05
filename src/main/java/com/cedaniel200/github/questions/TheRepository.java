package com.cedaniel200.github.questions;

import com.cedaniel200.automation.screenplay.Question;
import com.cedaniel200.github.exceptions.RepositoryAlreadyExistsError;
import com.cedaniel200.github.userinterfaces.RepositoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TheRepository implements Question {

    private final String repositoryName;
    private RepositoryPage repositoryPage;

    public TheRepository(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    @Override
    public boolean answer(WebDriver driver) {
        init(driver);
        return repositoryPage.repositoryName.getText().equals(repositoryName);
    }

    @Override
    public String errorMessage() {
        return RepositoryAlreadyExistsError.withMessageBy(repositoryName);
    }

    private void init(WebDriver driver) {
        repositoryPage = PageFactory.initElements(driver, RepositoryPage.class);
    }

    public static Question nameIs(String repositoryName) {
        return new TheRepository(repositoryName);
    }

}
