package com.uatp.qa.challenge.demoblaze;

import com.uatp.qa.challenge.demoblaze.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpTest {

    @Test
    public void verifyHappyPathSignUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.demoblaze.com/");

        HomePage homePage = new HomePage(webDriver);
        HomePage.SignUpModal signUpModal = homePage.clickOnSignUp();
        signUpModal.enterUserName("sofia.ruiz+test3@distillery.com");
        signUpModal.enterPassword("Password1!");
        Alert alert = signUpModal.clickSignUpButton();
        assertEquals(alert.getText(), "Sign up successful.");

    }

}
