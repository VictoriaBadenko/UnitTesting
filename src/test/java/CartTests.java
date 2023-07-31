import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Tests for Cart class")
public class CartTests {
    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeEach
    public void setup() {
        cart = new Cart("TestCart");
        realItem = new RealItem();
        realItem.setName("RealItem1");
        realItem.setPrice(10.0);
        realItem.setWeight(2.5);

        virtualItem = new VirtualItem();
        virtualItem.setName("VirtualItem1");
        virtualItem.setPrice(20.0);
        virtualItem.setSizeOnDisk(100.0);
    }

    @Test
    public void testAddItems() {
        // Add items to cart
        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);

        // Check if items are present in the cart
        assertTrue(cart.getRealItems().contains(realItem));
        assertTrue(cart.getVirtualItems().contains(virtualItem));

        // Check total price
        double expectedTotalPrice = 10.0 + 10.0 * 0.2 + 20.0 + 20.0 * 0.2;
        double actualTotalPrice = cart.getTotalPrice();
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void testDeleteItems() {
        // Add items to cart
        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);

        // Delete items from cart
        cart.deleteRealItem(realItem);
        cart.deleteVirtualItem(virtualItem);

        // Check if items are no longer present in the cart
        assertFalse(cart.getRealItems().contains(realItem));
        assertFalse(cart.getVirtualItems().contains(virtualItem));

        //Check total price after deleting items
        double expectedTotalPriceAfterDelete = 0.0;
        double actualTotalPriceAfterDelete = cart.getTotalPrice();
        assertEquals(expectedTotalPriceAfterDelete, actualTotalPriceAfterDelete);
    }
}
