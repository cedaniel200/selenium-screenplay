package com.cedaniel200.github.userinterfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "login_field")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(name = "commit")
    public WebElement signIn;
}
