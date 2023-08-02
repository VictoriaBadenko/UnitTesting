package unitTests;

import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTest {

    @Test
    public void testToString() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("Office");
        virtualItem.setPrice(1000);
        virtualItem.setSizeOnDisk(2.5);

        String actual = virtualItem.toString();
        String expected = "Class: class shop.VirtualItem; Name: Laptop; Price: 1000.0; Size on disk: 2.5";
        assertEquals(expected, actual, "Actual and expected string result should be matched.");
    }
}
