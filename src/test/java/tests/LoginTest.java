package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Входящие данные для негативных тестов на логин")
    public Object[][] loginDataNegative() {
        return new Object[][]{
                {"test", "", "Epic sadface: Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"},
                {"locked_out_user", PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
                {USER, "test", "Epic sadface: Username and password do not match any user in this service"},
                {"test", PASSWORD, "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @DataProvider(name = "Входящие данные для позитивных тестов на логин")
    public Object[][] loginDataPositive() {
        return new Object[][]{
                {USER, PASSWORD, "PRODUCTS"},
                {"problem_user", PASSWORD, "PRODUCTS"},
                {"performance_glitch_user", PASSWORD, "PRODUCTS"},
        };
    }

    @Test(description = "Проверка логина с негативными данными", dataProvider = "Входящие данные для негативных тестов на логин", retryAnalyzer = Retry.class)
    public void ifTheDataIsIncorrectLoginShouldNotBePerformed(String user, String password, String error) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), error, "Message error is not correct");
    }

    @Test(description = "Проверка логина с позитивными данными", dataProvider = "Входящие данные для позитивных тестов на логин")
    public void withCorrectDataLoginShouldBePerformed(String user, String password, String titlePage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(productsPage.getTitle(), titlePage, "Login failed");
    }
}

