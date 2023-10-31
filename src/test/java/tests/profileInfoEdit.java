package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class profileInfoEdit {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials() {
        return new Object[][]{
                {"Constantin_user", "Test1234", "GGGG31321"}
        };
    }

    @Test(dataProvider = "loginCredentials")
    public void profileInfoEdit(String username, String password, String profileInfo) {

        System.out.println("1. Go to Homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomeURL();

        System.out.println("2. Click on Login button");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        System.out.println("3. Verify login URL");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyURL(loginPage.LOGIN_URL);

        System.out.println("4. Verify Sign in Form");
        loginPage.visibilityOfSignInForm();

        System.out.println("5. Populate username");
        loginPage.populateLogin(username, password);

        System.out.println("6. Click Sign in button");
        loginPage.clickSignInButton();

        System.out.println("7. Verify Profile link visibility");
        headerPage.visibilityOfProfileLink();

        System.out.println("8. Click Profile Link");
        headerPage.goToProfileLink();

        System.out.println("9. Verify username");
        ProfilePage profilePage = new ProfilePage(driver);
        String actualUsernameTitle = profilePage.getUsernameTitle();
        Assert.assertEquals(actualUsernameTitle, "Constantin_user", "Username is incorrect");

        System.out.println("10. Click Edit Profile");
        profilePage.clickEditProfile();

        System.out.println("11. Verify Visibility of Modify Profile");
        profilePage.visibilityOfModifyForm();

        System.out.println("12. Click Public info field");
        profilePage.clickPublicInfo();

        System.out.println("13. Edit public info");
        profilePage.editProfileInfo(profileInfo);

        System.out.println("14. Press Save Button");
        profilePage.pressSaveButton();
    }

    @AfterMethod
    public void cleanup(){
        driver.close();
    }
}



