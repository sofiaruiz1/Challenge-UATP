package com.uatp.qa.challenge.demoblaze;

import com.github.javafaker.Faker;
import com.uatp.qa.challenge.demoblaze.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    @Test
    public void verifyHappyPathLogIn() {
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

            HomePage.LoginModal loginModal = homePage.clickOnLogIn();
            loginModal.enterUserName(emailAddress);
            loginModal.enterPassword("Password1!");
            loginModal.clickLogInButton();
            webDriver.navigate().refresh();
            assertEquals(homePage.getLoggedUserName(), "Welcome "+emailAddress);

        } finally {
            webDriver.close();
        }
    }




}
