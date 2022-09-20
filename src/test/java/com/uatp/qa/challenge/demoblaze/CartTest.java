package com.uatp.qa.challenge.demoblaze;

import com.github.javafaker.Faker;
import com.uatp.qa.challenge.demoblaze.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest {

    @Test
    public void verifyAddingNewItemToCart() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        try {
            webDriver.get("https://www.demoblaze.com/");

            String phoneName = "Nexus 6";
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnPhoneCategory();
            HomePage.SelectedProduct selectedProduct =  homePage.selectDesiredProductByName(phoneName);
            Alert alert = selectedProduct.clickAddToCart();

            String alertText = alert.getText();
            alert.accept();
            assertEquals(alertText, "Product added");
            webDriver.navigate().refresh();
            HomePage.CartPage cartPage = homePage.clickOnCartPage();
            String productInCart = cartPage.getProductNameInCart();

            assertEquals(productInCart, phoneName, "The searched product was added to the cart");

        } finally {
            webDriver.close();
        }
    }

    @Test
    public void verifyDeletingNewItemToCart() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        try {
            webDriver.get("https://www.demoblaze.com/");

            String phoneName = "Nexus 6";
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnPhoneCategory();
            HomePage.SelectedProduct selectedProduct =  homePage.selectDesiredProductByName(phoneName);
            Alert alert = selectedProduct.clickAddToCart();

            String alertText = alert.getText();
            alert.accept();
            assertEquals(alertText, "Product added");
            webDriver.navigate().refresh();
            HomePage.CartPage cartPage = homePage.clickOnCartPage();
            cartPage.clickDeleteAddedProduct();
            assertEquals(cartPage.getNumberOfProductsAdded(), 0, "El articulo no fue eliminado con éxito");

        } finally {
            webDriver.close();
        }
    }
}
