package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{

    public String REG_URL = "http://training.skillo-bg.com:4200/users/register";

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

    @FindBy (xpath = "//span[contains(text(), ' Passwords do not match! ')]")
    private WebElement mismatchPassword;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void visibilityOfRegForm() {
        wait.until(ExpectedConditions.visibilityOf(registerForm));
    }
    public void populateUsername(String username) {
        sendText(usernameField, username);
    }
    public void populateEmail(String email) {
        sendText(emailField, email);;
    }
    public void populatePassword(String password) {
        sendText(passwordField, password);
    }
    public void populateConfirmPass(String confirmPassword) {
        sendText(confirmPasswordField, confirmPassword);
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
    public void passMismatchError() {
        wait.until(ExpectedConditions.visibilityOf(mismatchPassword));
    }
}