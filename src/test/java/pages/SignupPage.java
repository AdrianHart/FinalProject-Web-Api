package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignupPage {

    WebDriver driver;
    By signUpMenu = By.xpath("//*[@id=\"signin2\"]");
    By signUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    By usernameFormSignup = By.xpath("//*[@id=\"sign-username\"]");
    By passwordFormSignup = By.xpath("//*[@id=\"sign-password\"]");

    public SignupPage(@NotNull WebDriver driver) {
        this.driver = driver;
    }

    public void userClickSignUpMenu() {
        driver.findElement(signUpMenu).click();
    }

    public void userClickSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
        assertTrue(title.isDisplayed());
        assertEquals("Sign up", title.getText());
    }

    public void userInputFormUsernameUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(usernameFormSignup));
        usernameInput.findElement(usernameFormSignup).sendKeys(username);
    }

    public void userInputFormPasswordPassword(String password) {
        driver.findElement(passwordFormSignup).sendKeys(password);
    }
    public void userSeeAlertText(String alertTextMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), alertTextMessage);
        alert.accept();
    }
}
