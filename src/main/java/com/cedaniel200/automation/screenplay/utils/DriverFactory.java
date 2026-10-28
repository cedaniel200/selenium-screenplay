package com.cedaniel200.automation.screenplay.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {

    public static final String WEBDRIVER_DRIVER = "webdriver.driver";
    public static final String HEADLESS = "headless";
    public static final String REMOTE_URL = "webdriver.remote.url";

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver createDriver() {
        String type = System.getProperty(WEBDRIVER_DRIVER, "chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(System.getProperty(HEADLESS, "true"));
        String remoteUrl = System.getProperty(REMOTE_URL, "").trim();

        if (!remoteUrl.isEmpty()) {
            return remoteDriver(remoteUrl, type, headless);
        }

        return switch (type) {
            case "firefox" -> new FirefoxDriver(firefoxOptions(headless));
            case "chrome" -> new ChromeDriver(chromeOptions(headless));
            default -> throw new IllegalArgumentException(
                    "Navegador no soportado: " + type + " (usa chrome o firefox)");
        };
    }

    private static WebDriver remoteDriver(String remoteUrl, String type, boolean headless) {
        try {
            return switch (type) {
                case "firefox" -> new RemoteWebDriver(
                        URI.create(remoteUrl).toURL(), firefoxOptions(headless));
                case "chrome" -> new RemoteWebDriver(
                        URI.create(remoteUrl).toURL(), chromeOptions(headless));
                default -> throw new IllegalArgumentException(
                        "Navegador no soportado: " + type + " (usa chrome o firefox)");
            };
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("URL remota inválida: " + remoteUrl, e);
        }
    }

    private static ChromeOptions chromeOptions(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1440,900");
        if (headless) {
            options.addArguments("--headless=new");
        }
        return options;
    }

    private static FirefoxOptions firefoxOptions(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
        }
        return options;
    }
}
