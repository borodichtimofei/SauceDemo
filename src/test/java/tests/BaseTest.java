package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    BasePage basePage;
    CheckoutPage checkoutPage;
    NavigationPage navigationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckOutCompletePage checkOutCompletePage;

    public static final String USER = "performance_glitch_user";
    public static final String PASSWORD = "secret_sauce";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        basePage = new BasePage(driver);
        checkoutPage = new CheckoutPage(driver);
        navigationPage = new NavigationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }

}


