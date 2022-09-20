package com.uatp.qa.challenge.demoblaze;

import com.github.javafaker.Faker;
import com.uatp.qa.challenge.demoblaze.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductStoreTest {


    @Test
    public void searchByPhoneName() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        try {
            webDriver.get("https://www.demoblaze.com/");

            String phoneName = "Nexus 6";
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnPhoneCategory();
            HomePage.SelectedProduct selectedProduct =  homePage.selectDesiredPhone(phoneName);

            assertEquals(selectedProduct.selectedProductName(), phoneName, "The searched product was founded");
        } finally {
            webDriver.close();
        }
    }




}
