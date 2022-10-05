package com.cedaniel200.github.tasks;

import com.cedaniel200.automation.screenplay.actions.Action;
import com.cedaniel200.automation.screenplay.actions.Check;
import com.cedaniel200.automation.screenplay.actions.Scroll;
import com.cedaniel200.automation.screenplay.utils.Wait;
import com.cedaniel200.github.exceptions.RepositoryAlreadyExistsError;
import com.cedaniel200.github.interactions.SelectDropDownButton;
import com.cedaniel200.github.model.GitIgnore;
import com.cedaniel200.github.model.License;
import com.cedaniel200.github.model.Repository;
import com.cedaniel200.github.userinterfaces.CreateNewRepositoryPage;
import com.cedaniel200.github.userinterfaces.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.function.Supplier;

import static com.cedaniel200.automation.screenplay.sop.Actors.theActorInTheSpotlight;
import static com.cedaniel200.github.exceptions.RepositoryAlreadyExistsError.withMessageBy;
import static com.cedaniel200.github.utils.Validations.isNotEmptyOrNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CreateRepository implements Action {

    private final Repository repository;
    private CreateNewRepositoryPage createNewRepositoryPage;
    private HomePage homePage;

    public CreateRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void perform(WebDriver browser) {
        init(browser);

        Wait.inCurrentBrowser().until(elementToBeClickable(homePage.newRepository));
        homePage.newRepository.click();
        createNewRepositoryPage.repositoryName.sendKeys(repository.getName());

        Check.upOnIf(repositoryAlreadyExists())
                .thenThrow(() -> new RepositoryAlreadyExistsError(withMessageBy(repository.getName())));

        Check.upOnIf(() -> isNotEmptyOrNull(repository.getDescription()))
                .then(() -> createNewRepositoryPage.repositoryDescription.sendKeys(repository.getDescription()));

        Check.upOnIf(() -> isNotEmptyOrNull(repository.getDescription()))
                .then(() -> createNewRepositoryPage.repositoryDescription.sendKeys(repository.getDescription()));

        Check.upOnIf(repository::isInitializeWithREADME)
                .then(() -> createNewRepositoryPage.initializeRepositoryWithReadme.click());


        Scroll.to(createNewRepositoryPage.createRepository);

        Check.upOnIf(() -> repository.getGitIgnore() != GitIgnore.NONE)
                .then(() -> theActorInTheSpotlight().attemptsTo(SelectDropDownButton
                        .addGitIgnoreFilteringBy(repository.getGitIgnore())));

        Check.upOnIf(() -> repository.getLicense() != License.NONE)
                .then(() -> theActorInTheSpotlight().attemptsTo(SelectDropDownButton
                        .addLicenseFilteringBy(repository.getLicense())));

        createNewRepositoryPage.createRepository.click();
    }

    private void init(WebDriver driver) {
        createNewRepositoryPage = PageFactory.initElements(driver, CreateNewRepositoryPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    private Supplier<Boolean> repositoryAlreadyExists() {
        return () -> {
            Wait.inCurrentBrowser().withTimeout(Duration.ofSeconds(2))
                    .until(visibilityOf(createNewRepositoryPage.messageRepositoryAlreadyExists));
            return createNewRepositoryPage.messageRepositoryAlreadyExists.isDisplayed();
        };
    }

    public static CreateRepository withTheFollowingData(Repository repository) {
        return new CreateRepository(repository);
    }
}
