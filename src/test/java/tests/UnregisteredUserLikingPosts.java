package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;


public class UnregisteredUserLikingPosts extends BaseTest {

    @Test
    public void unregisteredUserLikingPosts() {
        System.out.println("1. Go to Homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomeURL();

        System.out.println("2. Verify visibility of Login button");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.visibilityOfLoginLink();

        System.out.println("3. Click on an image");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.imgClick();

        System.out.println("4. Verify visibility and click of like button");
        landingPage.likeButton();

        System.out.println("5. Verify Login URL");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyURL(loginPage.LOGIN_URL);

        System.out.println("6. Verify message for non registered user");
        loginPage.visibility0fToastMessage();
    }
}