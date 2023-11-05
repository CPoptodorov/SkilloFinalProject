package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;


public class PasswordMismatchRegistration extends BaseTest{

    @DataProvider(name = "passwordMismatch")
    public Object[][] passwordMismatchInput() {
        return new Object[][]{
                {"NonExistantUser1", "Validemail@gmail.com", "pass123", "password"}
        };
    }

    @Test(dataProvider = "passwordMismatch")
    public void passwordMismatchRegistration(String username, String email, String password, String confirmPassword) {


        System.out.println("1. Go to Homepage");
        HomePage homepage = new HomePage(driver);
        homepage.navigateToHomeURL();

        System.out.println("2. Login Button click");
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        System.out.println("3. Check correct login URL");
        loginPage.verifyURL(loginPage.LOGIN_URL);

        System.out.println("4. Check if sign in form is visible");
        loginPage.visibilityOfSignInForm();

        System.out.println("5. Verify Register button is visible");
        loginPage.visibilityOfRegisterButton();

        System.out.println("6. Click Register button");
        loginPage.clickRegisterLink();

        System.out.println("7. Verify Register URL");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.verifyURL(registrationPage.REG_URL);

        System.out.println("8. Verify visibility of registration form");
        registrationPage.visibilityOfRegForm();

        System.out.println("9. Verify Sign In button is visible");
        registrationPage.visibilityOfSignInButton();

        System.out.println("10. Populate valid username");
        registrationPage.populateUsername(username);

        System.out.println("11. Populate valid email");
        registrationPage.populateEmail(email);

        System.out.println("12. Populate valid password");
        registrationPage.populatePassword(password);

        System.out.println("13. Populate mismatching password");
        registrationPage.populateConfirmPass(confirmPassword);

        System.out.println("14. Confirm error message for password mismatch");
        registrationPage.passMismatchError();

        System.out.println("15. Click Sign in button");
        registrationPage.clickSignInButton();

    }
}
