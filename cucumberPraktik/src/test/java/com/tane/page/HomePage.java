package com.tane.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HomePage {

    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnHomePage() {
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button")).click();
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public void addAllProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item")));

        List<WebElement> addButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        System.out.println("Jumlah produk ditemukan: " + addButtons.size());

        for (WebElement button : addButtons) {
            if (button.isDisplayed() && button.isEnabled()) {
                button.click();
            }
        }
    }

}
