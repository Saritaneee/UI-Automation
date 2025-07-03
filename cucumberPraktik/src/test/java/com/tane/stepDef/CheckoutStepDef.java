package com.tane.stepDef;

import com.tane.page.CartPage;
import com.tane.page.CheckoutPage;
import com.tane.page.HomePage;
import com.tane.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class CheckoutStepDef {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("user have {string} in cart")
    public void userHaveInCart(String product) {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        homePage = new HomePage(driver);
        homePage.addToCart(product);
        homePage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(driver);
    }

//    @When("user checkout with {string}, {string}, {string}")
//    public void userCheckoutWith(String first, String last, String zip) throws InterruptedException {
//        checkoutPage.enterCheckoutInfo(first, last, zip);
//    }

    @Then("user should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String message) {
        checkoutPage.isCheckoutComplete();
    }

    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() throws InterruptedException {
        checkoutPage.validateErrorAppear();
    }

    @And("user input first name with {string}")
    public void userInputFirstNameWith(String firstName) {
        checkoutPage.inputFirstName(firstName);
    }

    @And("user input last name with {string}")
    public void userInputLastNameWith(String lastName) {
        checkoutPage.inputLastName(lastName);
    }

    @And("user input postal code with {string}")
    public void userInputPostalCodeWith(String postalCode) {
        checkoutPage.inputPostalCode(postalCode);
    }

    @When("user click continue button")
    public void userClickContinueButton() throws InterruptedException {
        checkoutPage.clickContinueButton();
    }

    @When("user click finish button")
    public void userClickFinishButton() throws InterruptedException {
        checkoutPage.clickFinishButton();
    }

}
