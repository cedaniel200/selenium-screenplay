package com.cedaniel200.saucedemo.tasks;

import com.cedaniel200.automation.screenplay.actions.Action;
import com.cedaniel200.saucedemo.model.User;
import com.cedaniel200.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Authenticate implements Action {

    private final User user;

    public Authenticate(User user) {
        this.user = user;
    }

    @Override
    public void perform(WebDriver browser) {
        LoginPage loginPage = new LoginPage(browser);
        loginPage.username.sendKeys(user.getUsername());
        loginPage.password.sendKeys(user.getPassword());
        loginPage.loginButton.click();
    }

    public static Action with(User user) {
        return new Authenticate(user);
    }
}
