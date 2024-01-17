package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.HomePage;

public class HomeStep extends BaseTest {

    HomePage homePage = new HomePage(driver);

    @Given("user is on home page")
    public void userIsOnHomePage() {
        homePage.userIsOnHomePage();
    }

    @And("user validate to home page")
    public void userValidateToHomePage() {
        homePage.validateOnHomePage();
    }
    @When("user see all products on the first page")
    public void userSeeAllProductsOnTheFirstPage() throws InterruptedException {
        Thread.sleep(1500);
        homePage.userSeeAllProductsOnTheFirstPages(driver);
    }

    @And("user click next menu")
    public void userClickNextMenu() throws InterruptedException {
        Thread.sleep(1500);
        homePage.userClickNextMenu();
    }

    @And("user see all products on the second page")
    public void userSeeAllProductsOnTheSecondPage() throws InterruptedException {
        Thread.sleep(1500);
        homePage.userSeeAllProductsOnTheSecondPages();
    }

    @And("user click previous menu")
    public void userClickPreviousMenu() throws InterruptedException {
        Thread.sleep(1500);
        homePage.userClickPreviousMenu();
    }

    @And("user click Product Store on top left")
    public void userClickProductStoreOnTopLeft() {
        homePage.userClickProductStoreOnTopLeft();
    }

    @Then("user will be directed to first page")
    public void userWillBeDirectedToFirstPage() throws InterruptedException {
        Thread.sleep(1500);
        homePage.userSeeAllProductAfterClickPreviousButton();
    }

    @Then("user will be directed to home page")
    public void userWillBeDirectedToHomePage() {
        homePage.validateOnHomePage();
    }
}
