package com.dbddemo.springbootselenium.tests;

import com.dbddemo.springbootselenium.annotations.LazyAutowired;
import com.dbddemo.springbootselenium.steps.LoginSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {
    @LazyAutowired
    LoginSteps loginSteps;

    @Test
    public void invalidUserNameInvalidPassword() throws InterruptedException {
        System.out.println("Driver of invalidUserNameInvalidPassword test: " + applicationContext
            .getBean(WebDriver.class));

        loginSteps
            .givenIAmAtLoginPage()
            .whenILogin("onur@dbddemo.com", "11223344")
            .thenIVerifyInvalidLoginMessage();
    }

    @Test
    public void emptyUserEmptyPassword() throws InterruptedException {
        logger.info("Driver of emptyUserEmptyPassword test: " + applicationContext
            .getBean(WebDriver.class));

        loginSteps
            .givenIAmAtLoginPage()
            .whenILogin("", "")
            .thenIVerifyUserNameErrorMessages("Your username is invalid!")
            .thenIVerifyPasswordErrorMessage("Your password is invalid!");
    }
}
