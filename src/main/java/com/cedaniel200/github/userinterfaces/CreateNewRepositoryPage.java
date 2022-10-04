package com.cedaniel200.github.userinterfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewRepositoryPage {

    public static final String SELECTOR_FORMAT_GITIGNORE = "//div[contains(text(), '%s')]//ancestor::label";
    public static final String SELECTOR_FORMAT_LICENSE = "//div[contains(text(), '%s')]//ancestor::label";

    @FindBy(id = "repository_name")
    public WebElement repositoryName;

    @FindBy(id = "repository_description")
    public WebElement repositoryDescription;

    @FindBy(id = "repository_auto_init")
    public WebElement initializeRepositoryWithReadme;

    @FindBy(xpath = "//*[contains(text(),'.gitignore template:')]")
    public WebElement addGitignore;

    @FindBy(xpath = "//input[@aria-label = '.gitignore template']")
    public WebElement filterGitignore;

    @FindBy(xpath = "//*[contains(text(),'License:')]")
    public WebElement addLicense;

    @FindBy(xpath = "//input[@aria-label = 'License']")
    public WebElement filterLicense;

    @FindBy(xpath = "div.js-with-permission-fields > .btn-primary")
    public WebElement createRepository;

    @FindBy(xpath = ".error > strong")
    public WebElement messageRepositoryAlreadyExists;

}
