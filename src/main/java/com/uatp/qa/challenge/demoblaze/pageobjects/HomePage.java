package com.uatp.qa.challenge.demoblaze.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends AbstractBasePage {

    private static final By SIGNUP_BUTTON = By.id("signin2");

    private final SignUpModal signUpModal;

    public HomePage(WebDriver webDriver, Duration timeout, Duration polling) {
        super(webDriver, timeout, polling);
        this.signUpModal = new SignUpModal();
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.signUpModal = new SignUpModal();
    }

    public SignUpModal clickOnSignUp() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_BUTTON));
        webDriver.findElement(SIGNUP_BUTTON).click();
        return this.signUpModal;
    }


    public class SignUpModal {

        public void enterUserName(String s) {
        }

        public void enterPassword(String s) {
        }

        public void clickSignUpButton() {
        }
    }
}
