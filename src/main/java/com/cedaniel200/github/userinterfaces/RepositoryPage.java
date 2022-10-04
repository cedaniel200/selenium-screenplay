package com.cedaniel200.github.userinterfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepositoryPage {

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]//strong[@itemprop='name']/a")
    public WebElement repositoryName;

}
