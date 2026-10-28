package com.cedaniel200.saucedemo.questions;

import com.cedaniel200.automation.screenplay.Question;
import com.cedaniel200.automation.screenplay.utils.Wait;
import com.cedaniel200.saucedemo.pages.InventoryPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class InventoryVisible implements Question {

    @Override
    public boolean answer(WebDriver driver) {
        try {
            Wait.inThis(driver).until(visibilityOf(new InventoryPage(driver).inventoryList));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public String errorMessage() {
        return "El inventario no es visible después del login";
    }
}
