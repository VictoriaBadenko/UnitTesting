package seleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class MultiSelectTest extends BaseTest {
    private static final String DROPDOWN_DEMO_URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private static final By STATES_LIST = By.id("multi-select");

    @Test
    public void verifyMultiSelectList() {
        driver.get(DROPDOWN_DEMO_URL);
        WebElement list = driver.findElement(STATES_LIST);
        Select select = new Select(list);
        List<String> allStates = select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        Collections.shuffle(allStates);
        List<String> randomStates = allStates.subList(0, 3);
        randomStates.forEach(select::selectByValue);
        List<String> actualStates = select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        assertTrue(randomStates.containsAll(actualStates));
    }
}
