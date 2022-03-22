package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
