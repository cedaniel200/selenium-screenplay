package com.cedaniel200.saucedemo.tasks;

import com.cedaniel200.automation.screenplay.actions.Action;
import com.cedaniel200.saucedemo.pages.InventoryPage;
import org.openqa.selenium.WebDriver;

public class AddProductToCart implements Action {

    private final String product;

    public AddProductToCart(String product) {
        this.product = product;
    }

    @Override
    public void perform(WebDriver browser) {
        new InventoryPage(browser).addToCart(product).click();
    }

    public static Action the(String product) {
        return new AddProductToCart(product);
    }
}
