package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Listeners (TestListener.class)
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

    public static final String USER = "standard_user"; //System.getProperty("user");
    public static final String PASSWORD = "secret_sauce";

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser ) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

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


