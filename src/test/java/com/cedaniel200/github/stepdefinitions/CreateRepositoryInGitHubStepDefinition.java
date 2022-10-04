package com.cedaniel200.github.stepdefinitions;

import com.cedaniel200.github.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cedaniel200.github.screenplay.Actors.theActorCalled;
import static com.cedaniel200.github.screenplay.Actors.theActorInTheSpotlight;
import static com.cedaniel200.github.tasks.Authenticator.authenticate;

public class CreateRepositoryInGitHubStepDefinition {

    private static final String GITHUB_USER = System.getProperty("user");
    private static final String SECRET = System.getProperty("password");

    @Given("^Cesar wants to start versioning$")
    public void startVersioning() {
        theActorCalled("Cesar").wasAbleTo(
                authenticate(User.builder()
                        .username(GITHUB_USER)
                        .passwork(SECRET).build())
        );
    }

    @When("^Cesar creates a repository$")
    public void createRepository() {
        theActorInTheSpotlight().attemptsTo(

        );
    }

    @Then("^Cesar should see the repository created$")
    public void shouldSeeTheRepositorioCreated() {

    }
}
