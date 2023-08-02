package unitTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for JsonParser class")
public class JsonParserTests {

    private JsonParser jsonParser;
    private Cart cart;
    private final String FILE_PATH = "src/main/resources/TestCart.json";
    private static final String EXPECTED_TEST_CART = "{\"cartName\":\"TestCart\",\"realItems\":[{\"weight\":2.5,\"name\":\"RealItem1\",\"price\":10.0}],\"virtualItems\":[{\"sizeOnDisk\":100.0,\"name\":\"VirtualItem1\",\"price\":20.0}],\"total\":36.0}";

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
    @Tag("Json Parser")
    public void testWriteToFile() throws IOException {
        // Write to file
        jsonParser.writeToFile(cart);

        String actualCart = Files.readString(Path.of(FILE_PATH));
        assertEquals(EXPECTED_TEST_CART, actualCart, "The file should be matched with EXPECTED_TEST_CART");
    }

    @Test
    @Tag("Json Parser")
    public void testReadFromFile() {
        File file = new File(FILE_PATH);

        // Write to file
        jsonParser.writeToFile(cart);

        // Read from file
        Cart readCart = jsonParser.readFromFile(file);

        assertAll(
                () -> assertNotNull(readCart),
                () -> assertEquals(cart.getCartName(), readCart.getCartName()),
                () -> assertEquals(cart.getTotalPrice(), readCart.getTotalPrice())
        );
    }

    @Disabled("Test disabled due to non relevant data")
    @ParameterizedTest
    @Tag("Json Parser")
    @ValueSource(strings = {"File1.json", "File2.json", "File3.json", "File4.json", "File5.json"})
    public void testReadFromNonExistentFile(File nonExistentFile) {
        // For each file, assert that reading from it throws NoSuchFileException
        assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(nonExistentFile));
    }
}