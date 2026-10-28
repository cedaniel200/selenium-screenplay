package com.cedaniel200.saucedemo.questions;

import com.cedaniel200.automation.screenplay.Question;
import com.cedaniel200.automation.screenplay.utils.Wait;
import com.cedaniel200.saucedemo.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductInCart implements Question {

    private final int expectedCount;

    public ProductInCart(int expectedCount) {
        this.expectedCount = expectedCount;
    }

    @Override
    public boolean answer(WebDriver driver) {
        try {
            Wait.inThis(driver).until(visibilityOfElementLocated(By.cssSelector(".cart_item")));
            return new CartPage(driver).items.size() == expectedCount;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public String errorMessage() {
        return "Se esperaban " + expectedCount + " productos en el carrito";
    }
}
