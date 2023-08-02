import org.testng.annotations.Test;
import shop.RealItem;

import static org.testng.Assert.assertEquals;

public class RealItemTest {
    @Test(groups = {"cart"})
    public void testToString() {
        RealItem realItem = new RealItem();
        realItem.setName("Laptop");
        realItem.setPrice(1000);
        realItem.setWeight(2.5);

        String actual = realItem.toString();
        String expected = "Class: class shop.RealItem; Name: Laptop; Price: 1000.0; Weight: 2.5";
        assertEquals(actual, expected, "Actual and expected string result should be matched.");
    }
}
