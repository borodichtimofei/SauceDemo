package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationPage extends BasePage {

    public static final By CART_LINK = By.id("shopping_cart_container");
    public static final By CART_PAGE_TITLE = By.xpath("//span[text()='Your Cart']");


    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public void clickCart() {
        driver.findElement(CART_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CART_PAGE_TITLE));
    }

    public String getProductsInCart() {
        return driver.findElement(CART_LINK).getText();
    }

    
}
