package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import luma.store.pages.CartPage;
import luma.store.pages.NavigationBar;
import luma.store.pages.StorePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;

import static luma.store.helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {
    private static NavigationBar navBar;
    private StorePage storePage;
    private CartPage cartPage;
    private int productQuantity = 3;

    @BeforeAll
    public static void login() {
        navBar = mainPage
                .clickSignIn()
                .login(EMAIL, PASSWORD)
                .getNavBar();
    }

    @Test
    @AllureId("AP-5.1")
    @Description("Verify that products are successfully added to Cart")
    public void testAddProductsToCart() {
        cartPage = navBar.goToCart();
        int initialQuantity = cartPage.getProductQuantity();
        storePage = navBar.selectCategory(WHATS_NEW_CATEGORY);
        storePage.addProductsToCart(productQuantity);
        cartPage = storePage
                .getNavBar()
                .goToCart();
        assertTrue(cartPage.isProductQuantityValid(initialQuantity, productQuantity));
    }

    @Test
    @AllureId("AP-5.2")
    @Description("Verify that product's subtotal price is correct")
    public void testSubtotalPriceOfProducts() {
        storePage = navBar.selectCategory(WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY, PANTS_SUB_CATEGORY);
        storePage.addProductsToCart(productQuantity);
        var isSubtotalPriceCorrect = storePage
                .getNavBar()
                .goToCart()
                .isProductSubtotalCorrect();
        assertTrue(isSubtotalPriceCorrect);
    }

    @AfterAll
    public static void cleanUpTheShoppingCart() {
        new CartPage().deleteProducts();
    }
}
