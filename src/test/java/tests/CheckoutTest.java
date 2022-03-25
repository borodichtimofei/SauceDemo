package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(description = "Проверка полного цикла покупки товара на сайте")
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

    @Test(description = "Проверка, что не выполнится CHECKOUT при незаполненных полях регистрации формы CHECKOUT")
    public void checkoutInfoShouldBeRequired() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        navigationPage.clickCart();
        cartPage.checkout();
        checkoutPage.fillInCheckoutInfo("", "", "");
        assertEquals(checkoutPage.getError(), "Error: First Name is required");
    }

    @Test(description = "Проверка, что при нажатии кнопки CANCEL происходит возвращение на странцу CART")
    public void pressButtonCancelShouldOpenCart() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        checkoutPage.open();
        checkoutPage.cancel();
    }

    @Test(description = "Проверка, что при нажатии кнопки BACK HOME происходит возвращение на странцу продуктов")
    public void pressButtonBackHomeShouldOpenProductPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        checkOutCompletePage.open();
        checkOutCompletePage.backHome();
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }


}

