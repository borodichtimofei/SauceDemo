package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    String productAddToCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    String productRemoveFromCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    String productName = "//div[text()='%s']";

    public static final By SORT_BUTTON = By.cssSelector(".product_sort_container");
    public static final By PRODUCT_PRICE = By.cssSelector(".inventory_details_price");
    public static final By PRODUCTS_PRICE = By.cssSelector(".inventory_item_price");
    public static final By PRODUCTS_NAME = By.cssSelector(".inventory_item_name");
    public static final By PRODUCT_PAGE_TITLE = By.xpath("//span[text()='Products']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/inventory.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PAGE_TITLE));
    }

    public void waitForLoading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PAGE_TITLE));
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productAddToCart, product))).click();
    }

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    public void openProduct(String product) {
        driver.findElement(By.xpath(String.format(productName, product))).click();
    }

    public void sort(String sorting) {
        new Select(driver.findElement(SORT_BUTTON)).selectByVisibleText(sorting);
    }

    public String getProductPrice() {
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    public String getProductName(int index) {
        return driver.findElements(PRODUCTS_NAME).get(index).getText();
    }

    public String getProductPrice(int index) {
        return driver.findElements(PRODUCTS_PRICE).get(index).getText();
    }

    public String getTitle() {
        return driver.findElement(PRODUCT_PAGE_TITLE).getText();
    }
}

