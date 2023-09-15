package yandex.mail.pages;

import org.openqa.selenium.By;

public class InboxPage extends BasePage {
    private static final By MAIL_CONTAINER = By.cssSelector(".mail-Layout-Container");
    private static final By LOGOUT = By.xpath("//a[contains(@aria-label, 'Log out')]");
    private static final By USER_NAME = By.cssSelector("a.user-account_left-name >.user-account__name");

    public boolean isMailContainerDisplayed() {
        return driver.findElement(MAIL_CONTAINER).isDisplayed();
    }

    public MainPage clickLogOut() {
        driver.findElement(USER_NAME).click();
        driver.findElement(LOGOUT).click();

        return new MainPage();
    }
}
