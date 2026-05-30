package com.expandtesting.notes.tests.ui;

import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.pages.LoginPage;
import com.expandtesting.notes.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testUserLogoutSuccessfully() {

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        By logoutButton =
                By.xpath("//button[contains(.,'Logout')]");

        WaitUtils.clickable(logoutButton).click();

        By loginHeading =
                By.xpath("//*[contains(text(),'Login')]");

        Assert.assertTrue(
                WaitUtils.visible(loginHeading).isDisplayed(),
                "User should logout successfully"
        );
    }
}
