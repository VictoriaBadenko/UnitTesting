import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTest {

    @Test
    public void testSetAndGetDiskSize() {
        VirtualItem virtualItem = new VirtualItem();
        double expectedSizeOnDisk = 500.0;

        virtualItem.setSizeOnDisk(expectedSizeOnDisk);

        double actualSizeOnDisk = virtualItem.getSizeOnDisk();
        assertEquals(expectedSizeOnDisk, actualSizeOnDisk);
    }
}
