package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationPage extends BasePage {

    public static final By CART_LINK = By.id("shopping_cart_container");
    public static final By CART_PAGE_TITLE = By.xpath("//span[text()='Your Cart']");


    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Click button with image of a cart")
    public void clickCart() {
        driver.findElement(CART_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CART_PAGE_TITLE));
    }

    @Step("Getting number products in cart")
    public String getProductsInCart() {
        return driver.findElement(CART_LINK).getText();
    }

    
}
