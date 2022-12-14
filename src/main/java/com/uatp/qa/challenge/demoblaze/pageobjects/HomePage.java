package com.uatp.qa.challenge.demoblaze.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends AbstractBasePage {

    private static final By SIGNUP_LINK = By.id("signin2");
    private static final By LOGIN_LINK = By.id("login2");
    private final By USERNAME_LOGGED = By.id("nameofuser");
    private final By PHONE_CATEGORY = By.xpath("//a[text()  = 'Phones']");
    private final By LAPTOP_CATEGORY = By.xpath("//a[text()  = 'Laptops']");
    private static By PRODUCT_NAME(String productName) {
        String s = "//a[@class='hrefch' and  text() = \""+ productName +"\"]";
        return By.xpath(s);
    }
    private final By CART_LINK = By.xpath("//a[text() = 'Cart']");
    private final By PLACE_ORDER_BTN = By.xpath("//button[text() = 'Place Order']");



    private final SignUpModal signUpModal;
    private final LoginModal loginModal;
    private final SelectedProduct selectedProduct;
    public final CartPage cartPage;
    public final PlaceOrderModal placeOrderModal;
    public final SuccessOrder successOrder;


    public HomePage(WebDriver webDriver, Duration timeout, Duration polling) {
        super(webDriver, timeout, polling);
        this.loginModal = new LoginModal();
        this.signUpModal = new SignUpModal();
        this.selectedProduct = new SelectedProduct();
        this.cartPage = new CartPage();
        this.placeOrderModal = new PlaceOrderModal();
        this.successOrder = new SuccessOrder();
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.signUpModal = new SignUpModal();
        this.loginModal = new LoginModal();
        this.selectedProduct = new SelectedProduct();
        this.cartPage = new CartPage();
        this.placeOrderModal = new PlaceOrderModal();
        this.successOrder = new SuccessOrder();
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
    public HomePage clickOnPhoneCategory() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_CATEGORY));
        webDriver.findElement(PHONE_CATEGORY).click();
        return this;
    }
    public HomePage clickOnLaptopCategory() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LAPTOP_CATEGORY));
        webDriver.findElement(LAPTOP_CATEGORY).click();
        return this;
    }

    public SelectedProduct selectDesiredProductByName(String productName) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME(productName)));
        webDriver.findElement(PRODUCT_NAME(productName)).click();
        return this.selectedProduct;
    }

    public CartPage clickOnCartPage() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CART_LINK));
        webDriver.findElement(CART_LINK).click();
        return this.cartPage;
    }

    public PlaceOrderModal clickOnPLaceOrder() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PLACE_ORDER_BTN));
        webDriver.findElement(PLACE_ORDER_BTN).click();
        return this.placeOrderModal;
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

    public class SelectedProduct {
        private final By PRODUCT_NAME = By.xpath("//div[@id='tbodyid']/h2");
        private final By ADD_TO_CART_BTN = By.xpath("//a[text() = 'Add to cart']");

        public String selectedProductName() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME));
            return webDriver.findElement(PRODUCT_NAME).getText();
        }
        public Alert clickAddToCart() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BTN));
            webDriver.findElement(ADD_TO_CART_BTN).click();
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            return webDriver.switchTo().alert();
        }

    }

    //This classes should be a new class from other page object, but I had an error I couldn't resolve
    public class CartPage {
        private final By PRODUCT_NAME_IN_CART = By.xpath("//tbody[@id='tbodyid']/tr/td[2]");
        private final By DELETE_LINK = By.xpath("//a[text() = 'Delete']");
        private final By GET_ALL_PRODUCTS_ADDED = By.xpath("//tbody[@id='tbodyid']/");

        public String getProductNameInCart() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME_IN_CART));
            return webDriver.findElement(PRODUCT_NAME_IN_CART).getText();
        }

        public void clickDeleteAddedProduct() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_LINK));
            webDriver.findElement(DELETE_LINK).click();
        }
        public Dimension getNumberOfProductsAdded() {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(GET_ALL_PRODUCTS_ADDED)).getSize();

        }
    }

    public class PlaceOrderModal {

        private final By NAME_INPUT = By.id("name");
        private final By COUNTRY_INPUT = By.id("country");
        private final By CITY_INPUT = By.id("city");
        private final By CREDIT_CARD_INPUT = By.id("card");
        private final By MONTH_INPUT = By.id("month");
        private final By YEAR_INPUT = By.id("year");
        private final By PURCHASE_BUTTON = By.xpath("//button[text() = 'Purchase']");

        public SuccessOrder completePurchaseForm(String name, String country, String city, String card, String month, String year) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
            webDriver.findElement(NAME_INPUT).sendKeys(name);
            webDriver.findElement(COUNTRY_INPUT).sendKeys(country);
            webDriver.findElement(CITY_INPUT).sendKeys(city);
            webDriver.findElement(CREDIT_CARD_INPUT).sendKeys(card);
            webDriver.findElement(MONTH_INPUT).sendKeys(month);
            webDriver.findElement(YEAR_INPUT).sendKeys(year);
            webDriver.findElement(PURCHASE_BUTTON).click();
            return successOrder;
        }
    }
    public class SuccessOrder {
        private final By SUCCESS_TITLE = By.xpath("//h2[text() = 'Thank you for your purchase!']");

        public String getSuccessTitle() {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_TITLE));
            return webDriver.findElement(SUCCESS_TITLE).getText();
        }
    }
}
