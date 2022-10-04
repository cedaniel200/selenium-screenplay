package com.cedaniel200.github.screenplay.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.function.Supplier;

public class DriverFactory {

    public static final String WEBDRIVER_DRIVER = "webdriver.driver";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver(){
        if(driver == null) driver = createDriver();
        return driver;
    }

    private static WebDriver createDriver(){
        String typeDriver = System.getProperty(WEBDRIVER_DRIVER, CHROME);

        Supplier<WebDriver> chrome = ChromeDriver::new;
        Supplier<WebDriver> firefox = FirefoxDriver::new;

        HashMap<String, Supplier<WebDriver>> creators = new HashMap<>();
        creators.put(CHROME, chrome);
        creators.put(FIREFOX, firefox);

        return creators.get(typeDriver).get();
    }

}
