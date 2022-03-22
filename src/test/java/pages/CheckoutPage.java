package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By ERROR_MASSAGE = By.cssSelector("[data-test = error]");
    public static final By CANCEL_BUTTON = By.id("cancel");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/checkout-step-one.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_INPUT));
    }

    public void fillInCheckoutInfo(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }

    public void cancel(){
        driver.findElement(CANCEL_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

}
