package com.uatp.qa.challenge.demoblaze.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofMillis(100);

    private static final By SIGNUP_BUTTON = By.id("signin2");

    protected WebDriver webDriver;
    private WebDriverWait webDriverWait;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, TIMEOUT, POLLING);
    }

    public void clickOnSignUp() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_BUTTON));
        webDriver.findElement(SIGNUP_BUTTON).click();
    }



}
