package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.CartPage;

import java.util.List;

public class CartStep extends BaseTest {

    CartPage cartPage;
    public CartStep() {
        cartPage = new CartPage(driver);
    }
    @When("user click add to cart button for this product:")
    public void userClickAddToCartButtonForThisProduct(List<String> products) {
        cartPage.addProductCart(products);
    }

    @And("user go to the cart page")
    public void userGoToTheCartPage() throws InterruptedException {
        Thread.sleep(1500);
        cartPage.userGoToTheCartPage();
        cartPage.validateOnCartPage();
    }

    @And("the cart should be contain:")
    public void theCartShouldBeContain(List<String> products) {
        cartPage.validateCartProduct(products);
    }

    @Then("the total price is correct")
    public void theTotalPriceIsCorrect() {
        cartPage = new CartPage(driver);
        cartPage.theTotalPriceIsCorrect();
    }

    @When("user click add to cart button for this product {int} times:")
    public void userClickAddToCartButtonForThisProductTimes(int itemCount, List<String> products) {
        cartPage = new CartPage(driver);
        cartPage.addQuantityItemsToCart(itemCount, products);
    }

    @Then("user remove item from cart")
    public void userRemoveItemFromCart() {
        cartPage.userClickDeleteButtonToThisProduct();
    }

    @And("the cart should be contain {int} items:")
    public void theCartShouldBeContainItems(int itemCount, List<String> products) {
        cartPage.validateQuantityItems(itemCount, products);
    }
}
