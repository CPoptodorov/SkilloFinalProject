package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{

    @FindBy(css = ".profile-user-settings > h2")
    private WebElement profileName;

    @FindBy(css = ".fa-user-edit")
    private WebElement editProfile;

    @FindBy(css = ".profile-edit-container")
    private WebElement modifyForm;

    @FindBy(css = "textarea[formcontrolname='publicInfo']")
    private WebElement publicInfo;

    @FindBy(css = ".offset-4 > .btn-primary")
    private WebElement saveButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
        //matches title to username 1:57
    public String getUsernameTitle() {
        wait.until(ExpectedConditions.visibilityOf(profileName));
        return profileName.getText();
    }
    public void clickEditProfile() {
        clickElement(editProfile);
    }
    public void visibilityOfModifyForm() {
        wait.until(ExpectedConditions.visibilityOf(modifyForm));
    }
    public void clickPublicInfo() {
        clickElement(publicInfo);
        publicInfo.clear();
    }
    public void editProfileInfo(String profileInfo) {
        sendText(publicInfo, profileInfo);
    }
    public void pressSaveButton(){
        clickElement(saveButton);
    }
}
