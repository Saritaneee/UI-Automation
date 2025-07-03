package com.tane.stepDef;

import com.tane.page.CartPage;
import com.tane.page.HomePage;
import com.tane.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class CartStepDef {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;

    @Given("user has logged in")
    public void userHasLoggedIn() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        homePage = new HomePage(driver);
    }

    @When("user add {string} to cart")
    public void userAddToCart(String product) {
        homePage.addToCart(product);
    }

    @And("user go to the cart")
    public void userGoToCart() {
        homePage.goToCart();
        cartPage = new CartPage(driver);
    }

    @Then("the cart should contain {string}")
    public void theCartShouldContain(String product){
        assertTrue(cartPage.isItemInCart(product));
    }

    @Given("user on the cart page with {string}")
    public void userOnTheCartPageWith(String product) {
        userHasLoggedIn();
        userAddToCart(product);
        userGoToCart();
    }

    @When("user remove {string} from the cart")
    public void userRemoveFromTheCart(String product) {
        cartPage.removeItem(product);
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        assertTrue(driver.findElements(By.className("cart_item")).isEmpty());
    }

    @When("user add all available products to the cart")
    public void userAddAllAvailableProductsToTheCart() {
        homePage.addAllProducts();
    }

    @Then("the cart should contain all added products")
    public void theCartShouldContainAllAddedProducts() {
        homePage.goToCart();
        cartPage = new CartPage(driver);

        int itemCount = cartPage.getCartItemCount();
        System.out.println("Jumlah item di keranjang: " + itemCount);

        assertTrue("Cart item count should be at least 6", itemCount >= 6);
        driver.quit();
    }
}
