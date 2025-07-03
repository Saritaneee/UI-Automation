package com.tane.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginPage {

    WebDriver driver;

    By usernameInputText = By.cssSelector("input#user-name");
    By passwordInputText = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.id("login-button");
    By errorContainer = By.cssSelector("div.error-message-container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void clickLoginButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
    }

    public void validateErrorAppear() throws InterruptedException {
        Thread.sleep(5000);
        WebElement errorMessage = driver.findElement(errorContainer);
        assertTrue(errorMessage.isDisplayed());
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage.getText());
    }

    public void login(String user, String pass) {
        driver.findElement(usernameInputText).sendKeys(user);
        driver.findElement(passwordInputText).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}
