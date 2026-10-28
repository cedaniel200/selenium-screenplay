package com.cedaniel200.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(css = ".complete-header")
    public WebElement completeHeader;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
