package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class SearchButtonNotWorking extends BaseTest{

    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials() {
        return new Object[][]{
                {"Constantin_user", "Test1234"}
        };
    }

    @Test(dataProvider = "loginCredentials")
    public void BrokenSearchButton(String username, String password) {
        System.out.println("1. Go to Homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomeURL();

        System.out.println("2. Click on Login button");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        System.out.println("3. Verify Login URL");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyURL(loginPage.LOGIN_URL);

        System.out.println("4. Verify Sign in Form");
        loginPage.visibilityOfSignInForm();

        System.out.println("5. Populate Login and Password");
        loginPage.populateLogin(username, password);

        System.out.println("6. Click sign in button");
        loginPage.clickSignInButton();

        System.out.println("7. Verify profile link is present");
        headerPage.visibilityOfProfileLink();

        System.out.println("8.Verify visibility and Click Search Bar");
        headerPage.clickSearchBar();

        System.out.println("10. Populate search bar");
        headerPage.populateSearchBar("Constantin_user");

        System.out.println("11. Click Search bar button");
        headerPage.clickSearchBarButton();

        System.out.println("12. Verify only the searched user name is visible");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.visibilityOfTestUser();

    }
}
