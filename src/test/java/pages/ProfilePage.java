package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage{

    @FindBy(css = ".profile-user-settings > h2")
    private WebElement profileTitle;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
        //matches title to username 1:57
    public String getUsernameTitle() {
        wait.until(ExpectedConditions.visibilityOf(profileTitle));
        return profileTitle.getText();
    }
}
