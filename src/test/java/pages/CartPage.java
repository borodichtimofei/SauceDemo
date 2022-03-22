package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final By ADD_TO_CART_BUTTON = By.id("shopping_cart_container");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By TOTAL_PRICE = By.cssSelector(".summary_total_label");
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By COMPLETE_INFO = By.cssSelector(".title");
    public static final By PRODUCTS_IN_CART = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "cart.html");
    }

    public void openCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void checkoutInCart() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void checkoutInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String totalPrice() {
        return driver.findElement(TOTAL_PRICE).getText().split(" ")[1];
    }

    public void finish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String complete() {
        return driver.findElement(COMPLETE_INFO).getText();
    }

    public int numberProducts() {
        return driver.findElements(PRODUCTS_IN_CART).size();
    }
}
