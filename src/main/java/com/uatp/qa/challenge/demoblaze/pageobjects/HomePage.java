package com.uatp.qa.challenge.demoblaze.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends AbstractBasePage {

    private static final By SIGNUP_LINK = By.id("signin2");

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
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_LINK));
        webDriver.findElement(SIGNUP_LINK).click();
        return this.signUpModal;
    }


    public class SignUpModal {

        private final By USERNAME_INPUT = By.id("sign-username");
        private final By PASSWORD_INPUT = By.id("sign-password");
        private final By SIGNUP_BUTTON = By.xpath("//button[text() = 'Sign up']");


        public void enterUserName(String userName) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
            webDriver.findElement(USERNAME_INPUT).sendKeys(userName);
        }

        public void enterPassword(String password) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
            webDriver.findElement(PASSWORD_INPUT).sendKeys(password);
        }

        public Alert clickSignUpButton() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_BUTTON));
            webDriver.findElement(SIGNUP_BUTTON).click();
            return webDriver.switchTo().alert();
        }
    }
}
