import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    public void login() {
        driver.get("https://www.saucedemo.com/");
        String loginInfo = driver.findElement(By.id("login_credentials")).getText();
        String passwordInfo = driver.findElement(By.cssSelector(".login_password")).getText();
        String loginFirst = loginInfo.split("\n")[1];
        String password = passwordInfo.split("\n")[1];
        driver.findElement(By.id("user-name")).sendKeys(loginFirst);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("user-name")).submit();
    }

    @Test
    public void displayingNumberProductsInCart() {
        login();
        String firstProductLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        String secondProductLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Backpack"))).click();
        String numberProducts = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(numberProducts, "1", "Number is not correct");
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Fleece Jacket"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Bike Light"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Onesie"))).click();
        numberProducts = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(numberProducts, "4","Number is not correct");
        driver.findElement(By.xpath(String.format(firstProductLocator, "Test.allTheThings() T-Shirt (Red)"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Bolt T-Shirt"))).click();
        numberProducts = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(numberProducts, "6", "Number is not correct");
        driver.findElement(By.xpath(String.format(secondProductLocator, "Sauce Labs Backpack"))).click();
        numberProducts = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(numberProducts, "5", "Number is not correct");
        driver.findElement(By.xpath(String.format(secondProductLocator, "Sauce Labs Fleece Jacket"))).click();
        driver.findElement(By.xpath(String.format(secondProductLocator, "Sauce Labs Bike Light"))).click();
        driver.findElement(By.xpath(String.format(secondProductLocator, "Sauce Labs Onesie"))).click();
        driver.findElement(By.xpath(String.format(secondProductLocator, "Test.allTheThings() T-Shirt (Red)"))).click();
        numberProducts = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(numberProducts, "1", "Number is not correct");
    }

    @Test
    public void checkButtonRemoveInCart() {
        login();
        String firstProductLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        String secondProductLocator = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//button[text()='Remove']";
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Backpack"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Fleece Jacket"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Bike Light"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Onesie"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Test.allTheThings() T-Shirt (Red)"))).click();
        driver.findElement(By.xpath(String.format(firstProductLocator, "Sauce Labs Bolt T-Shirt"))).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.xpath(String.format(secondProductLocator, "Sauce Labs Backpack"))).click();
        driver.findElement(By.xpath(String.format(secondProductLocator, "Sauce Labs Fleece Jacket"))).click();
        String numberProducts = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(numberProducts, "4", "Number is not correct");
    }

    @Test
    public void checkDropdownMenu() {
        login();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.xpath("//*[text()='All Items']")).click();
        String information = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        assertEquals(information, "PRODUCTS", "Action is not correct");
        login();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.xpath("//*[text()='About']")).click();
        information = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).getText();
        assertEquals(information, "Sign in", "Action is not correct");
        login();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        information = driver.findElement(By.id("login-button")).getAttribute("value");
        assertEquals(information, "Login", "Action is not correct");
    }
}
