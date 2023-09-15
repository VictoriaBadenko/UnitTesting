package yandex.mail.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.cssSelector("#passp-field-login");
    private static final By LOG_IN = By.id("passp:sign-in");
    private static final By LOG_IN_TO_MAIL = By.xpath("//button[contains(@class, 'Button2_type_submit')]");
    private static final By PASSWORD_INPUT = By.name("passwd");

    public LoginPage inputUsername(String userName) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);

        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(LOG_IN).click();

        return this;
    }

    public LoginPage inputPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);

        return this;
    }

    public InboxPage clickLoginToMail() {
        driver.findElement(LOG_IN_TO_MAIL).click();

        return new InboxPage();
    }

    public InboxPage loginToYandexMail(String userName, String password) {
        inputUsername(userName);
        clickLogin();
        inputPassword(password);
        clickLoginToMail();

        return new InboxPage();
    }
}
