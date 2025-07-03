package com.tane.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutPage {
    WebDriver driver;
    By firstNameInput = By.cssSelector("input#first-name.input_error.form_input");
    By lastNameInput = By.id("last-name");
    By postalCodeInput = By.id("postal-code");
    By errorContainer = By.cssSelector("h3[data-test='error']");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By completeContainer = By.cssSelector("h2.complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
        System.out.println(firstName);
    }

    public void inputLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
        System.out.println(lastName);
    }

    public void inputPostalCode(String postalCode){
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        System.out.println(postalCode);
    }

    public void clickContinueButton() throws InterruptedException {
        WebElement continueBtn = driver.findElement(continueButton);
        System.out.println("🔍 Continue button enabled: " + continueBtn.isEnabled());

        if (continueBtn.isEnabled()) {
            continueBtn.click();
            System.out.println("✅ Clicked Continue button");
        } else {
            throw new IllegalStateException("❌ Continue button is disabled - check input validation.");
        }
    }

    public void clickFinishButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();
        System.out.println("✅ Clicked Finish button");
    }

    public void isCheckoutComplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement completeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(completeContainer));
        driver.findElement(completeContainer);
        assertTrue(completeMessage.isDisplayed());
        assertEquals("Thank you for your order!", completeMessage.getText());
    }

    public void validateErrorAppear() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorContainer));
        driver.findElement(errorContainer);
        assertTrue(errorElement.isDisplayed());
    }
}
