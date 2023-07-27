import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.testng.AssertJUnit.assertEquals;

public class RealItemTest {

    @Test
    public void verifySetAndGetWeight() {
        RealItem realItem = new RealItem();
        double expectedWeight = 5.0;

        realItem.setWeight(expectedWeight);

        double actualWeight = realItem.getWeight();
        assertEquals(expectedWeight, actualWeight);
    }
}
