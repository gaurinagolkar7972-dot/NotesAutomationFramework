package com.expandtesting.notes.pages;
import com.expandtesting.notes.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.expandtesting.notes.utils.WaitUtils;
import org.openqa.selenium.By;

public class LoginPage {

    private final By emailInput =
            By.cssSelector("input[data-testid='login-email']");

    private final By passwordInput =
            By.cssSelector("input[data-testid='login-password']");

    private final By loginButton =
            By.cssSelector("button[data-testid='login-submit']");

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
