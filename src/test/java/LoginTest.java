import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void standardUserShouldBeLogin() {
        driver.get("https://www.saucedemo.com/");
        String loginInfo = driver.findElement(By.id("login_credentials")).getText();
        String passwordInfo = driver.findElement(By.cssSelector(".login_password")).getText();
        String loginFirst = loginInfo.split("\n")[1];
        String password = passwordInfo.split("\n")[1];
        driver.findElement(By.id("user-name")).sendKeys(loginFirst);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("user-name")).submit();
        String pageNext = driver.findElement(By.className("title")).getText();
        assertEquals(pageNext, "PRODUCTS", "Not login");
    }

    @Test
    public void lockedOutUserShouldBeLocked() {
        driver.get("https://www.saucedemo.com/");
        String loginInfo = driver.findElement(By.id("login_credentials")).getText();
        String passwordInfo = driver.findElement(By.cssSelector(".login_password")).getText();
        String loginSecond = loginInfo.split("\n")[2];
        String password = passwordInfo.split("\n")[1];
        driver.findElement(By.id("user-name")).sendKeys(loginSecond);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("user-name")).submit();
        String error = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']")).getText();
        assertEquals(error, "Epic sadface: Sorry, this user has been locked out.", "Not correct");
    }

    @Test
    public void problemUserShouldBeLogin() {
        driver.get("https://www.saucedemo.com/");
        String loginInfo = driver.findElement(By.id("login_credentials")).getText();
        String passwordInfo = driver.findElement(By.cssSelector(".login_password")).getText();
        String loginThird = loginInfo.split("\n")[3];
        String password = passwordInfo.split("\n")[1];
        driver.findElement(By.id("user-name")).sendKeys(loginThird);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("user-name")).submit();
        String pageNext = driver.findElement(By.className("title")).getText();
        assertEquals(pageNext, "PRODUCTS", "Not login");
    }

    @Test
    public void performanceGlitchUserShouldBeLogin() {
        driver.get("https://www.saucedemo.com/");
        String loginInfo = driver.findElement(By.id("login_credentials")).getText();
        String passwordInfo = driver.findElement(By.cssSelector(".login_password")).getText();
        String loginSecond = loginInfo.split("\n")[4];
        String password = passwordInfo.split("\n")[1];
        driver.findElement(By.id("user-name")).sendKeys(loginSecond);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("user-name")).submit();
        String pageNext = driver.findElement(By.className("title")).getText();
        assertEquals(pageNext, "PRODUCTS", "Not login");
    }

    @Test
    public void loginShouldNotBeAcceptWithIncorrectPassword() {
        driver.get("https://www.saucedemo.com/");
        String loginInfo = driver.findElement(By.id("login_credentials")).getText();
        String loginFirst = loginInfo.split("\n")[1];
        driver.findElement(By.id("user-name")).sendKeys(loginFirst);
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.id("user-name")).submit();
        String error = driver.findElement(By.xpath("//h3[text()='Epic sadface:" +
                " Username and password do not match any user in this service']")).getText();
        assertEquals(error,
                "Epic sadface: Username and password do not match any user in this service", "Not correct");
    }

    @Test
    public void loginShouldNotBeAcceptWithIncorrectLogin() {
        driver.get("https://www.saucedemo.com/");
        String passwordInfo = driver.findElement(By.cssSelector(".login_password")).getText();
        String password = passwordInfo.split("\n")[1];
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("user-name")).submit();
        String error = driver.findElement(By.xpath("//h3[text()='Epic sadface:" +
                " Username and password do not match any user in this service']")).getText();
        assertEquals(error,
                "Epic sadface: Username and password do not match any user in this service", "Not correct");
    }

    @Test
    public void loginShouldNotBeAcceptWithEmptyLoginPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username is required']")).getText();
        assertEquals(error, "Epic sadface: Username is required", "Not correct");
    }
}

