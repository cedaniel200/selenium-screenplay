package com.cedaniel200.github.stepdefinitions;

import com.cedaniel200.github.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHook {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
    }

    @After
    public void down(){
        driver.quit();
    }
}
