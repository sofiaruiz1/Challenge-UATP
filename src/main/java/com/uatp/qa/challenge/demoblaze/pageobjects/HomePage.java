package com.uatp.qa.challenge.demoblaze.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends AbstractBasePage {

    private static final By SIGNUP_LINK = By.id("signin2");
    private static final By LOGIN_LINK = By.id("login2");
    private final By USERNAME_LOGGED = By.id("nameofuser");

    private final SignUpModal signUpModal;
    private final LoginModal loginModal;

    public HomePage(WebDriver webDriver, Duration timeout, Duration polling) {
        super(webDriver, timeout, polling);
        this.loginModal = new LoginModal();
        this.signUpModal = new SignUpModal();
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.signUpModal = new SignUpModal();
        this.loginModal = new LoginModal();
    }

    public SignUpModal clickOnSignUp() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_LINK));
        webDriver.findElement(SIGNUP_LINK).click();
        return this.signUpModal;
    }
    public LoginModal clickOnLogIn() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_LINK));
        webDriver.findElement(LOGIN_LINK).click();
        return this.loginModal;
    }
    public String getLoggedUserName() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_LOGGED));
       return this.webDriver.findElement(USERNAME_LOGGED).getText();
    }


    public class SignUpModal {

        private final By USERNAME_INPUT = By.id("sign-username");
        private final By PASSWORD_INPUT = By.id("sign-password");
        private final By SIGNUP_BUTTON = By.xpath("//button[text() = 'Sign up']");


        public void enterUserName(String userName) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
            webDriver.findElement(USERNAME_INPUT).clear();
            webDriver.findElement(USERNAME_INPUT).sendKeys(userName);
        }

        public void enterPassword(String password) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
            webDriver.findElement(PASSWORD_INPUT).clear();
            webDriver.findElement(PASSWORD_INPUT).sendKeys(password);
        }

        public Alert clickSignUpButton() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_BUTTON));
            webDriver.findElement(SIGNUP_BUTTON).click();
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            return webDriver.switchTo().alert();
        }
    }

    public class LoginModal {

        private final By USERNAME_INPUT = By.id("loginusername");
        private final By PASSWORD_INPUT = By.id("loginpassword");
        private final By LOGIN_BUTTON = By.xpath("//button[text() = 'Log in']");

        public void enterUserName(String userName) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
            webDriver.findElement(USERNAME_INPUT).clear();
            webDriver.findElement(USERNAME_INPUT).sendKeys(userName);
        }

        public void enterPassword(String password) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
            webDriver.findElement(PASSWORD_INPUT).clear();
            webDriver.findElement(PASSWORD_INPUT).sendKeys(password);
        }

        public void clickLogInButton() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
            webDriver.findElement(LOGIN_BUTTON).click();
        }
        public Alert clickLogInButtonToAlert() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
            webDriver.findElement(LOGIN_BUTTON).click();
            return webDriver.switchTo().alert();
        }

    }
}
