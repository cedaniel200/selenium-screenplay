package com.cedaniel200.github.userinterfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//loading-context//h2/a")
    public WebElement newRepository;
    @FindBy(id = "dashboard")
    public WebElement dashboard;

}
