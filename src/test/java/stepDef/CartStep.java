package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.CartPage;

public class CartStep extends BaseTest {

    CartPage cartPage;
    public CartStep() {
        cartPage = new CartPage(driver);
    }
    @When("user click add to cart button for this product:")
    public void userClickAddToCartButtonForThisProduct() {
    }

    @And("user go to the cart page")
    public void userGoToTheCartPage() {
    }

    @And("the cart should be contain:")
    public void theCartShouldBeContain() {
    }

    @Then("the total price is correct")
    public void theTotalPriceIsCorrect() {
    }

    @When("user click add to cart button for this product {int} times:")
    public void userClickAddToCartButtonForThisProductTimes(int arg0) {
    }

    @And("user click delete button to this product:")
    public void userClickDeleteButtonToThisProduct() {
    }
}
