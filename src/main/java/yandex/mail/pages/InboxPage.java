package yandex.mail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage {
    @FindBy(css = ".mail-Layout-Container")
    private WebElement mailContainer;

    @FindBy(xpath = "//a[contains(@aria-label, 'Log out')]")
    private WebElement logOut;

    @FindBy(css = "a.user-account_left-name >.user-account__name")
    private WebElement userName;

    public boolean isMailContainerDisplayed() {
        return mailContainer.isDisplayed();
    }

    public MainPage clickLogOut() {
        userName.click();
        logOut.click();

        return new MainPage();
    }
}
