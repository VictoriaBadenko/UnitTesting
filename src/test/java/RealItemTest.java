import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.RealItem;

import static org.testng.Assert.assertEquals;

public class RealItemTest {
    @Test(groups = {"cart"})
    @Parameters({"name", "price", "weight"})
    public void testToString(String name, int price, double weight) {
        RealItem realItem = new RealItem();
        realItem.setName(name);
        realItem.setPrice(price);
        realItem.setWeight(weight);

        String actual = realItem.toString();
        String expected = "Class: class shop.RealItem; Name: Laptop; Price: 1000.0; Weight: 2.5";
        assertEquals(actual, expected, "Actual and expected string result should be matched.");
    }
}
