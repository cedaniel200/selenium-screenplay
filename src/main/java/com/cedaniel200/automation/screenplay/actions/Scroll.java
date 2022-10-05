package com.cedaniel200.automation.screenplay.actions;

import com.cedaniel200.automation.screenplay.utils.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scroll {

    private Scroll() {
    }

    public static void to(WebElement webElement) {
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
