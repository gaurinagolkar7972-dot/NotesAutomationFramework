package com.expandtesting.notes.tests.ui;

import com.expandtesting.notes.base.BaseTest;
import com.expandtesting.notes.config.ConfigReader;
import com.expandtesting.notes.pages.AddNotePage;
import com.expandtesting.notes.pages.HomePage;
import com.expandtesting.notes.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNoteUITest extends BaseTest {

    @Test
    public void testCreateNoteFromUI() {

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
                "UI Created Note " + System.currentTimeMillis();

        String description =
                "Created and verified from UI";

        AddNotePage addNotePage = new AddNotePage();

        addNotePage.createNote(
                title,
                description,
                "Home"
        );

        Assert.assertTrue(
                homePage.isNoteVisible(title),
                "Created note should be visible in UI list"
        );
    }
}