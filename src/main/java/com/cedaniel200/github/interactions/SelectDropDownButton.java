package com.cedaniel200.github.interactions;

import com.cedaniel200.github.model.GitIgnore;
import com.cedaniel200.github.model.License;
import com.cedaniel200.github.screenplay.Action;
import com.cedaniel200.github.userinterfaces.CreateNewRepositoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.Callable;

import static com.cedaniel200.github.userinterfaces.CreateNewRepositoryPage.SELECTOR_FORMAT_GITIGNORE;
import static com.cedaniel200.github.userinterfaces.CreateNewRepositoryPage.SELECTOR_FORMAT_LICENSE;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class SelectDropDownButton implements Action {

    private WebElement button;
    private WebElement filter;
    private final Enum type;
    private final String valueFilter;
    private final String cssSelectorForElementSelected;

    public SelectDropDownButton(Enum type, String valueFilter, String selectorForElementSelected) {
        this.type = type;
        this.valueFilter = valueFilter;
        this.cssSelectorForElementSelected = selectorForElementSelected;
    }

    public static SelectDropDownButton addGitIgnoreFilteringBy(GitIgnore valueFilter) {
        return new SelectDropDownButton(GitIgnore.NONE, valueFilter.toString(),
                String.format(SELECTOR_FORMAT_GITIGNORE, valueFilter));
    }

    public static SelectDropDownButton addLicenseFilteringBy(License valueFilter) {
        return new SelectDropDownButton(License.NONE, valueFilter.toString(),
                String.format(SELECTOR_FORMAT_LICENSE, valueFilter));
    }

    @Override
    public void perform(WebDriver driver) {
        init(driver);

        button.click();
        filter.sendKeys(valueFilter);

        WebElement selectedItem = driver.findElement(By.xpath(cssSelectorForElementSelected));
        await().forever().pollInterval(1, SECONDS).until(isNotNull(selectedItem));
        selectedItem.click();
    }

    private void init(WebDriver driver) {
        CreateNewRepositoryPage createNewRepositoryPage = PageFactory.initElements(driver, CreateNewRepositoryPage.class);
        this.button = type instanceof  GitIgnore ?
                createNewRepositoryPage.addGitignore :
                createNewRepositoryPage.addLicense;

        this.filter = type instanceof  GitIgnore ?
                createNewRepositoryPage.filterGitignore :
                createNewRepositoryPage.filterLicense;
    }

    private Callable<Boolean> isNotNull(WebElement element) {
        return () -> element != null;
    }

}
