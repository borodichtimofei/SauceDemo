package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void productsShouldBeAddedInToCart() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.removeFromCart("Sauce Labs Backpack");
        navigationPage.clickCart();
        assertEquals(cartPage.getProductCount(), 2);
    }

    @Test
    public void continueShoppingShouldReturnTheProductsPage (){
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        navigationPage.clickCart();
        cartPage.continueShopping();
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }
}




