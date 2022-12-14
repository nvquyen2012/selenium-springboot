package com.dbddemo.springbootselenium.configuration;

import com.dbddemo.springbootselenium.annotations.LazyConfiguration;
import com.dbddemo.springbootselenium.annotations.WebdriverScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("!grid")
@LazyConfiguration
public class WebDriverConfig {
    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Primary
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver edgeDriver() {
        return new EdgeDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver chromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        return chromeDriver;
    }
}
