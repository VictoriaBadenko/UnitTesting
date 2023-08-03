import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.*;

public class JsonParserTests {
    private JsonParser jsonParser;
    private Cart cart;
    private final String FILE_PATH = "src/main/resources/TestCart.json";
    private static final String EXPECTED_TEST_CART = "{\"cartName\":\"TestCart\",\"realItems\":[{\"weight\":2.5,\"name\":\"RealItem1\"," +
            "\"price\":10.0}],\"virtualItems\":[{\"sizeOnDisk\":100.0,\"name\":\"VirtualItem1\",\"price\":20.0}],\"total\":36.0}";

    @BeforeClass
    public void setup() {
        jsonParser = new JsonParser();
        cart = new Cart("TestCart");
        RealItem realItem = new RealItem();
        realItem.setName("RealItem1");
        realItem.setPrice(10.0);
        realItem.setWeight(2.5);

        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("VirtualItem1");
        virtualItem.setPrice(20.0);
        virtualItem.setSizeOnDisk(100.0);

        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);
        cart.showItems();
    }

    @AfterClass
    public void cleanup() {
        new File(FILE_PATH).delete();
    }

    @Test(groups = {"jsonParser"})
    public void testWriteToFile() throws IOException {
        // Write to file
        jsonParser.writeToFile(cart);

        String actualCart = Files.readString(Path.of(FILE_PATH));
        assertEquals(actualCart, EXPECTED_TEST_CART, "The file should be matched with EXPECTED_TEST_CART");
    }

    @Test(groups = {"jsonParser"})
    public void testReadFromFile() {
        File file = new File(FILE_PATH);
        SoftAssert softAssert = new SoftAssert();

        // Write to file
        jsonParser.writeToFile(cart);

        // Read from file
        Cart readCart = jsonParser.readFromFile(file);

        //Added grouped assertion
        softAssert.assertNotNull(readCart);
        softAssert.assertEquals(cart.getCartName(), readCart.getCartName());
        softAssert.assertEquals(cart.getTotalPrice(), readCart.getTotalPrice());
        softAssert.assertAll();
    }

    @DataProvider(name = "nonExistentFiles")
    public Object[][] getNonExistentFiles() {
        return new Object[][]{
                {"File1.json"},
                {"File2.json"},
                {"File3.json"},
                {"File4.json"},
                {"File5.json"}
        };
    }

    @Ignore("Test ignored due to non relevant data")
    @Test(dataProvider = "nonExistentFiles", groups = {"jsonParser"})
    public void testReadFromNonExistentFile(String nonExistentFile) {
        // For each file, assert that reading from it throws NoSuchFileException
        assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(new File(nonExistentFile)));
    }
}

