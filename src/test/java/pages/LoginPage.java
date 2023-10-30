package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";

    @FindBy(css = ".text-center.form-container")
    private WebElement loginForm;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(css = ".remember-me-button")
    private WebElement rememberCheckBox;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(css = ".text-center.form-container")
    private WebElement singInForm;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void visibilityOfSignInForm() {
        wait.until(ExpectedConditions.visibilityOf(singInForm));
    }
    public void populateUsername(String username) {
        sendText(usernameField, username);
    }
    public void populatePassword(String password) {
        sendText(passwordField, password);
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
