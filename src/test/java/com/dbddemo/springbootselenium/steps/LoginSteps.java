package com.dbddemo.springbootselenium.steps;

import com.dbddemo.springbootselenium.annotations.ElapsedTime;
import com.dbddemo.springbootselenium.annotations.LazyAutowired;
import com.dbddemo.springbootselenium.annotations.LazyComponent;
import com.dbddemo.springbootselenium.annotations.TakeScreenshot;
import com.dbddemo.springbootselenium.pages.HomePage;
import com.dbddemo.springbootselenium.pages.LoginPage;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class LoginSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    HomePage homePage;

    @LazyAutowired
    LoginPage loginPage;

    public LoginSteps givenIAmAtLoginPage() {
        homePage
            .goToHomePage()
            .goToLoginPage();
        return this;
    }

    @ElapsedTime
    public LoginSteps whenILogin(String userName, String password) throws InterruptedException {
        loginPage
            .login(userName, password);
        return this;
    }

    public LoginSteps thenIVerifyUserNameErrorMessages(String expected) {
        loginPage
            .verifyLoginUserNameErrorMessage(expected);
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyInvalidLoginMessage() {
        if(!browser.equalsIgnoreCase("firefox")) {
            loginPage
                .verifyLogEntryFailMessage();
        } else {
            loginPage.verifyPasswordErrorMessageWithCss("Your username is invalid!");
        }
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyPasswordErrorMessage(String expected) {
        loginPage
            .verifyPasswordErrorMessage(expected);
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyPasswordErrorMessageWithCss(String expected) {
        loginPage
            .verifyPasswordErrorMessageWithCss(expected);
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyValidLoginMessage(String expected) {
        loginPage
                .verifyValidLoginMessage(expected);
        return this;
    }
}
