package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AboutPage;
import pages.BaseTest;

public class AboutStep extends BaseTest {

    AboutPage aboutPage;

    public AboutStep() {
        aboutPage = new AboutPage(driver);
    }
    @When("user click about us menu")
    public void userClickAboutUsMenu() throws InterruptedException {
        Thread.sleep(1500);
        aboutPage.userClickAboutUsMenu();
    }

    @And("user validate to about us menu")
    public void userValidateToAboutUsMenu() {
        aboutPage.validateAbousUsMenu();
    }

    @And("user play video from about us for get information")
    public void userPlayVideoFromAboutUsForGetInformation() {
        aboutPage.userPlayVideoFromAboutUsForGetInformation();
    }

    @And("user click close button from about us")
    public void userClickCloseButtonFromAboutUs() {
        aboutPage.userClickCloseButtonFromAboutUs();
    }


}
