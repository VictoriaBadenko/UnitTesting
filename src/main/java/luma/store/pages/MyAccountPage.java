package luma.store.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//div[@data-ui-id = 'message-success']")
    private WebElement successRegistrationMessage;

    @FindBy(css = ".nav li:nth-of-type(6) a")
    private WebElement addressBookMenuTab;

    public AddressPage clickAddressBookMenuTab() {
        addressBookMenuTab.click();
        return new AddressPage();
    }

    public boolean isSuccessRegistrationMessageDisplayed() {
        return successRegistrationMessage.isDisplayed();
    }
}
