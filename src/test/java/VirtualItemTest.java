import org.testng.annotations.Test;
import shop.VirtualItem;

import static org.testng.Assert.assertEquals;

public class VirtualItemTest {
    @Test(groups = {"cart"})
    public void testToString() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("Office");
        virtualItem.setPrice(1000);
        virtualItem.setSizeOnDisk(2.5);

        String actual = virtualItem.toString();
        String expected = "Class: class shop.VirtualItem; Name: Office; Price: 1000.0; Size on disk: 2.5";
        assertEquals(expected, actual, "Actual and expected string result should be matched.");
    }
}
