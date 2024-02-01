package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.prefs.Preferences;

import static helper.Utility.generateRandomAlphabet;
import static helper.Utility.generateRandomNumeric;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignupPage {

    WebDriver driver;
    By signUpMenu = By.xpath("//*[@id=\"signin2\"]");
    By signUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    By usernameFormSignup = By.xpath("//input[@id='sign-username']");
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
        driver.findElement(signUpButton).click();
    }

    public void userInputFormUsernameUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(usernameFormSignup));
        usernameInput.findElement(usernameFormSignup).sendKeys(username);

        Preferences prefs = Preferences.userRoot().node("web.features");
        switch (username) {
            case "randomUser":
                String randomUsername = generateRandomAlphabet(12);
                driver.findElement(usernameFormSignup).sendKeys(randomUsername);
                prefs.put("createUser", randomUsername);
                break;
            case "randomNum":
                String randomNumber = generateRandomNumeric(10);
                driver.findElement(usernameFormSignup).sendKeys(randomNumber);
                break;
            case "existedUser":
                String existedUsername = prefs.get("createUser", null);
                driver.findElement(usernameFormSignup).sendKeys(existedUsername);
                break;
            default:
                driver.findElement(usernameFormSignup).sendKeys(username);
                break;
        }
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
