package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BasePage {

    //initializing the WebDriver ( it's just driver because of the usability for all browser and not just ChromeDriver)
    WebDriver driver;

    //initializing of wait so that we can add it to the constructor to avoid redundant code and not use a wait in every method e.g. populateUserName.. etc
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    WebDriverWait wait;

    //Constructor in which we initialize driver and user PageFactory class, so we can use @FindBy
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //because of this class we can use @FindBy
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public void verifyURL(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }
    //Method for waiting of an element to be clickable and clicking of the element to avoid redundant code for every element click e.g. clickElement(signInButton);
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    //Method for visibility of element and send keys e.g sendText(usernameField, username);
    public void sendText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

  //  public void uploadFile (File file) {
   //     fileInput.send
}

