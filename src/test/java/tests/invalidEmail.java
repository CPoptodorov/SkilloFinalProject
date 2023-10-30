package tests;

import org.testng.annotations.DataProvider;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class invalidEmail {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @DataProvider(name = "invalidEmail")
    public Object[][] invalidEmailInput() {
        return new Object[][]{
                {"auto_user", "invalidemail.com", "auto_pass"}
        };
    }
    @Test(dataProvider = "invalidEmail")
    public void invalidEmail(String username, String email, String password) {

        /*
        1. Go to Homepage
        2. Login button click
        3. Check correct login URL
        4. Check if Sign in form is visible
        5. Verify Register button is visible
        6. Click Register button
        7. Verify Register URL
        8. Verify visibility of registration form
        9. Verify Sign in button is visible
        10. Populate valid username
        11. Populate invalid email
        12. Populate valid password
        13. Populate valid matching password
        14. Confirm error message for invalid email populated
        15. Click Sign in button
        */

        System.out.println("1. Go to homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomeURL();

        // Since the login button is part of the HeaderPage we want to use that method
        // To use is we create a new object from type HeaderPage, and apply the driver within the page
        // The driver has already been defined in this page
        System.out.println("2 Login button click");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        // To use is we create a new object from type LoginPage, and apply the driver within the page
        // Login url is inside the LoginPage as a variable and by calling it we verify the correct URL
        System.out.println("3. Check correct login URL");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyURL(loginPage.LOGIN_URL);

        // LoginPage has already been created, so we just use the method to call visibilityOfSignInForm
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

    @AfterMethod
    public void cleanup() {
        driver.close();
    }
}
