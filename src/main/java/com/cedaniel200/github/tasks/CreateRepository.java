package com.cedaniel200.github.tasks;

import com.cedaniel200.github.exceptions.RepositoryAlreadyExistsError;
import com.cedaniel200.github.interactions.SelectDropDownButton;
import com.cedaniel200.github.model.GitIgnore;
import com.cedaniel200.github.model.License;
import com.cedaniel200.github.model.Repository;
import com.cedaniel200.github.screenplay.Action;
import com.cedaniel200.github.userinterfaces.CreateNewRepositoryPage;
import com.cedaniel200.github.userinterfaces.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static com.cedaniel200.github.exceptions.RepositoryAlreadyExistsError.withMessageBy;
import static com.cedaniel200.github.screenplay.Actors.theActorInTheSpotlight;
import static com.cedaniel200.github.utils.Validations.isNotEmptyOrNull;

public class CreateRepository implements Action {

    private final Repository repository;
    private Actions attemptsTo;
    private CreateNewRepositoryPage createNewRepositoryPage;
    private HomePage homePage;

    public CreateRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void perform(WebDriver driver) {
        init(driver);

        homePage.newRepository.click();
        createNewRepositoryPage.repositoryName.sendKeys(repository.getName());

        if (createNewRepositoryPage.messageRepositoryAlreadyExists.isDisplayed())
            throw new RepositoryAlreadyExistsError(withMessageBy(repository.getName()));

        if (isNotEmptyOrNull(repository.getDescription()))
            createNewRepositoryPage.repositoryDescription.sendKeys(repository.getDescription());

        if (repository.isInitializeWithREADME())
            createNewRepositoryPage.initializeRepositoryWithReadme.click();

        attemptsTo.moveToElement(createNewRepositoryPage.createRepository);

        if (repository.getGitIgnore() != GitIgnore.NONE)
            theActorInTheSpotlight().attemptsTo(SelectDropDownButton.addGitIgnoreFilteringBy(repository.getGitIgnore()));

        if (repository.getLicense() != License.NONE)
            theActorInTheSpotlight().attemptsTo(SelectDropDownButton.addLicenseFilteringBy(repository.getLicense()));

        createNewRepositoryPage.createRepository.click();
    }

    private void init(WebDriver driver) {
        attemptsTo = new Actions(driver);
        createNewRepositoryPage = PageFactory.initElements(driver, CreateNewRepositoryPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    private boolean not(boolean result) {
        return !result;
    }

    public static CreateRepository withTheFollowingData(Repository repository) {
        return new CreateRepository(repository);
    }
}
