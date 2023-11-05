package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;


public class InvalidEmailRegistration extends BaseTest{

    @DataProvider(name = "invalidEmail")
    public Object[][] invalidEmailInput() {
        return new Object[][]{
                {"auto_user", "invalidemail.com", "auto_pass"}
        };
    }
    @Test(dataProvider = "invalidEmail")
    public void invalidEmailRegistration(String username, String email, String password) {

        System.out.println("1. Go to homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomeURL();

        System.out.println("2 Login button click");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        System.out.println("3. Check correct login URL");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyURL(loginPage.LOGIN_URL);

        System.out.println("4. Verify visibility of Sign In Form");
        loginPage.visibilityOfSignInForm();

        System.out.println("5. Verify Register button is visible ");
        loginPage.visibilityOfRegisterButton();

        System.out.println("6. Click Register button");
        loginPage.clickRegisterLink();

        System.out.println("7. Verify Register URL link");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.verifyURL(registrationPage.REG_URL);

        System.out.println("8. Verify visibility of register form");
        registrationPage.visibilityOfRegForm();

        System.out.println("9. Verify 'Sign in' button is visible");
        registrationPage.visibilityOfSignInButton();

        System.out.println("10. Populate valid username");
        registrationPage.populateUsername(username);

        System.out.println("11. Populate invalid email");
        registrationPage.populateEmail(email);

        System.out.println("12. Populate valid password");
        registrationPage.populatePassword(password);

        System.out.println("13. Populate valid matching password");
        registrationPage.populateConfirmPass(password);

        System.out.println("14. Confirm error message for invalid email populated");
        registrationPage.visibilityOfSignInButton();

        System.out.println("15. Click Sign in Button");
        registrationPage.invalidEmailMessage();
    }
}
