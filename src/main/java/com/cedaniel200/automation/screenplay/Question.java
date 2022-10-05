package com.cedaniel200.automation.screenplay;

import org.openqa.selenium.WebDriver;

public interface Question {
    boolean answer(WebDriver driver);
    String errorMessage();
}
