package com.cedaniel200.github.stepdefinitions;

import com.cedaniel200.github.model.Repository;
import com.cedaniel200.github.model.User;
import com.cedaniel200.github.questions.TheRepository;
import com.cedaniel200.github.tasks.CreateRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cedaniel200.github.model.GitIgnore.JAVA;
import static com.cedaniel200.github.model.License.MIT;
import static com.cedaniel200.github.screenplay.Actors.theActorCalled;
import static com.cedaniel200.github.screenplay.Actors.theActorInTheSpotlight;
import static com.cedaniel200.github.tasks.Authenticator.authenticate;

public class CreateRepositoryInGitHubStepDefinition {

    private static final String GITHUB_USER = System.getProperty("user");
    private static final String SECRET = System.getProperty("password");

    public static final String REPOSITORY_NAME = "TEST_BDD";
    private static final String BASE_URL_OF_REPOSITORY_CREATED = String.format("https://github.com/%s/%s",
            GITHUB_USER, REPOSITORY_NAME);

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
                CreateRepository.withTheFollowingData(
                        Repository.builder()
                                .name(REPOSITORY_NAME)
                                .description("repository for bdd tests")
                                .initializeWithREADME(true)
                                .gitIgnore(JAVA)
                                .license(MIT)
                                .build()
                )
        );
    }

    @Then("^Cesar should see the repository created$")
    public void shouldSeeTheRepositorioCreated() {
        theActorInTheSpotlight().shouldSeeThat(driver -> driver.getCurrentUrl().equals(BASE_URL_OF_REPOSITORY_CREATED));
        theActorInTheSpotlight().shouldSeeThat(TheRepository.nameIs(REPOSITORY_NAME));
    }
}
