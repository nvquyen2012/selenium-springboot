package com.dbddemo.springbootselenium.tests;

import com.dbddemo.springbootselenium.annotations.LazyAutowired;
import com.dbddemo.springbootselenium.steps.HomeSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
public class HomePageTest extends BaseTest {
    @LazyAutowired
    HomeSteps homeSteps;

    @Test
    public void homePageTest() {
        System.out.println("Driver of invalidUserNameInvalidPassword test: " + applicationContext
            .getBean(WebDriver.class));

        homeSteps
            .givenIAmAtHomePage()
            .thenIVerifyIAmAtHomePage();
    }
}
