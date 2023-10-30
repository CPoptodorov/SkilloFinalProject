package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HeaderPage extends BasePage{

    @FindBy(id = "nav-link-home")
    private WebElement homeLink;

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;

    @FindBy(id = "nav-link-new-post")
    private WebElement newPostLink;

    @FindBy(id = "search-bar")
    private WebElement searchBar;

    @FindBy(xpath = "//a[text()='pesho123456789']")
    private WebElement followUser;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void goToHome() {
        clickElement(homeLink);
    }
    public void goToLogin() {
        clickElement(loginLink);
    }
    public void visibilityOfLoginLink() {
        wait.until(ExpectedConditions.visibilityOf(loginLink));
    }
    public void goToProfileLink() {
        clickElement(profileLink);
    }
    public void visibilityOfProfileLink() {
        wait.until(ExpectedConditions.visibilityOf(profileLink));
    }
    public void goToPostLink() {
        clickElement(newPostLink);
    }
    public void visibilityOfNewPost() {
        wait.until(ExpectedConditions.visibilityOf(newPostLink));
    }
    public void clickSearchBar() {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        clickElement(searchBar);
        searchBar.sendKeys("pesho123456789");
    }
    public void clickFollowUser() {
        wait.until(ExpectedConditions.visibilityOf(followUser));
        clickElement(followUser);
    }
}