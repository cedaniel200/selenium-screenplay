package com.cedaniel200.github.stepdefinitions;

import com.cedaniel200.github.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cedaniel200.github.tasks.Authenticator.authenticate;

public class CreateRepositoryInGitHubStepDefinition {

    @Given("^Cesar wants to start versioning$")
    public void startVersioning() {
        authenticate(new User());
    }

    @When("^Cesar creates a repository$")
    public void createRepository() {

    }

    @Then("^Cesar should see the repository created$")
    public void shouldSeeTheRepositorioCreated() {

    }
}
