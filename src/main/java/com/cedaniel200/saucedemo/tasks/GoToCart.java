package com.cedaniel200.saucedemo.tasks;

import com.cedaniel200.automation.screenplay.actions.Action;
import com.cedaniel200.saucedemo.pages.InventoryPage;
import org.openqa.selenium.WebDriver;

public class GoToCart implements Action {

    @Override
    public void perform(WebDriver browser) {
        new InventoryPage(browser).cartLink.click();
    }

    public static Action now() {
        return new GoToCart();
    }
}
