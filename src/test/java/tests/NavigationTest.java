package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(description = "Проверка, что количество продуктов корректно отображается в элементе Корзина при добавлении/удалении")
    public void inCartShouldDisplayTheQuantityProductsAdded() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.removeFromCart("Sauce Labs Backpack");
        Assert.assertEquals(navigationPage.getProductsInCart(), "2");
    }


}
