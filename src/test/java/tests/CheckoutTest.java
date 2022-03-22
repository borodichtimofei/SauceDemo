package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationPage.clickCart();
        cartPage.checkout();
        checkoutPage.fillInCheckoutInfo("test", "test", "12345");
        checkoutOverviewPage.waitForLoading();
        assertEquals(cartPage.getTotalPrice(), "$32.39");
        checkoutOverviewPage.finish();
        assertEquals(checkOutCompletePage.getCompleteTitle(), "CHECKOUT: COMPLETE!");
    }

    @Test
    public void checkoutInfoShouldBeRequired() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        navigationPage.clickCart();
        cartPage.checkout();
        checkoutPage.fillInCheckoutInfo("", "", "");
        assertEquals(checkoutPage.getError(), "Error: First Name is required");
    }

    @Test
    public void pressButtonCancelShouldOpenCart(){
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        checkoutPage.open();
        checkoutPage.cancel();
    }

    @Test
    public void pressButtonBackHomeShouldOpenProductPage(){
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        checkOutCompletePage.open();
        checkOutCompletePage.backHome();
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }


}

