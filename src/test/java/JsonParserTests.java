import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for JsonParser class")
public class JsonParserTests {

    private JsonParser jsonParser;
    private Cart cart;
    private final String FILE_PATH = "src/main/resources/TestCart.json";

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
    public void testWriteToFile() {
        File file = new File(FILE_PATH);

        // Write to file
        jsonParser.writeToFile(cart);

        assertTrue(file.exists(), "The file should be created");
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
    @MethodSource("nonExistentFilesProvider")
    public void testReadFromNonExistentFile(File nonExistentFile) {
        // For each file, assert that reading from it throws NoSuchFileException
        assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(nonExistentFile));
    }

    private static Stream<File> nonExistentFilesProvider() {
        return Stream.of(
                new File("File1.json"),
                new File("File2.json"),
                new File("File3.json"),
                new File("File4.json"),
                new File("File5.json")
        );
    }
}