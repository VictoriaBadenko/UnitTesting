package luma.store.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {
    @FindBy(className = "message-success")
    private WebElement productWishlistMessage;

    @FindBy(xpath = "//a[contains(@class, 'btn-remove')]")
    private WebElement removeItemButton;

    @FindBy(className = "product-item-name")
    private WebElement productItemName;

    public boolean isProductWishlistMessageDisplayed() {
        return productWishlistMessage.isDisplayed();
    }

    public WishListPage removeItemFromWishlist() {
        scrollIntoView(productItemName);
        removeItemButton.click();
        return this;
    }
}
