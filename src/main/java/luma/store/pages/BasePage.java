package luma.store.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import luma.store.driverManager.DriverManager;
import luma.store.helpers.Waiter;

public class BasePage {
    protected static WebDriver driver;
    protected Waiter waiter = new Waiter(driver);

    public BasePage() {
        this.driver = DriverManager.getDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void scrollIntoView(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .perform();
    }
}
