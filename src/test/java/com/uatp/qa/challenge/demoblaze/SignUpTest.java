package com.uatp.qa.challenge.demoblaze;

import com.github.javafaker.Faker;
import com.uatp.qa.challenge.demoblaze.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpTest {

    @Test
    public void verifyHappyPathSignUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        try {
            webDriver.get("https://www.demoblaze.com/");

            Faker faker = new Faker();
            HomePage homePage = new HomePage(webDriver);
            HomePage.SignUpModal signUpModal = homePage.clickOnSignUp();
            signUpModal.enterUserName(faker.internet().emailAddress());
            signUpModal.enterPassword("Password1!");
            Alert alert = signUpModal.clickSignUpButton();
            String alertText = alert.getText();
            alert.accept();
            assertEquals(alertText, "Sign up successful.");

        } finally {
            webDriver.close();
        }
    }

    @Test
    public void verifySignUpAlreadyCreated() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("https://www.demoblaze.com/");

            Faker faker = new Faker();
            String emailAddress = faker.internet().emailAddress();
            HomePage homePage = new HomePage(webDriver);
            HomePage.SignUpModal signUpModal = homePage.clickOnSignUp();
            signUpModal.enterUserName(emailAddress);
            signUpModal.enterPassword("Password1!");
            Alert alert = signUpModal.clickSignUpButton();
            alert.accept();

            webDriver.navigate().refresh();
            signUpModal = homePage.clickOnSignUp();
            signUpModal.enterUserName(emailAddress);
            signUpModal.enterPassword("Password1!");
            alert = signUpModal.clickSignUpButton();
            String alertText = alert.getText();
            alert.accept();
            assertEquals(alertText, "This user already exist.");
        } finally {
            webDriver.close();
        }

    }

}
