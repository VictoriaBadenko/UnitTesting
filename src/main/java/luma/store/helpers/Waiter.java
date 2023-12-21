package luma.store.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiter {
    private WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForWebElementVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofMillis(200))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForNumberOfElementsToBe(List<WebElement> elements, int number) {
        new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(200))
                .until(new ExpectedCondition<List<WebElement>>() {
                    @Override
                    public List<WebElement> apply(WebDriver webDriver) {
                        Integer currentNumber;
                        currentNumber = elements.size();
                        return currentNumber.equals(number) ? elements : null;
                    }
                });
    }
}
