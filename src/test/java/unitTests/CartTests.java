import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.testng.Assert.assertEquals;

public class CartTests {
    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeMethod(alwaysRun = true)
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

    @Test(groups = {"cart"})
    public void testAddRealItem() {
        // Add item to cart
        cart.addRealItem(realItem);

        // Check total price
        double expectedTotalPrice = 10.0 + 10.0 * 0.2;
        double actualTotalPrice = cart.getTotalPrice();
        assertEquals(actualTotalPrice, expectedTotalPrice, "Real Item's actual and expected total price should be matched");
    }

    @Test(groups = {"cart"})
    public void testAddVirtualItem() {
        // Add item to cart
        cart.addVirtualItem(virtualItem);

        // Check total price
        double expectedTotalPrice = 20.0 + 20.0 * 0.2;
        double actualTotalPrice = cart.getTotalPrice();
        assertEquals(actualTotalPrice, expectedTotalPrice, "Virtual Item's actual and expected total price should be matched");
    }

    @Test(groups = {"cart"})
    public void testDeleteRealItem() {
        // Add item to cart
        cart.addRealItem(realItem);

        // Delete items from cart
        cart.deleteRealItem(realItem);

        // Check total price after deleting item
        double expectedTotalPriceAfterDelete = 0.0;
        double actualTotalPriceAfterDelete = cart.getTotalPrice();
        assertEquals(actualTotalPriceAfterDelete, expectedTotalPriceAfterDelete, "Real Item's total price after delete should be matched with expected.");
    }

    @Test(groups = {"cart"})
    public void testDeleteVirtualItem() {
        // Add item to cart
        cart.addVirtualItem(virtualItem);

        // Delete item from cart
        cart.deleteVirtualItem(virtualItem);

        // Check total price after deleting item
        double expectedTotalPriceAfterDelete = 0.0;
        double actualTotalPriceAfterDelete = cart.getTotalPrice();
        assertEquals(actualTotalPriceAfterDelete, expectedTotalPriceAfterDelete, "Virtual Item's total price after delete should be matched with expected.");
    }
}