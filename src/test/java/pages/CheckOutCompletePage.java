package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutCompletePage extends BasePage{

    public static final By BACK_HOME_BUTTON = By.id("back-to-products");
    public static final By COMPLETE_INFO = By.cssSelector(".title");


    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void open (){
        driver.get(baseUrl + "/checkout-complete.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(BACK_HOME_BUTTON));
    }

    public void backHome(){
        driver.findElement(BACK_HOME_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
    }

    public String getCompleteTitle() {
        return driver.findElement(COMPLETE_INFO).getText();
    }

}
