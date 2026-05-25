package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import drivers.DriverManager;
import org.openqa.selenium.By;

public class CreateNotePage {

    private final By titleField = By.id("title");
    private final By descriptionField = By.id("description");
    private final By createButton = By.id("search-btn");

    public void enterTitle(String title) {
        DriverManager.getDriver()
                .findElement(titleField)
                .sendKeys(title);
    }

    public void enterDescription(String description) {
        DriverManager.getDriver()
                .findElement(descriptionField)
                .sendKeys(description);
    }

    public void clickCreate() {

        WebElement button =
                DriverManager.getDriver()
                        .findElement(createButton);

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", button);
        js.executeScript("arguments[0].click();", button);
    }
}
