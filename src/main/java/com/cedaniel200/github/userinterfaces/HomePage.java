package com.cedaniel200.github.userinterfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(linkText = "New")
    public WebElement newRepository;
    @FindBy(id = "dashboard")
    public WebElement dashboard;

}
