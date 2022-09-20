package com.uatp.qa.challenge.demoblaze;

import com.uatp.qa.challenge.demoblaze.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void verifyHappyPathSignUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.demoblaze.com/");

        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnSignUp();
    }

}
