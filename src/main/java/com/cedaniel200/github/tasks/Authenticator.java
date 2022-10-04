package com.cedaniel200.github.tasks;

import com.cedaniel200.github.screenplay.Action;
import com.cedaniel200.github.model.User;
import com.cedaniel200.github.userinterfaces.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Authenticator implements Action {

    private final User user;
    private LoginPage loginPage;

    public Authenticator(User user) {
        this.user = user;
    }

    @Override
    public void perform(WebDriver driver) {
        initPages(driver);

        loginPage.username.sendKeys(user.getUsername());
        loginPage.password.sendKeys(user.getPasswork());
        loginPage.signIn.click();
    }

    private void initPages(WebDriver driver) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    public static Action authenticate(User user) {
        return new Authenticator(user);
    }
}
