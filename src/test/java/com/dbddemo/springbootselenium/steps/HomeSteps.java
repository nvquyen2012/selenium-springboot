package com.dbddemo.springbootselenium.steps;

import com.dbddemo.springbootselenium.annotations.LazyAutowired;
import com.dbddemo.springbootselenium.annotations.LazyComponent;
import com.dbddemo.springbootselenium.annotations.TakeScreenshot;
import com.dbddemo.springbootselenium.pages.HomePage;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class HomeSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    HomePage homePage;

    public HomeSteps givenIAmAtHomePage() {
        homePage
            .goToHomePage();
        return this;
    }

    @TakeScreenshot
    public HomeSteps thenIVerifyIAmAtHomePage() {
            homePage
                .verifyThatIAmAtHomePage();
        return this;
    }
}
