import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Tests for JsonParser class")
public class JsonParserTests {

    private JsonParser jsonParser;
    private Cart cart;
    private final String FILE_PATH = "src/main/resources/TestCart.json";

    @TempDir
    public File tempDir;

    @BeforeEach
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

    @AfterEach
    public void cleanup() {
        new File(FILE_PATH).delete();
    }

    @Test
    public void verifyWriteAndReadFromFile() {
        File file = new File(FILE_PATH);

        // Write to file
        jsonParser.writeToFile(cart);

        // Read from file
        Cart readCart = jsonParser.readFromFile(file);

        assertNotNull(readCart);
        assertEquals(cart.getCartName(), readCart.getCartName());
        assertEquals(cart.getTotalPrice(), readCart.getTotalPrice());
    }

    @Disabled
    @Test
    public void verifyReadFromNonExistentFile() {
        // Define five different files to test NoSuchFileException
        File file1 = new File(tempDir, "File1.json");
        File file2 = new File(tempDir, "File2.json");
        File file3 = new File(tempDir, "File3.json");
        File file4 = new File(tempDir, "File4.json");
        File file5 = new File(tempDir, "File5.json");

        // For each file, assert that reading from it throws NoSuchFileException
        // Added grouped assertion
        assertAll(
                () -> assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file1)),
                () -> assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file2)),
                () -> assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file3)),
                () -> assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file4)),
                () -> assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file5))
        );
    }
}