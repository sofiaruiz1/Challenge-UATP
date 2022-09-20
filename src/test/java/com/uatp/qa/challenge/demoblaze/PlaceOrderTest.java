package com.uatp.qa.challenge.demoblaze;

import com.uatp.qa.challenge.demoblaze.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlaceOrderTest {

    @Test
    public void verifyPurchaseAfterAddingAProduct() {
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
            //String productInCart = cartPage.getProductNameInCart();

            String name = "Test Name";
            String country = "Uruguay";
            String city = "Mdeo";
            String card = "372593896379850";
            String month = "12";
            String year = "2024";

            HomePage.PlaceOrderModal placeOrderModal = homePage.clickOnPLaceOrder();
            HomePage.SuccessOrder successOrder = placeOrderModal.completePurchaseForm(name, country,city,card,month,year);

            assertEquals(successOrder.getSuccessTitle(), "Thank you for your purchase!", "La compra no fue realizada con éxito");
        } finally {
            webDriver.close();
        }
    }
}
