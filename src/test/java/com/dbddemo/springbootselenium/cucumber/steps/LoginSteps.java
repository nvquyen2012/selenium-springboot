package com.dbddemo.springbootselenium.cucumber.steps;

import com.dbddemo.springbootselenium.annotations.LazyAutowired;
import com.dbddemo.springbootselenium.annotations.TakeScreenshot;
import com.dbddemo.springbootselenium.pages.HomePage;
import com.dbddemo.springbootselenium.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

public class LoginSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    private HomePage homePage;

    @LazyAutowired
    private LoginPage loginPage;

    @Given("I am on the login page")
    @TakeScreenshot
    public void iAmOnTheLoginPage() {
        homePage
            .goToHomePage()
            .goToLoginPage();
    }

    @When("I try to login with {string} and {string}")
    @TakeScreenshot
    public void iTryToLoginWithAnd(String userName, String password) throws InterruptedException {
        loginPage
            .login(userName, password);
    }

    @Then("I verify invalid login message")
    public void iVerifyInvalidLoginMessage() {
        if (!browser.equalsIgnoreCase("chrome")) {
            loginPage
                .verifyLogEntryFailMessage();
        } else {
            loginPage.verifyPasswordErrorMessageWithCss("Your username is invalid!\n" +
                    "×");
        }
    }

    @Then("I verify valid login message")
    public void iVerifyValidLoginMessage() {
        if (!browser.equalsIgnoreCase("chrome")) {
            loginPage
                    .verifyLogEntryFailMessage();
        } else {
            loginPage.verifyValidLoginMessage("You logged into a secure area!\n" +
                    "×");
        }
    }
}
