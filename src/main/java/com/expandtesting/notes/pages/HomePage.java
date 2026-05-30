package com.expandtesting.notes.pages;

import com.expandtesting.notes.drivers.DriverManager;
import com.expandtesting.notes.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final By logoutButton =
            By.xpath("//button[contains(.,'Logout') or contains(.,'Log out')]");

    private final By addNoteButton =
            By.cssSelector("[data-testid='add-new-note']");

    public boolean isPageLoaded() {
        return WaitUtils.visible(logoutButton).isDisplayed();
    }

    public void goToAddNote() {
        WebElement button = WaitUtils.visible(addNoteButton);

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].click();", button);
    }

    public boolean isNoteVisible(String title) {
        By noteTitle = By.xpath("//*[contains(normalize-space(),'" + title + "')]");
        return WaitUtils.visible(noteTitle).isDisplayed();
    }
}