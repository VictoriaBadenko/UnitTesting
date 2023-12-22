package luma.store.pages;

import luma.store.dto.Address;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Add New Address']")
    private WebElement addNewAddressButton;

    @FindBy(id = "telephone")
    private WebElement phoneNumberField;

    @FindBy(id = "street_1")
    private WebElement firstStreetAddressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "region_id")
    private WebElement stateDropDown;

    @FindBy(id = "zip")
    private WebElement zipCodeField;

    @FindBy(className = "save")
    private WebElement saveAddressButton;

    @FindBy(className = "message-success")
    private WebElement addressSavedSuccessMessage;

    @FindBy(xpath = "//a[@class = 'action delete']")
    private WebElement deleteAddressLink;

    @FindBy(xpath = "//button[contains(@class, 'action-accept')]")
    private WebElement okButton;

    @FindBy(xpath = "//div[text() = 'You deleted the address.']")
    private WebElement deleteAddressMessage;

    public AddressPage addNewAddress() {
        scrollIntoView(addNewAddressButton);
        addNewAddressButton.click();
        Address address = new Address();
        firstStreetAddressField.sendKeys(address.getFirsStreet());
        cityField.sendKeys(address.getCity());
        phoneNumberField.sendKeys(address.getTelephoneNumber());
        zipCodeField.sendKeys(address.getZipCode());
        Select stateDropDown = new Select(this.stateDropDown);
        stateDropDown.selectByValue("1");
        scrollIntoView(saveAddressButton);
        saveAddressButton.click();
        return this;
    }

    public boolean isAddressSavedMessageDisplayed() {
        return addressSavedSuccessMessage.isDisplayed();
    }

    public AddressPage deleteAddress() {
        deleteAddressLink.click();
        okButton.click();
        wait.waitForWebElementVisibility(deleteAddressMessage);
        return this;
    }
}
