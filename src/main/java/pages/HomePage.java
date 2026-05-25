package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public void clickAddNote() {

        WebDriverWait wait =
                new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));

        WebElement addNoteButton =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'Add Note')]")
                ));

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript("arguments[0].click();", addNoteButton);
    }
}