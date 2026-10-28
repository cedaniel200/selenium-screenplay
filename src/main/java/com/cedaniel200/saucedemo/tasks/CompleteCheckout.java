package com.cedaniel200.saucedemo.tasks;

import com.cedaniel200.automation.screenplay.actions.Action;
import com.cedaniel200.automation.screenplay.utils.Wait;
import com.cedaniel200.saucedemo.model.Customer;
import com.cedaniel200.saucedemo.pages.CartPage;
import com.cedaniel200.saucedemo.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CompleteCheckout implements Action {

    private final Customer customer;

    public CompleteCheckout(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void perform(WebDriver browser) {
        CartPage cartPage = new CartPage(browser);
        Wait.inThis(browser).until(elementToBeClickable(cartPage.checkout)).click();

        CheckoutPage checkoutPage = new CheckoutPage(browser);
        Wait.inThis(browser).until(visibilityOf(checkoutPage.firstName));

        checkoutPage.firstName.click();
        checkoutPage.firstName.sendKeys(customer.firstName());
        checkoutPage.lastName.click();
        checkoutPage.lastName.sendKeys(customer.lastName());
        checkoutPage.postalCode.click();
        checkoutPage.postalCode.sendKeys(customer.postalCode());
        checkoutPage.continueButton.click();
        Wait.inThis(browser).until(elementToBeClickable(checkoutPage.finishButton)).click();
    }

    public static Action with(Customer customer) {
        return new CompleteCheckout(customer);
    }
}
