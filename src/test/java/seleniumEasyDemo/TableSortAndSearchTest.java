package seleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TableSortAndSearchTest extends BaseTest {
    private static final String TABLE_SORT_SEARCH_URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    private static final By ENTRIES_DROPDOWN = By.name("example_length");
    private static final By TABLE_RAW = By.xpath("//tbody/tr");
    private static final By NEXT_BUTTON = By.id("example_next");

    @Test
    public void sortAndSearchEmployees() {
        driver.get(TABLE_SORT_SEARCH_URL);
        Select counts = new Select(driver.findElement(ENTRIES_DROPDOWN));
        counts.selectByVisibleText("10");
        List<Employee> sortedEmployees = getFilteredEmployees(35, 200500);
    }

    public List<Employee> getFilteredEmployees(int minAge, double maxSalary) {
        List<Employee> filteredEmployees = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        while (true) {
            List<WebElement> rows = driver.findElements(TABLE_RAW);

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                String name = cells.get(0).getText();
                String position = cells.get(1).getText();
                String office = cells.get(2).getText();
                int age = Integer.parseInt(cells.get(3).getText());
                int salary = Integer.parseInt(cells.get(5).getAttribute("data-order")
                        .replace("$", "")
                        .replace(",", "")
                        .replace("/y", ""));

                if (age > minAge && salary <= maxSalary) {
                    filteredEmployees.add(new Employee(name, position, office));
                }
            }

            WebElement nextButton = driver.findElement(NEXT_BUTTON);
            if (!nextButton.getAttribute("class").contains("disabled")) {
                nextButton.click();
                wait.until(ExpectedConditions.stalenessOf(rows.get(0))); // Wait for the table to reload
            } else {
                break;
            }
        }

        return filteredEmployees;
    }

    private static class Employee {
        String name;
        String position;
        String office;

        private Employee(String name, String position, String office) {
            this.name = name;
            this.position = position;
            this.office = office;
        }
    }
}
