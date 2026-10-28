package com.cedaniel200.saucedemo.stepdefinitions;

import com.cedaniel200.automation.screenplay.sop.Actors;
import com.cedaniel200.automation.screenplay.utils.DriverFactory;
import com.cedaniel200.saucedemo.model.User;
import com.cedaniel200.saucedemo.questions.InventoryVisible;
import com.cedaniel200.saucedemo.questions.LoginError;
import com.cedaniel200.saucedemo.tasks.Authenticate;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cedaniel200.automation.screenplay.sop.Actors.theActorCalled;
import static com.cedaniel200.automation.screenplay.sop.Actors.theActorInTheSpotlight;

public class CommonSteps {

    private static final String BASE_URL = System.getProperty("base.url", "https://www.saucedemo.com");

    @Before
    public void setUp() {
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        Actors.reset();
    }

    @Given("Cesar está en saucedemo")
    public void openSaucedemo() {
        DriverFactory.getDriver().get(BASE_URL);
        theActorCalled("Cesar");
    }

    @When("Cesar inicia sesión como usuario estándar")
    public void signInAsStandardUser() {
        theActorInTheSpotlight().attemptsTo(
                Authenticate.with(new User("standard_user", "secret_sauce"))
        );
    }

    @When("Cesar inicia sesión como usuario bloqueado")
    public void signInAsLockedUser() {
        theActorInTheSpotlight().attemptsTo(
                Authenticate.with(new User("locked_out_user", "secret_sauce"))
        );
    }

    @Then("Cesar ve el inventario")
    public void seesInventory() {
        theActorInTheSpotlight().shouldSeeThat(new InventoryVisible());
    }

    @Then("Cesar ve el mensaje de usuario bloqueado")
    public void seesLockedUserMessage() {
        theActorInTheSpotlight().shouldSeeThat(
                new LoginError("Sorry, this user has been locked out.")
        );
    }
}
