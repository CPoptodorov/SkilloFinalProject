package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HeaderPage extends BasePage {

    @FindBy(id = "nav-link-home")
    private WebElement homeLink;

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;

    @FindBy(id = "nav-link-new-post")
    private WebElement newPostLink;

    @FindBy(id = "search-bar")
    private WebElement searchBarField;

    @FindBy(css = ".fa-search")
    private WebElement searchBarButton;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void visibilityOfLoginLink() {
        wait.until(ExpectedConditions.visibilityOf(loginLink));
    }

    public void goToLogin() {
        clickElement(loginLink);
    }

    public void goToProfileLink() {
        clickElement(profileLink);
    }

    public void visibilityOfProfileLink() {
        wait.until(ExpectedConditions.visibilityOf(profileLink));
    }

    public void clickSearchBar() {
        wait.until(ExpectedConditions.visibilityOf(searchBarField));
        clickElement(searchBarField);
    }

    public void populateSearchBar(String searchBar) {
        sendText(searchBarField, searchBar);
    }

    public void clickSearchBarButton() {
        clickElement(searchBarButton);
    }
}