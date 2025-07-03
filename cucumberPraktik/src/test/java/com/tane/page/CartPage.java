package com.tane.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isItemInCart(String productName) {
        return driver.findElement(By.xpath("//div[text()='" + productName + "']")).isDisplayed();
    }

    public void removeItem(String productName) {
        String xpath = "//div[@class='inventory_item_name' and text()='" + productName + "']/ancestor::div[@class='cart_item']//button[text()='Remove']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void proceedToCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    public int getCartItemCount() {
        return driver.findElements(By.className("cart_item")).size();
    }
}
