package unitTests;

import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealItemTest {

    @Test
    public void testToString() {
        RealItem realItem = new RealItem();
        realItem.setName("Laptop");
        realItem.setPrice(1000);
        realItem.setWeight(2.5);

        String actual = realItem.toString();
        String expected = "Class: class shop.RealItem; Name: Laptop; Price: 1000.0; Weight: 2.5";
        assertEquals(expected, actual, "Actual and expected string result should be matched.");
    }
}
