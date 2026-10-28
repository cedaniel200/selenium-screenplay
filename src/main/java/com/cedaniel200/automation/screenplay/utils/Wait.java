package com.cedaniel200.automation.screenplay.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    private Wait() {
    }

    public static WebDriverWait inThis(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static WebDriverWait inCurrentBrowser() {
        return inThis(DriverFactory.getDriver());
    }
}
