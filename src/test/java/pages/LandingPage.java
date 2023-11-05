package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage{

    @FindBy (css = "img[src='https://i.imgur.com/klEjqaL.jpg']")
    private WebElement testUser1234;

    @FindBy (css = ".post-feed-img")
    private WebElement clickImage;

    @FindBy (css = ".far.fa-heart.fa-2x")
    private WebElement likeButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }
    public void visibilityOfTestUser(){
        wait.until(ExpectedConditions.visibilityOf(testUser1234));
    }
    public void imgClick() {
        clickElement(clickImage);
    }
    public void likeButton (){
        wait.until(ExpectedConditions.visibilityOf(likeButton));
        clickElement(likeButton);
    }
}
