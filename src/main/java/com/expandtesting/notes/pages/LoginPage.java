package com.expandtesting.notes.pages;
import com.expandtesting.notes.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.expandtesting.notes.utils.WaitUtils;
import org.openqa.selenium.By;

public class LoginPage {

    private final By emailInput =
            By.id("email");

    private final By passwordInput =
            By.id("password");

    private final By loginButton =
            By.cssSelector("button[type='submit']");

    public void login(String email, String password) {

        WaitUtils.visible(emailInput)
                .sendKeys(email);

        WaitUtils.visible(passwordInput)
                .sendKeys(password);

        WebElement button =
                WaitUtils.clickable(loginButton);

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].click();", button);
    }
}
