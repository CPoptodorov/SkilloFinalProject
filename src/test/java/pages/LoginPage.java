package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";

    //initializing the WebDriver ( it's just driver because of the usability for all browser and not just ChromeDriver)
    private WebDriver driver;

    //initializing of wait so that we can add it to the constructor to avoid redundant code and not use a wait in every method e.g. populateUserName.. etc
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    private WebDriverWait wait;

    @FindBy(css = ".text-center.form-container")
    private WebElement loginForm;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(css = ".remeber-me-button")
    private WebElement rememberCheckBox;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(css = ".text-center.form-container")
    private WebElement singInForm;

    //Constructor in which we initialize driver and user PageFactory class, so we can use @FindBy
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //because of this class we can use @FindBy
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    //Method for waiting of an element to be clickable and clicking of the element to avoid redundant code for every element click e.g. clickSignInButton
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void verifyURL() {
        wait.until(ExpectedConditions.urlToBe(LOGIN_URL));
    }
    public void visibilityOfSignInForm() {
        wait.until(ExpectedConditions.visibilityOf(singInForm));
    }
    public void populateUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }
    public void populatePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }
    public void clickSignInButton() {
        clickElement(signInButton);
    }
    public void clickRegisterLink() {
        clickElement(registerLink);
    }
    public void visibilityOfRegisterButton() {
        wait.until(ExpectedConditions.visibilityOf(registerLink));
    }
}
