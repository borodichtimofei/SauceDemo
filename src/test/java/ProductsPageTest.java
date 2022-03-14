import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsPageTest extends BaseTest {

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
    public void productPageCheck() {
        login();
        String productName = "//div[text()='%s']";
        driver.findElement(By.xpath(String.format(productName, "Sauce Labs Backpack"))).click();
        assertEquals(driver.findElement(By.xpath(String.format(productName, "Sauce Labs Backpack"))).getText(), "Sauce Labs Backpack");
        driver.navigate().back();
        driver.findElement(By.xpath(String.format(productName, "Sauce Labs Bike Light"))).click();
        assertEquals(driver.findElement(By.xpath(String.format(productName, "Sauce Labs Bike Light"))).getText(), "Sauce Labs Bike Light");
        driver.navigate().back();
        driver.findElement(By.xpath(String.format(productName, "Sauce Labs Bolt T-Shirt"))).click();
        assertEquals(driver.findElement(By.xpath(String.format(productName, "Sauce Labs Bolt T-Shirt"))).getText(), "Sauce Labs Bolt T-Shirt");
        driver.navigate().back();
        driver.findElement(By.xpath(String.format(productName, "Sauce Labs Fleece Jacket"))).click();
        assertEquals(driver.findElement(By.xpath(String.format(productName, "Sauce Labs Fleece Jacket"))).getText(), "Sauce Labs Fleece Jacket");
        driver.navigate().back();
        driver.findElement(By.xpath(String.format(productName, "Sauce Labs Onesie"))).click();
        assertEquals(driver.findElement(By.xpath(String.format(productName, "Sauce Labs Onesie"))).getText(), "Sauce Labs Onesie");
        driver.navigate().back();
        driver.findElement(By.xpath(String.format(productName, "Test.allTheThings() T-Shirt (Red)"))).click();
        assertEquals(driver.findElement(By.xpath(String.format(productName, "Test.allTheThings() T-Shirt (Red)"))).getText(), "Test.allTheThings() T-Shirt (Red)");
        driver.navigate().back();
    }

    @Test
    public void sortByNameAscending() {
        login();
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        String firstOption = select.getOptions().get(0).getText();
        assertEquals(firstOption, "Name (A to Z)", "Sort name is not correct");
        select.getOptions().get(0).click();
        String firstProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(0).getText();
        assertEquals(firstProductName, "Sauce Labs Backpack", "Sort is not correct");
        String secondProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(1).getText();
        assertEquals(secondProductName, "Sauce Labs Bike Light","Sort is not correct");
        String thirdProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(2).getText();
        assertEquals(thirdProductName, "Sauce Labs Bolt T-Shirt", "Sort is not correct");
        String forthProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(3).getText();
        assertEquals(forthProductName, "Sauce Labs Fleece Jacket", "Sort is not correct");
        String fifthProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(4).getText();
        assertEquals(fifthProductName, "Sauce Labs Onesie", "Sort is not correct");
        String sixthProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(5).getText();
        assertEquals(sixthProductName, "Test.allTheThings() T-Shirt (Red)", "Sort is not correct");
    }

    @Test
    public void sortByNameDescending() {
        login();
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        String firstOption = select.getOptions().get(1).getText();
        assertEquals(firstOption, "Name (Z to A)", "Sort name is not correct");
        select.getOptions().get(1).click();
        String firstProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(0).getText();
        assertEquals(firstProductName, "Test.allTheThings() T-Shirt (Red)","Sort is not correct");
        String secondProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(1).getText();
        assertEquals(secondProductName, "Sauce Labs Onesie","Sort is not correct");
        String thirdProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(2).getText();
        assertEquals(thirdProductName, "Sauce Labs Fleece Jacket","Sort is not correct");
        String forthProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(3).getText();
        assertEquals(forthProductName, "Sauce Labs Bolt T-Shirt","Sort is not correct");
        String fifthProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(4).getText();
        assertEquals(fifthProductName, "Sauce Labs Bike Light","Sort is not correct");
        String sixthProductName = driver.findElements(By.cssSelector(".inventory_item_name")).get(5).getText();
        assertEquals(sixthProductName, "Sauce Labs Backpack","Sort is not correct");
    }

    @Test
    public void sortByPriceAscending() {
        login();
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        String thirdOption = select.getOptions().get(2).getText();
        assertEquals(thirdOption, "Price (low to high)", "Sort name is not correct");
        select.getOptions().get(2).click();
        String firstPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(0).getText();
        assertEquals(firstPrice, "$7.99","Sort is not correct");
        String secondPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(1).getText();
        assertEquals(secondPrice, "$9.99","Sort is not correct");
        String thirdPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(2).getText();
        assertEquals(thirdPrice, "$15.99","Sort is not correct");
        String forthPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(3).getText();
        assertEquals(forthPrice, "$15.99","Sort is not correct");
        String fifthPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(4).getText();
        assertEquals(fifthPrice, "$29.99","Sort is not correct");
        String sixthPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(5).getText();
        assertEquals(sixthPrice, "$49.99","Sort is not correct");
    }

    @Test
    public void sortByPriceDescending() {
        login();
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        String fourthOption = select.getOptions().get(3).getText();
        assertEquals(fourthOption, "Price (high to low)", "Sort name is not correct");
        select.getOptions().get(3).click();
        String firstPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(0).getText();
        assertEquals(firstPrice, "$49.99","Sort is not correct");
        String secondPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(1).getText();
        assertEquals(secondPrice, "$29.99","Sort is not correct");
        String thirdPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(2).getText();
        assertEquals(thirdPrice, "$15.99","Sort is not correct");
        String forthPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(3).getText();
        assertEquals(forthPrice, "$15.99","Sort is not correct");
        String fifthPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(4).getText();
        assertEquals(fifthPrice, "$9.99","Sort is not correct");
        String sixthPrice = driver.findElements(By.cssSelector(".inventory_item_price")).get(5).getText();
        assertEquals(sixthPrice, "$7.99","Sort is not correct");
    }

}