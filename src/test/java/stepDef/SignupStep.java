package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.SignupPage;

public class SignupStep extends BaseTest {
    SignupPage signupPage;
    public SignupStep() {
        signupPage = new SignupPage(driver);
    }
    @When("user click sign up menu")
    public void userClickSignUpMenu() {
        signupPage = new SignupPage(driver);
        signupPage.userClickSignUpMenu();
    }

    @And("user input form username {string}")
    public void userInputFormUsernameUsername(String username) {
        signupPage.userInputFormUsernameUsername(username);
    }

    @And("user input form password {string}")
    public void userInputFormPasswordPassword(String password) {
        signupPage.userInputFormPasswordPassword(password);
    }

    @And("user click sign up button")
    public void userClickSignUpButton() {
        signupPage.userClickSignUpButton();
    }

    @Then("user see a message alert {string}")
    public void userSeeAMessageAlert(String alertTextMessage) throws InterruptedException {
        Thread.sleep(1500);
        signupPage = new SignupPage(driver);
        signupPage.userSeeAlertText(alertTextMessage);
    }
}
