package luma.store.pages;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static luma.store.helpers.Constants.CART_URL;

public class NavigationBar extends BasePage {
    @FindBy(css = "a.level-top")
    private List<WebElement> categories;

    @FindBy(css = ".parent .category-item a")
    private List<WebElement> subcategories;

    public StorePage selectCategory(String categoryName, String... subcategoryNames) {
        WebElement selectedCategory = categories.stream().filter(categories -> categoryName.equals(categories.getText()))
                .findFirst().orElseThrow(RuntimeException::new);
        if (!ArrayUtils.isEmpty(subcategoryNames)) {
            scrollIntoView(selectedCategory);
            for (String subcategoryName : subcategoryNames) {
                selectedCategory = subcategories.stream().filter(subcategories -> subcategoryName.equals(subcategories.getText()))
                        .findFirst().orElseThrow(RuntimeException::new);
                scrollIntoView(selectedCategory);
            }
        }
        selectedCategory.click();
        return new StorePage();
    }

    public CartPage goToCart() {
        driver.get(CART_URL);
        driver.navigate().refresh();
        return new CartPage();
    }
}
