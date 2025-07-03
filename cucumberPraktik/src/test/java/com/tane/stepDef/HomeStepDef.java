package com.tane.stepDef;

import com.tane.BaseTest;
import com.tane.page.HomePage;
import io.cucumber.java.en.Then;

public class HomeStepDef extends BaseTest {

    HomePage homePage;

    @Then("user on homepage")
    public void userOnHomepage() {
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
    }
}
