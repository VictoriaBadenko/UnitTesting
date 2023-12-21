package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;
import luma.store.pages.HomePage;
import luma.store.pages.WishListPage;

import static luma.store.helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishListTest extends BaseTest {
    private HomePage homePage;
    private WishListPage wishlistPage;

    @BeforeEach
    public void login() {
        homePage = mainPage
                .clickSignIn()
                .login(EMAIL, PASSWORD);
    }

    @Test
    @Feature("Ability to Add Product to Wishlist")
    @AllureId("AP-4")
    @Description("Check if product is successfully added to wishlist")
    public void addProductToWishlistTest() {
        wishlistPage = homePage
                .getNavBar()
                .selectCategory(WOMEN_CATEGORY, TOPS_SUB_CATEGORY, JACKETS_SUB_CATEGORY)
                .goToProductPage(WOMAN_JACKET)
                .wishlistProduct();
        assertTrue(wishlistPage.isProductWishlistMessageDisplayed());
    }

    @AfterEach
    public void cleanUpTheWishlist() {
        wishlistPage.removeItemFromWishlist();
    }
}
