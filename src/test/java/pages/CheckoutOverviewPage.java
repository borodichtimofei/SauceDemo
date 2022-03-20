package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage{

    public static final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(baseUrl + "/checkout-complete.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
    }

    public void finish() {
        driver.findElement(FINISH_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
    }

    public void waitForLoading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
    }

}
