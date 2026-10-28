package com.cedaniel200.saucedemo.stepdefinitions;

import com.cedaniel200.saucedemo.model.Customer;
import com.cedaniel200.saucedemo.questions.OrderConfirmed;
import com.cedaniel200.saucedemo.questions.ProductInCart;
import com.cedaniel200.saucedemo.tasks.AddProductToCart;
import com.cedaniel200.saucedemo.tasks.CompleteCheckout;
import com.cedaniel200.saucedemo.tasks.GoToCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cedaniel200.automation.screenplay.sop.Actors.theActorInTheSpotlight;

public class PurchaseSteps {

    @Given("Cesar agrega una mochila al carrito")
    public void addBackpackToCart() {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.the("sauce-labs-backpack")
        );
    }

    @When("Cesar abre el carrito")
    public void openCart() {
        theActorInTheSpotlight().attemptsTo(GoToCart.now());
    }

    @Then("Cesar ve un producto en el carrito")
    public void seesOneProductInCart() {
        theActorInTheSpotlight().shouldSeeThat(new ProductInCart(1));
    }

    @When("Cesar completa el checkout con sus datos")
    public void completeCheckout() {
        theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.with(new Customer("Cesar", "Daniel", "110111"))
        );
    }

    @Then("Cesar ve la confirmación de la compra")
    public void seesOrderConfirmation() {
        theActorInTheSpotlight().shouldSeeThat(new OrderConfirmed());
    }
}
