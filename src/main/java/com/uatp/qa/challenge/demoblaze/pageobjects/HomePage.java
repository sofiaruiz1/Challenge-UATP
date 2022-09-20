package com.uatp.qa.challenge.demoblaze.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends AbstractBasePage {

    private static final By SIGNUP_BUTTON = By.id("signin2");

    public HomePage(WebDriver webDriver, Duration timeout, Duration polling) {
        super(webDriver, timeout, polling);
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnSignUp() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_BUTTON));
        webDriver.findElement(SIGNUP_BUTTON).click();
    }


}
