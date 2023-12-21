package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;
import luma.store.pages.CartPage;
import luma.store.pages.HomePage;
import luma.store.pages.StorePage;

import static luma.store.helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {
    private HomePage homePage;
    private StorePage storePage;
    private CartPage cartPage;

    @BeforeEach
    public void login() {
        homePage = mainPage
                .clickSignIn()
                .login(EMAIL, PASSWORD);
    }

    @Test
    @AllureId("AP-5.1")
    @Description("Verify that products are successfully added to Cart")
    public void addProductsToCartTest() {
        int productQuantity = 3;
        storePage = homePage.getNavBar().selectCategory(NEW_CATEGORY);
        storePage.addProductsToCart(productQuantity);
        cartPage = storePage.getNavBar().goToCart();
        assertEquals(productQuantity, cartPage.getProductQuantity());
    }

    @Test
    @AllureId("AP-5.2")
    @Description("Verify that product's subtotal price is correct")
    public void testCheckoutCartItems() {
        int productQuantity = 3;
        storePage = homePage
                .getNavBar()
                .selectCategory(WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY, PANTS_SUB_CATEGORY);
        storePage.addProductsToCart(productQuantity);
        var isSubtotalPriceCorrect = storePage
                .getNavBar()
                .goToCart()
                .isProductSubtotalCorrect();
        assertTrue(isSubtotalPriceCorrect);
    }

    @AfterEach
    public void cleanUpTheShoppingCart() {
        new CartPage().deleteProducts();
    }
}
