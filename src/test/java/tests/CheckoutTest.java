package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.checkoutInCart();
        cartPage.checkoutInformation("test", "test", "12345");
        assertEquals(cartPage.totalPrice(), "$32.39");
        cartPage.finish();
        assertEquals(cartPage.complete(), "CHECKOUT: COMPLETE!");
    }
}

