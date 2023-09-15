package yandex.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import yandex.mail.driverManager.DriverManager;

public class BasePage {
    protected static WebDriver driver;

    public BasePage() {
        driver = DriverManager.getDriverInstance();
        PageFactory.initElements(driver, this);
    }
}
