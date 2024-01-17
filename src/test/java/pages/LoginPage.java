package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    By loginMenu = By.cssSelector("[id=\"login2\"]");
    By usernameInputText = By.xpath("//*[@id=\"loginusername\"]");
    By passwordInputText= By.xpath("//*[@id=\"loginpassword\"]");
    By closeButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");
    By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By welcomeElement = By.id("nameofuser");
    By logoutMenu = By.cssSelector("[id=\"logout2\"]");


    public LoginPage(@NotNull WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void userClickLoginMenu() {
        driver.findElement(loginMenu).click();
    }

    public void userInputUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(usernameInputText));
        usernameInput.findElement(usernameInputText).sendKeys(username);
    }

    public void userInputPassword(String password) {
        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void userClickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void userSuccessfullyLoginWithValidUsernameAndPassword() {
        driver.findElement(welcomeElement).isDisplayed();
    }

    public void userClickCloseButton() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(closeButton).click();
    }

    public void userClickLogoutMenu() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(logoutMenu).click();
    }
}