package com.cedaniel200.saucedemo.questions;

import com.cedaniel200.automation.screenplay.Question;
import com.cedaniel200.automation.screenplay.utils.Wait;
import com.cedaniel200.saucedemo.pages.LoginPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginError implements Question {

    private final String expectedMessage;

    public LoginError(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    @Override
    public boolean answer(WebDriver driver) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            Wait.inThis(driver).until(visibilityOf(loginPage.error));
            return loginPage.error.getText().contains(expectedMessage);
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public String errorMessage() {
        return "No se encontró el mensaje de error: " + expectedMessage;
    }
}
