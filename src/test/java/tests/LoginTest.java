package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void passwordShouldBeRequired() {
        loginPage.open();
        loginPage.login("test", "");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required");
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "test");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test
    public void standardUserShouldBeLoggedIn() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.waitForLoading();
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

    @Test
    public void lockedOutUserUserShouldBeLockedOut() {
        loginPage.open();
        loginPage.login("locked_out_user", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void wrongUserNameShouldNotLogin() {
        loginPage.open();
        loginPage.login("test", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void wrongPasswordShouldNotLogin() {
        loginPage.open();
        loginPage.login(USER, "test");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void problemUserShouldBeLoggedIn() {
        loginPage.open();
        loginPage.login("problem_user", PASSWORD);
        productsPage.waitForLoading();
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

    @Test
    public void performanceGlitchUserShouldBeLoggedIn() {
        loginPage.open();
        loginPage.login("performance_glitch_user", PASSWORD);
        productsPage.waitForLoading();
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

}

