Skillo Final Project
Automation testing with Java and WebDriver sk10

- The tests are made using Java, Selenium WebDriver, Maven and TestNG
- Tests are made using Page Object Model and Page Factory
- Tests are made against http://training.skillo-bg.com:4200/posts/all

Test Description:
1) Registration using invalid Email. 
- User is populating an invalid email address when filling registration form
2) Registration using mismatching passwords.
- User is using two different inputs for password and confirm password when filling registration form
3) Editing profile information.
- User is populating the information inside the profile page
4) Search bar button not working.
- User is using search bar and pressing the search button. Search button does not work and the test will always fail and will make screenshots. If functionality of the seach bar button is fixed test will pass normally
