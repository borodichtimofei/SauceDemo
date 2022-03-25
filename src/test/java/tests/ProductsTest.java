package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(description = "Проверка, что при выборе продукта открывается страница с детализацией продукта")
    public void clickingOnProductShouldOpenTheProductPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.openProduct("Sauce Labs Backpack");
        assertEquals(productsPage.getProductPrice(), "$29.99");
    }

    @Test(description = "Проверка, что корректно выполняется сортировка: Name (A to Z) ")
    public void sortByNameAscending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Name (A to Z)");
        assertEquals(productsPage.getProductName(0), "Sauce Labs Backpack");
        assertEquals(productsPage.getProductName(5), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test(description = "Проверка, что корректно выполняется сортировка: Name (Z to A) ")
    public void sortByNameDescending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Name (Z to A)");
        assertEquals(productsPage.getProductName(0), "Test.allTheThings() T-Shirt (Red)");
        assertEquals(productsPage.getProductName(5), "Sauce Labs Backpack");
    }

    @Test(description = "Проверка, что корректно выполняется сортировка: Price (low to high) ")
    public void sortByPriceAscending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Price (low to high)");
        assertEquals(productsPage.getProductPrice(0), "$7.99");
        assertEquals(productsPage.getProductPrice(5), "$49.99");
    }

    @Test(description = "Проверка, что корректно выполняется сортировка: Price (high to low) ")
    public void sortByPriceDescending() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Price (high to low)");
        assertEquals(productsPage.getProductPrice(0), "$49.99");
        assertEquals(productsPage.getProductPrice(5), "$7.99");
    }
}





