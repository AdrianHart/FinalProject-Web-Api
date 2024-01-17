package pages;

import helper.Utility;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static helper.Utility.validateProductPresence;

public class HomePage {
    private WebDriver driver;
    By productStoreTitle = By.xpath("//*[@id=\"nava\"]");
    By nextButton = By.id("next2");
    By previousButton = By.id("prev2");
    By productPicture = By.cssSelector("[class=\"col-lg-4 col-md-6 mb-4\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void userIsOnHomePage() {
        if (driver != null) {
            driver.get("https://www.demoblaze.com/index.html");
        } else {
            System.out.println("WebDriver is null.");
        }
    }

    public void validateOnHomePage() {
        WebElement productElement = driver.findElement(productStoreTitle);
        Assertions.assertTrue(productElement.isDisplayed());
        Assertions.assertEquals("PRODUCT STORE", productElement.getText());
    }

    public void userSeeAllProductsOnTheFirstPages(WebDriver driver) {
        List<String> expectedProductNames = Arrays.asList
                ("Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7",
                "Iphone 6 32gb", "Sony xperia z5", "HTC One M9", "Sony vaio i5", "Sony vaio i7");
        Utility.validateProductPresence(driver, productPicture, expectedProductNames);
    }

    public void userClickNextMenu() {
        driver.findElement(nextButton).click();
    }

    public void userClickPreviousMenu() {
        driver.findElement(previousButton).click();
    }

    public void userSeeAllProductsOnTheSecondPages() {
        List<String> expectedProductNames = Arrays.asList
                ("Apple monitor 24", "MacBook air", "Dell i7 8gb", "2017 Dell 15.6 Inch",
                "ASUS Full HD", "MacBook Pro");
        validateProductPresence(driver, productPicture, expectedProductNames);
    }

    public void userSeeAllProductAfterClickPreviousButton() {
        List<String> expectedProductNames = Arrays.asList
                ("Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7", "Iphone 6 32gb",
                "Sony xperia z5", "HTC One M9", "Sony vaio i5", "Sony vaio i7", "Apple monitor 24");
        validateProductPresence(driver, productPicture, expectedProductNames);
    }

    public void userClickProductStoreOnTopLeft() {
        driver.findElement(productStoreTitle).click();
    }
}
