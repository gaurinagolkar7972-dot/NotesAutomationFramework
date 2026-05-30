package com.expandtesting.notes.tests.ui;

import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.pages.LoginPage;
import com.expandtesting.notes.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void testLoginWithInvalidCredentials() {

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                "wrong@gmail.com",
                "wrongpassword"
        );

        By errorMessage =
                By.xpath("//*[contains(text(),'Incorrect email address or password')]");

        Assert.assertTrue(
                WaitUtils.visible(errorMessage).isDisplayed(),
                "Error message should appear for invalid login"
        );
    }

    @Test
    public void testLoginWithEmptyCredentials() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("", "");

        By validationMessage =
                By.xpath("//*[contains(text(),'Email address is required')]");

        Assert.assertTrue(
                WaitUtils.visible(validationMessage).isDisplayed(),
                "Validation message should appear"
        );
    }
}
