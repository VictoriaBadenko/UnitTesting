import org.junit.jupiter.api.*;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Tag("Cart")
    public void testAddRealItem() {
        // Add item to cart
        cart.addRealItem(realItem);

        // Check total price
        double expectedTotalPrice = 10.0 + 10.0 * 0.2;
        double actualTotalPrice = cart.getTotalPrice();
        assertEquals(expectedTotalPrice, actualTotalPrice, "Real Item's actual and expected total price should be matched");
    }

    @Test
    @Tag("Cart")
    public void testAddVirtualItem() {
        // Add item to cart
        cart.addVirtualItem(virtualItem);

        // Check total price
        double expectedTotalPrice = 20.0 + 20.0 * 0.2;
        double actualTotalPrice = cart.getTotalPrice();
        assertEquals(expectedTotalPrice, actualTotalPrice, "Virtual Item's actual and expected total price should be matched");
    }

    @Test
    @Tag("Cart")
    public void testDeleteRealItem() {
        // Add item to cart
        cart.addRealItem(realItem);

        // Delete items from cart
        cart.deleteRealItem(realItem);

        //Check total price after deleting item
        double expectedTotalPriceAfterDelete = 0.0;
        double actualTotalPriceAfterDelete = cart.getTotalPrice();
        assertEquals(expectedTotalPriceAfterDelete, actualTotalPriceAfterDelete, "Real Item's total price after delete should be matched with expected.");
    }

    @Test
    @Tag("Cart")
    public void testDeleteVirtualItem() {
        // Add item to cart
        cart.addVirtualItem(virtualItem);

        // Delete item from cart
        cart.deleteVirtualItem(virtualItem);

        //Check total price after deleting item
        double expectedTotalPriceAfterDelete = 0.0;
        double actualTotalPriceAfterDelete = cart.getTotalPrice();
        assertEquals(expectedTotalPriceAfterDelete, actualTotalPriceAfterDelete, "Virtual Item's total price after delete should be matched with expected.");
    }
}
