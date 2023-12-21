package luma.store.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.text.NumberFormat.getCurrencyInstance;

public class CartPage extends BasePage {
    @FindBy(css = ".input-text.qty")
    private List<WebElement> productQuantities;

    @FindBy(css = ".subtotal .cart-price .price")
    private List<WebElement> productSubtotals;

    @FindBy(css = ".sub .price")
    private WebElement subtotalPrice;

    @FindBy(xpath = "//tr[@class = 'item-info']")
    private List<WebElement> products;

    @FindBy(xpath = "//a[contains(@class, 'action-delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@class = 'cart-empty']")
    private WebElement emptyCartText;

    public int getProductQuantity() {
        int initialQuantity = 0;
        for (WebElement productQuantity : productQuantities) {
            int quantity = parseInt(productQuantity.getAttribute("value"));
            initialQuantity += quantity;
        }
        return initialQuantity;
    }

    public boolean isProductSubtotalCorrect() {
        double expectedSubtotal = extractDouble(subtotalPrice.getText());
        double actualSubtotal = 0;
        for (WebElement productSubtotal : productSubtotals) {
            double subtotal = extractDouble(productSubtotal.getText());
            actualSubtotal += subtotal;
        }
        return actualSubtotal == expectedSubtotal;
    }

    public boolean isProductQuantityValid(int initialQuantity, int addedQuantity) {
        int finalQuantity = getProductQuantity();
        return initialQuantity + addedQuantity == finalQuantity;
    }

    @SneakyThrows
    public static String extractMoneyValue(String text) {
        return getCurrencyInstance(Locale.US).parse(text).toString();
    }

    public double extractDouble(String text) {
        return parseDouble(extractMoneyValue(text));
    }

    public CartPage deleteProducts() {
        waiter.waitForWebElementVisibility(deleteButton);
        driver.navigate().refresh();
        int productsSize = products.size();
        for (int i = 0; i < productsSize; i++) {
            waiter.waitForNumberOfElementsToBe(products, productsSize - i);
            deleteButton.click();
        }
        waiter.waitForWebElementVisibility(emptyCartText);
        return new CartPage();
    }
}