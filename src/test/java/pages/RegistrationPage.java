package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private String REG_URL = "http://training.skillo-bg.com:4200/users/register";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".form-container")
    private WebElement registerForm;

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement usernameField;

    @FindBy(css = "input[formcontrolname='email']")
    private WebElement emailField;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement passwordField;

    @FindBy(css = "input[formcontrolname='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy (xpath = "//span[contains(text(), 'Email invalid!')]")
    private WebElement invalidEmailMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //because of this class we can use @FindBy
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void visibilityOfRegForm() {
        wait.until(ExpectedConditions.visibilityOf(registerForm));
    }
    public void populateUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }
    public void populateEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }
    public void populatePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }
    public void populateConfirmPass(String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        confirmPasswordField.sendKeys(confirmPassword);
    }
    public void invalidEmailMessage(){
        wait.until(ExpectedConditions.visibilityOf(invalidEmailMessage));
    }
    public void visibilityOfSignInButton(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
    }
    public void clickSignInButton(){
        clickElement(signInButton);
    }
}