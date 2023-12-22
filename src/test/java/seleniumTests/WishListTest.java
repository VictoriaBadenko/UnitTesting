package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import luma.store.pages.HomePage;
import luma.store.pages.WishListPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;

import static luma.store.helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishListTest extends BaseTest {
    private static HomePage homePage;
    private static WishListPage wishlistPage;

    @BeforeAll
    public static void login() {
        homePage = mainPage
                .clickSignIn()
                .login(EMAIL, PASSWORD);
    }

    @Test
    @Feature("Ability to Add Product to Wishlist")
    @AllureId("AP-4")
    @Description("Check if product is successfully added to wishlist")
    public void testAddProductToWishlist() {
        wishlistPage = homePage
                .getNavBar()
                .selectCategory(WOMEN_CATEGORY, TOPS_SUB_CATEGORY, JACKETS_SUB_CATEGORY)
                .goToProductPage(WOMAN_JACKET_PRODUCT_NAME)
                .wishlistProduct();
        assertTrue(wishlistPage.isProductWishlistMessageDisplayed());
    }

    @AfterAll
    public static void cleanUpTheWishlist() {
        wishlistPage.removeItemFromWishlist();
    }
}
