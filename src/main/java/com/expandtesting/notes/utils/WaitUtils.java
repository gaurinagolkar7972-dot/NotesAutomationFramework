package com.expandtesting.notes.utils;

import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait() {
        int waitTime = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
    }

    public static WebElement visible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement clickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageLoad() {
        getWait().until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }
}
