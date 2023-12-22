package luma.store.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "logged-in")
    private WebElement welcomeMessage;

    @FindBy(className = "switch")
    private WebElement accountMenuButton;

    @FindBy(css = ".customer-menu li:nth-of-type(1)")
    private WebElement myAccountButton;

    public NavigationBar getNavBar() {
        return new NavigationBar();
    }

    public void clickAccountMenuButton() {
        accountMenuButton.click();
    }

    public boolean isWelcomeMessageDisplayed() {
        driver.navigate().refresh();
        return welcomeMessage.isDisplayed();
    }

    public MyAccountPage clickMyAccountButton() {
        clickAccountMenuButton();
        myAccountButton.click();
        return new MyAccountPage();
    }
}
