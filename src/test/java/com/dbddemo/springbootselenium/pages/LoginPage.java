package com.dbddemo.springbootselenium.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dbddemo.springbootselenium.annotations.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@LazyComponent
public class LoginPage extends BasePage {
    //********* Web Elements by using Page Factory *********
    @FindBy(how = How.ID, using = "username")
    public WebElement userName;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    //********* Web Elements by using By Class *********
    By loginButtonBy          = By.className("radius");
    By errorMessageUsernameBy = By.xpath("/html/body/div[1]/div/div/text()");
    By errorMessagePasswordBy = By.xpath("/html/body/div[1]/div/div[1]");
    By errorMessagePasswordCssBy = By.cssSelector("css=.fa");

    //*********Page Methods*********
    public LoginPage login(String userName, String password) {
        writeText(this.userName, userName);
        writeText(this.password, password);
        jsClick(loginButtonBy);
        return this;
    }

    public LoginPage verifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }

    public LoginPage verifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }

    public LoginPage verifyPasswordErrorMessageWithCss(String expectedText) {
        assertEquals(expectedText, readTextErrorMessage(errorMessagePasswordBy));
        return this;
    }

    public LoginPage verifyLogEntryFailMessage() {
        logUtil.isLoginErrorLog(driver);
        return this;
    }

    @Override public boolean isAt() {
        return this.wait.until((d) -> this.userName.isDisplayed());
    }

    public LoginPage verifyValidLoginMessage(String expectedText) {
        assertEquals(expectedText, readTextErrorMessage(errorMessagePasswordBy));
        return this;
    }
}
