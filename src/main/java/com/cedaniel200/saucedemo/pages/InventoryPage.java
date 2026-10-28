package com.cedaniel200.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private final WebDriver driver;

    @FindBy(css = ".inventory_list")
    public WebElement inventoryList;

    @FindBy(css = ".shopping_cart_link")
    public WebElement cartLink;

    @FindBy(css = ".shopping_cart_badge")
    public WebElement cartBadge;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement addToCart(String product) {
        return driver.findElement(By.cssSelector("[data-test='add-to-cart-" + product + "']"));
    }
}
