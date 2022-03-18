package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void ClickingOnProductShouldOpenTheProductPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.productsCheck("Sauce Labs Backpack");
        assertEquals(productsPage.priceProduct(), "$29.99");
    }

    @Test
    public void sortProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.sort("Price (low to high)");
        Assert.assertEquals(productsPage.firstPositionSort(), "$7.99");
        Assert.assertEquals(productsPage.lastPositionSort(), "$49.99");
    }
}





