package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void clickingOnProductShouldOpenTheProductPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.openProduct("Sauce Labs Backpack");
        assertEquals(productsPage.getProductPrice(), "$29.99");
    }

    @Test
    public void sortByNameAscending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Name (A to Z)");
        assertEquals(productsPage.getProductName(0), "Sauce Labs Backpack");
        assertEquals(productsPage.getProductName(5), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void sortByNameDescending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Name (Z to A)");
        assertEquals(productsPage.getProductName(0), "Test.allTheThings() T-Shirt (Red)");
        assertEquals(productsPage.getProductName(5), "Sauce Labs Backpack");
    }

    @Test
    public void sortByPriceAscending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Price (low to high)");
        assertEquals(productsPage.getProductPrice(0), "$7.99");
        assertEquals(productsPage.getProductPrice(5), "$49.99");
    }

    @Test
    public void sortByPriceDescending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Price (high to low)");
        assertEquals(productsPage.getProductPrice(0), "$49.99");
        assertEquals(productsPage.getProductPrice(5), "$7.99");
    }
}





