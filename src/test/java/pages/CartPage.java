package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {


    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By TOTAL_PRICE = By.cssSelector(".summary_total_label");
    public static final By PRODUCTS_IN_CART = By.cssSelector(".cart_item");
    public static final By CONTINUE_BUTTON = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening cart page")
    public void open() {
        driver.get(baseUrl + "cart.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
    }

    @Step ("Click the button 'Checkout'")
    public void checkout() {
        driver.findElement(CHECKOUT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancel")));
    }

    @Step("Getting total price product in cart")
    public String getTotalPrice() {
        return driver.findElement(TOTAL_PRICE).getText().split(" ")[1];
    }

    @Step ("Click the button 'Continue shopping'")
    public void continueShopping (){
        driver.findElement(CONTINUE_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
    }

    @Step("Getting total product count in cart")
    public int getProductCount() {
        return driver.findElements(PRODUCTS_IN_CART).size();
    }
}
