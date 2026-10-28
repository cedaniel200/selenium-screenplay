package com.cedaniel200.saucedemo.questions;

import com.cedaniel200.automation.screenplay.Question;
import com.cedaniel200.automation.screenplay.utils.Wait;
import com.cedaniel200.saucedemo.pages.CheckoutPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class OrderConfirmed implements Question {

    private static final String CONFIRMATION = "Thank you for your order!";

    @Override
    public boolean answer(WebDriver driver) {
        try {
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            Wait.inThis(driver).until(visibilityOf(checkoutPage.completeHeader));
            return checkoutPage.completeHeader.getText().contains(CONFIRMATION);
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public String errorMessage() {
        return "No se encontró la confirmación de la compra";
    }
}
