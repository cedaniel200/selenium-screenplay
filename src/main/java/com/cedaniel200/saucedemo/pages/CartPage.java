package com.cedaniel200.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    @FindBy(css = ".cart_item")
    public List<WebElement> items;

    @FindBy(id = "checkout")
    public WebElement checkout;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
