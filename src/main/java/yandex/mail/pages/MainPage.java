package yandex.mail.pages;

import org.openqa.selenium.WebDriver;

import static yandex.mail.Locators.LOG_IN_BUTTON;

public class MainPage {
    private WebDriver driver;

    public MainPage openWebSite() {
        driver.get("https://mail.yandex.com/");
        return this;
    }

    public LogInPage openLoginPage() {
        driver.findElement(LOG_IN_BUTTON).click();

        return new LogInPage();
    }
}
