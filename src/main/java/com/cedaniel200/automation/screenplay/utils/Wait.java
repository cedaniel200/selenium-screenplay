package com.cedaniel200.automation.screenplay.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait implements Cloneable {

    private static WebDriverWait webDriverWait;

    public static WebDriverWait onlyInThis (WebDriver driver){
        return new WebDriverWait(driver, 10L);
    }

    public static synchronized WebDriverWait inThisNew(WebDriver driver){
        webDriverWait = new WebDriverWait(driver, 10L);
        return webDriverWait;
    }

    public static synchronized WebDriverWait inCurrentBrowser(){
        if(webDriverWait == null) webDriverWait = new WebDriverWait(DriverFactory.getDriver(), 10L);
        return webDriverWait;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
