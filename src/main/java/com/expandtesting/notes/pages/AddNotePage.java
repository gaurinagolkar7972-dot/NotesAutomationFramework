package com.expandtesting.notes.pages;
import com.expandtesting.notes.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.expandtesting.notes.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddNotePage {

    private final By titleInput =
            By.cssSelector("[data-testid='note-title']");

    private final By descriptionInput =
            By.cssSelector("[data-testid='note-description']");

    private final By categoryDropdown =
            By.cssSelector("[data-testid='note-category']");

    private final By createButton =
            By.cssSelector("[data-testid='note-submit']");

    public void createNote(
            String title,
            String description,
            String category) {

        WaitUtils.visible(titleInput).sendKeys(title);

        WaitUtils.visible(descriptionInput)
                .sendKeys(description);

        Select select = new Select(
                WaitUtils.visible(categoryDropdown));

        select.selectByVisibleText(category);

        WebElement createBtn =
                WaitUtils.clickable(createButton);

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].click();", createBtn);
    }
}
