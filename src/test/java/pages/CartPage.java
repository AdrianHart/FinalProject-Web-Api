package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage {

    WebDriver driver;
    By cartMenu = By.xpath("//*[@id=\"cartur\"]");
    By addToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By totalPriceItems = By.cssSelector("#totalp");
    By priceItem = By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]");
    By deleteFromCart = By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a");
    By cartPageTitleProducts = By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/h2");

//    By placeOrder = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    public By productHomePage(String name) {
        return By.xpath("//a[contains(text(), '" + name + "')]");
    }
    public By productCartPage(String name) {
        return By.xpath("//td[contains(text(), '" + name + "')]");
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public void addProductCart(List<String> products) {
        for (String product : products) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement linkProduct = wait.until(ExpectedConditions.elementToBeClickable(productHomePage(product)));
            linkProduct.click();

            WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCart));
            addToCartElement.click();

            wait.until(ExpectedConditions.alertIsPresent()).accept();
            driver.navigate().back();
        }
    }

    public void userGoToTheCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(cartMenu));
        assertTrue(title.isDisplayed());
        assertEquals("Cart", title.getText());
        driver.findElement(cartMenu).click();
    }

    public void validateOnCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageTitleProducts));
        Assertions.assertTrue(title.isDisplayed());
        Assertions.assertEquals("Products", title.getText());
    }

    public void validateCartProduct(List<String> products) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for (String expectedProduct : products) {
            WebElement productsInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(productCartPage(expectedProduct)));
            String actualProduct = productsInCart.getText();
            Assertions.assertEquals(expectedProduct, actualProduct);
        }
    }

    public void theTotalPriceIsCorrect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> priceElements = driver.findElements(priceItem);
        int totalPrice;
        totalPrice = 0;

        for (WebElement priceElement : priceElements) {
            WebElement price = wait.until(ExpectedConditions.visibilityOf(priceElement));
            String productPrice = price.getText();
            int productPrices = Integer.parseInt(productPrice);
            totalPrice += productPrices;
        }
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceItems));
        Assertions.assertEquals(String.valueOf(totalPrice), totalElement.getText());
    }


    public void userClickDeleteButtonToThisProduct() {
        driver.findElement(deleteFromCart).click();
    }

    public void addQuantityItemsToCart(int itemCount, List<String> products) {
        for (String product : products) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement linkProduct = wait.until(ExpectedConditions.elementToBeClickable(productHomePage(product)));
            linkProduct.click();

            WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCart));
            for (int i = 1; i <= itemCount; i++) {
                addToCartElement.click();
                wait.until(ExpectedConditions.alertIsPresent()).accept();
            }
            driver.navigate().back();
        }
    }

    public void validateQuantityItems(int itemCount, List<String> products) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for (String product : products) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productCartPage(product)));
            int productCount = driver.findElements(productCartPage(product)).size();
            Assertions.assertEquals(itemCount, productCount);
        }
    }
}