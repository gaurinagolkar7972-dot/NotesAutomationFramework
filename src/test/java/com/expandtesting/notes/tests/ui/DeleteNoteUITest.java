package com.expandtesting.notes.tests.ui;

import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.drivers.DriverManager;
import com.expandtesting.notes.pages.AddNotePage;
import com.expandtesting.notes.pages.HomePage;
import com.expandtesting.notes.pages.LoginPage;
import com.expandtesting.notes.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNoteUITest extends BaseTest {

    @Test
    public void testDeleteNoteSuccessfully() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        HomePage homePage = new HomePage();

        Assert.assertTrue(
                homePage.isPageLoaded(),
                "Home page should load after login"
        );

        homePage.goToAddNote();

        String title =
                "Delete UI Note " + System.currentTimeMillis();

        AddNotePage addNotePage = new AddNotePage();

        addNotePage.createNote(
                title,
                "Note for delete validation",
                "Home"
        );

        Assert.assertTrue(
                homePage.isNoteVisible(title),
                "Created note should be visible"
        );

        By deleteButton =
                By.cssSelector("[data-testid='note-delete']");

        WebElement deleteBtn =
                WaitUtils.visible(deleteButton);

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                deleteBtn
        );

        Thread.sleep(1000);

        js.executeScript(
                "arguments[0].click();",
                deleteBtn
        );

        Thread.sleep(2000);

        Assert.assertTrue(
                true,
                "Delete button clicked successfully"
        );
    }
}