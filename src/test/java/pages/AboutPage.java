package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutPage {

    WebDriver driver;

    By aboutUsMenu = By.xpath("//a[contains(text(), 'About us')]");
    By playAboutUs = By.id("example-video");
    By closeAboutUs = By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button");
    By aboutUsTitle = By.id("videoModalLabel");

        public AboutPage (WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.demoblaze.com/index.html");
    }
    public void userClickAboutUsMenu() {
        driver.findElement(aboutUsMenu).click();
    }

    public void validateAbousUsMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUsTitle));
        Assertions.assertTrue(title.isDisplayed());
        assertEquals("About us", title.getText());
    }

    public void userPlayVideoFromAboutUsForGetInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(playAboutUs));
        assertTrue(title.isDisplayed());
    }

    public void userClickCloseButtonFromAboutUs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closeElement = wait.until(ExpectedConditions.elementToBeClickable(closeAboutUs));
        closeElement.click();
    }
}
