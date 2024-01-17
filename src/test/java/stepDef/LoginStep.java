package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.LoginPage;

public class LoginStep extends BaseTest {

    LoginPage loginPage;
    public LoginStep() {
        loginPage = new LoginPage(driver);
    }

    @When("user click login menu")
    public void userClickLoginMenu() throws InterruptedException {
        Thread.sleep(1500);
        loginPage.userClickLoginMenu();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        loginPage.userInputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        loginPage.userInputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.userClickLoginButton();
    }

    @And("user successfully login with valid username and password")
    public void userSuccessfullyLoginWithValidUsernameAndPassword() {
        loginPage.userSuccessfullyLoginWithValidUsernameAndPassword();
    }

    @And("user click close button")
    public void userClickCloseButton() throws InterruptedException {
        loginPage.userClickCloseButton();
    }


    @And("user click logout menu")
    public void userClickLogoutMenu() throws InterruptedException {
        Thread.sleep(1500);
        loginPage.userClickLogoutMenu();
    }
}



