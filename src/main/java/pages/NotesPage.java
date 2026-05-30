package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotesPage {

    private final By deleteButton = By.cssSelector("button[data-testid='note-delete']");
    private final By confirmDeleteButton = By.cssSelector("button[data-testid='note-delete-confirm']");

    public void clickDeleteButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(deleteButton)
        );

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        js.executeScript("arguments[0].click();", button);
    }

    public void confirmDelete() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(confirmDeleteButton)
        );

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", button);
    }
}